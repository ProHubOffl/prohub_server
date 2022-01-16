package com.epicwin.prohub.service;


import com.epicwin.prohub.model.authentication.UpdatedUser;
import com.epicwin.prohub.repo.UserRepo;
import com.epicwin.prohub.model.authentication.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class for handling user operations.
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findUserByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                new ArrayList<>());
    }

    public void saveUser(User user) {
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        userRepo.save(user);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUser(String email) {
        return userRepo.findUserByEmail(email);
    }

    public void deleteUser(String email) {
        userRepo.deleteUserByEmail(email);
    }

    public void updateUser(UpdatedUser updatedUser) {
        User user = userRepo.findUserByEmail(updatedUser.getEmail());
        user.setFirstName(updatedUser.getFirstName());
        user.setEmail(updatedUser.getEmail());
        user.setDesignation(updatedUser.getDesignation());
        userRepo.save(user);
    }
}
