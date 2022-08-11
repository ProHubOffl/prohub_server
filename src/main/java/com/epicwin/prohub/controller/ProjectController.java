package com.epicwin.prohub.controller;

import com.epicwin.prohub.exception.EntityNotFoundException;
import com.epicwin.prohub.model.project.Project;
import com.epicwin.prohub.model.project.UpdatedProject;
import com.epicwin.prohub.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Controller class for handling project operations.
 */
@RestController
@CrossOrigin
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    /**
     * Used to create new Project
     *
     * @param project
     * @return created project
     * @throws Exception when project name already taken in
     */
    @PostMapping("/project")
    public Project createproject(@RequestBody Project project) throws Exception {
        return projectService.saveProject(project);
    }

    /**
     * Used to get all Projects
     *
     * @return all projects
     */
    @GetMapping("/project")
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    /**
     * Used to delete a Project
     *
     * @param projectName
     * @return deleted project
     * @throws EntityNotFoundException when requested project entity not found
     */
    @DeleteMapping("/project/{projectName}")
    public void deleteProject(@PathVariable("projectName") String projectName) throws EntityNotFoundException {
        projectService.deleteProject(projectName);
    }

    /**
     * Used to Update a Project
     *
     * @param projectName
     * @return updated project
     * @throws EntityNotFoundException when requested project entity not found
     */
    @PutMapping("/project/{projectName}")
    public Project updateProject(@RequestBody UpdatedProject updatedProject,
                                 @PathVariable("projectName") String projectName) throws EntityNotFoundException {
        return projectService.updateProject(updatedProject, projectName);
    }

    /**
     * Used to get a Project details
     *
     * @param projectName
     * @return project
     * @throws EntityNotFoundException when requested project entity not found
     */
    @GetMapping("/project/{projectName}")
    public Project getProjectByProjectName(@PathVariable("projectName") String projectName) throws EntityNotFoundException {
        return projectService.getProjectByProjectName(projectName);
    }

}
