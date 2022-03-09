package com.epicwin.prohub.controller;

import com.epicwin.prohub.configuration.JwtTokenUtil;
import com.epicwin.prohub.model.authentication.*;
import com.epicwin.prohub.model.email.EmailRequest;
import com.epicwin.prohub.model.email.Mail;
import com.epicwin.prohub.service.MailService;
import com.epicwin.prohub.service.UserService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Controller class for handling user operations.
 */
@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseUser createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

        final UserDetails userDetails = userService
                .loadUserByUsername(authenticationRequest.getEmail());

        User user = userService.getUser(userDetails.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return new ResponseUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getDesignation(), token);
    }

    @PostMapping("/register")
    public int register(@RequestBody User user) {
        User user1 = userService.getUser(user.getEmail());
        if (Objects.isNull(user1)) {
            userService.saveUser(user);
            String title = "Welcome to ProHub";
            String content = "Hi! " + user.getFirstName() + " " + user.getLastName() + ",\n\n" +
                    "Thank you for registering to ProHub. " +
                    "Make your project management things easier with ProHub.\n\nThanks,\nTeam ProHub";
            try {
                sendEmail(user.getEmail(), title, content);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Response.SC_OK;
        } else {
            return Response.SC_BAD_REQUEST;
        }
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @GetMapping("/users")
    public List<UpdatedUser> getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<UpdatedUser> publicUsers = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            User tempUser = users.get(i);
            publicUsers.add(new UpdatedUser(tempUser.getFirstName(), tempUser.getLastName(), tempUser.getEmail(), tempUser.getDesignation()));
        }
        return publicUsers;
    }

    @GetMapping("/users/{email}")
    public UpdatedUser getUser(@PathVariable String email) {
        User user = userService.getUser(email);
        return new UpdatedUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getDesignation());
    }

    @PutMapping("/users/{email}")
    public void updateUser(@RequestBody UpdatedUser updatedUser, @PathVariable String email) {
        userService.updateUser(updatedUser);
    }

    @DeleteMapping("/users/{email}")
    public void deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
    }

    @PutMapping("/changePassword/{email}")
    public int changePassword(@RequestBody ChangePasswordRequest passwordRequest, @PathVariable String email) {
        User user = userService.getUser(email);
        if (Objects.isNull(user)) {
            return Response.SC_BAD_REQUEST;
        } else {
            if (passwordEncoder.matches(passwordRequest.getCurrentPassword(), user.getPassword())) {
                userService.changePassword(email, new PasswordRequest(passwordRequest.getNewPassword()));
                String title = "Password Changed!";
                String content = "Hi! " + user.getFirstName() + " " + user.getLastName() + ",\n\n" +
                        "This is to notify that you have changed your password.\n\nThanks,\nTeam ProHub";
                try {
                    sendEmail(user.getEmail(), title, content);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return Response.SC_OK;
            } else {
                return Response.SC_CONFLICT;
            }
        }
    }

    @PostMapping("/forgotPassword")
    public int handleForgotPassword(@RequestBody EmailRequest emailRequest) {
        User user = userService.getUser(emailRequest.getEmail());
        if (Objects.isNull(user)) {
            return Response.SC_BAD_REQUEST;
        } else {
            String newPassword = getSaltString();
            String title = "Forgot Password Notification";
            String content = "Hi! " + user.getFirstName() + " " + user.getLastName() + ",\n\n" +
                    "Your Temporary password: " + newPassword +
                    "\nNote: Use this password for signing in and change your password immediately.\n\nThanks,\nTeam ProHub";
            sendEmail(user.getEmail(), title, content);
            userService.changePassword(emailRequest.getEmail(), new PasswordRequest(newPassword));
            return Response.SC_OK;
        }
    }

    private void authenticate(String email, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    private void sendEmail(String email, String title, String content) {

        Mail mail = new Mail();
        mail.setMailFrom("prohubclient@gmail.com");
        mail.setMailTo(email);
        mail.setMailSubject(title);
        mail.setMailContent(content);

        mailService.sendEmail(mail);
    }

    private String getSaltString() {

        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
        StringBuilder salt = new StringBuilder();
        Random random = new Random();
        while (salt.length() < 18) {
            int index = (int) (random.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
}

