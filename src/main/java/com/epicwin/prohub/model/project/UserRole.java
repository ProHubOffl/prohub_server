package com.epicwin.prohub.model.project;

/**
 * Resource class for containing user role data.
 */
public class UserRole {

    private String role;

    public UserRole() {}

    public UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
