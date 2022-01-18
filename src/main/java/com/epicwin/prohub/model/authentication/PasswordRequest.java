package com.epicwin.prohub.model.authentication;

/**
 * Entity class to hold information for changing password.
 */
public class PasswordRequest {

    private String password;

    public PasswordRequest(){}

    public PasswordRequest(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
