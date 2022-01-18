package com.epicwin.prohub.controller;

import com.epicwin.prohub.configuration.JwtTokenUtil;
import com.epicwin.prohub.model.authentication.*;
import com.epicwin.prohub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    public void register(@RequestBody User user) {
        userService.saveUser(user);
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

    @PutMapping("/users/{email}/changePassword")
    public void changePassword(@RequestBody PasswordRequest passwordRequest, @PathVariable String email) {
        userService.changePassword(email, passwordRequest);
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
}

