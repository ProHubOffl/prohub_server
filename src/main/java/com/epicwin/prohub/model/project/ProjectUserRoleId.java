package com.epicwin.prohub.model.project;

import java.io.Serializable;
import java.util.Objects;

public class ProjectUserRoleId implements Serializable {

    private String projectName;
    private String email;

    public ProjectUserRoleId() {}

    public ProjectUserRoleId(String projectName, String email) {
        this.projectName = projectName;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectUserRoleId projectUserRoleId = (ProjectUserRoleId) o;
        return projectName.equals(projectUserRoleId.projectName) &&
                email.equals(projectUserRoleId.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectName, email);
    }
}
