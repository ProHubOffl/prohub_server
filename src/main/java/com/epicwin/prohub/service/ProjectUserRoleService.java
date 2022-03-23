package com.epicwin.prohub.service;

import com.epicwin.prohub.model.project.ProjectUserRole;
import com.epicwin.prohub.model.project.UserRole;
import com.epicwin.prohub.repo.ProjectUserRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for handling project user role operations.
 */
@Service
public class ProjectUserRoleService {

    @Autowired
    ProjectUserRoleRepo projectUserRoleRepo;

    /**
     * Used to get a list of project user roles for an email.
     *
     * @param email email
     * @return a list of project user roles for the given email
     */
    public List<ProjectUserRole> getProjectsByEmail(String email) {
        return projectUserRoleRepo.findAllByEmail(email);
    }

    /**
     * Used to get a list of project user roles for a project.
     *
     * @param projectName project name
     * @return a list of project user roles for the given project
     */
    public List<ProjectUserRole> getUsersByProject(String projectName) {
        return projectUserRoleRepo.findAllByProjectName(projectName);
    }

    /**
     * Used for getting user role by project name and user email.
     *
     * @param projectName project name
     * @param email       user name
     * @return user role based on project name and user email
     */
    public ProjectUserRole getUserRoleByProjectNameAndEmail(String projectName, String email) {
        return projectUserRoleRepo.findByProjectNameAndEmail(projectName, email);
    }

    /**
     * Used to add a project user role to the database.
     *
     * @param projectUserRole project user role
     * @return added project user role entity
     */
    public ProjectUserRole addUserToProject(ProjectUserRole projectUserRole) {
        return projectUserRoleRepo.save(projectUserRole);
    }

    /**
     * Used to remove a user from a project.
     *
     * @param projectName project name
     * @param email       email
     */
    public void removeUserFromProject(String projectName, String email) {
        projectUserRoleRepo.deleteByProjectNameAndEmail(projectName, email);
    }

    /**
     * Used to update an user's role in a project.
     *
     * @param projectName project name
     * @param email       email
     * @param userRole    user role
     * @return updated project user role entity
     */
    public ProjectUserRole updateUserRoleInProject(String projectName, String email, UserRole userRole) {
        ProjectUserRole projectUserRole = projectUserRoleRepo.findByProjectNameAndEmail(projectName, email);
        projectUserRole.setRole(userRole.getRole());
        return projectUserRoleRepo.save(projectUserRole);
    }
}
