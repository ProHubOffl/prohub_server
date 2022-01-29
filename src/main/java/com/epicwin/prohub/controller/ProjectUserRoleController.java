package com.epicwin.prohub.controller;

import com.epicwin.prohub.model.project.ProjectUserRole;
import com.epicwin.prohub.model.project.UserRole;
import com.epicwin.prohub.service.ProjectUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling project user role operations.
 */
@RestController
@Transactional
public class ProjectUserRoleController {

    @Autowired
    ProjectUserRoleService projectUserRoleService;

    /**
     * Used for getting a list of projects for a particular email.
     *
     * @param email email
     * @return a list of projects for a particular email
     */
    @GetMapping("/{email}/projectUserRole")
    public List<ProjectUserRole> getProjectsByEmail(@PathVariable("email") String email) {
        return projectUserRoleService.getProjectsByEmail(email);
    }

    /**
     * Used for getting user role by project name and user email.
     *
     * @param email       user email
     * @param projectName project name
     * @return user role based on project name and user email
     */
    @GetMapping("/{email}/projectUserRole/{projectName}")
    public ProjectUserRole getUserRoleByProjectNameAndEmail(@PathVariable("email") String email,
                                                            @PathVariable("projectName") String projectName) {
        return projectUserRoleService.getUserRoleByProjectNameAndEmail(projectName, email);
    }

    /**
     * Used for adding a new project user role.
     *
     * @param projectUserRole project user role to be added
     * @return added project user role
     */
    @PostMapping("/projectUserRole")
    public ProjectUserRole addProjectUserRole(@RequestBody ProjectUserRole projectUserRole) {
        return projectUserRoleService.addUserToProject(projectUserRole);
    }

    /**
     * Used for updating a project user role.
     *
     * @param userRole    updated user role
     * @param email       email
     * @param projectName project name
     * @return updated project user role
     */
    @PutMapping("/{email}/projectUserRole/{projectName}")
    public ProjectUserRole updateProjectUserRole(@RequestBody UserRole userRole, @PathVariable("email") String email,
                                                 @PathVariable("projectName") String projectName) {
        return projectUserRoleService.updateUserRoleInProject(projectName, email, userRole);
    }

    /**
     * Used for removing a user from a project.
     *
     * @param email       email
     * @param projectName project name
     */
    @DeleteMapping("/{email}/projectUserRole/{projectName}")
    public void removeUserFromProject(@PathVariable("email") String email, @PathVariable("projectName") String projectName) {
        projectUserRoleService.removeUserFromProject(projectName, email);
    }
}
