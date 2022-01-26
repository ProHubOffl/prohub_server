package com.epicwin.prohub.controller;

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
     */
    @PostMapping("/project")
    public Project createproject(@RequestBody Project project) {
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
     */
    @DeleteMapping("/project/{projectName}")
    public void deleteProject(@PathVariable("projectName") String projectName) {
        projectService.deleteProject(projectName);
    }

    /**
     * Used to Update a Project
     *
     * @param projectName
     * @return updated project
     */
    @PutMapping("/project/{projectName}")
    public Project updateProject(@RequestBody UpdatedProject updatedProject, @PathVariable("projectName") String projectName) {
        return projectService.updateProject(updatedProject, projectName);
    }

    /**
     * Used to get a Project details
     *
     * @param projectName
     * @return project
     */
    @GetMapping("/project/{projectName}")
    public Project getProjectByProjectName(@PathVariable("projectName") String projectName) {
        return projectService.getProjectByProjectName(projectName);
    }

}
