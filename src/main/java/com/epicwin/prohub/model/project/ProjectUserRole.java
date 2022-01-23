package com.epicwin.prohub.model.project;

import javax.persistence.*;

/**
 * Entity class for containing Project User Role data.
 */
@Entity
@Table(name = "project_user_roles")
@IdClass(ProjectUserRoleId.class)
public class ProjectUserRole {

    @Id
    @Column(name = "project_name")
    private String projectName;
    @Id
    @Column(name = "email")
    private String email;
    @Column(name = "role")
    private String role;

    public ProjectUserRole() {}

    public ProjectUserRole(String projectName, String email, String role) {
        this.projectName = projectName;
        this.email = email;
        this.role = role;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
