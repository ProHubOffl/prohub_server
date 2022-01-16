package com.epicwin.prohub.model.authentication;

/**
 * Entity class for holding updated user information.
 */
public class UpdatedUser {

    private String firstName;
    private String lastName;
    private String email;
    private String designation;

    public UpdatedUser() {
    }

    public UpdatedUser(String firstName, String lastName, String email, String designation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.designation = designation;
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
}
