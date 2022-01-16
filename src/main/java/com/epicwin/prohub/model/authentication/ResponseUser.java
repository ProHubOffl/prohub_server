package com.epicwin.prohub.model.authentication;

/**
 * Entity class for holding user information after logged in.
 */
public class ResponseUser {

    private String firstName;
    private String lastName;
    private String email;
    private String designation;
    private String jwtToken;

    public ResponseUser(){}

    public ResponseUser(String firstName, String lastName, String email, String designation, String jwtToken) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.designation = designation;
        this.jwtToken = jwtToken;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
