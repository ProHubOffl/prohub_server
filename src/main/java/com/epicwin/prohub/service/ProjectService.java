package com.epicwin.prohub.service;

import com.epicwin.prohub.exception.EntityNotFoundException;
import com.epicwin.prohub.model.project.Project;
import com.epicwin.prohub.model.project.UpdatedProject;
import com.epicwin.prohub.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Service class for handling project operations.
 */
@Service
public class ProjectService {
    @Autowired
    ProjectRepo projectRepo;

    /**
     * Used to create new Project
     *
     * @param project
     * @return created project
     */
    public Project saveProject(Project project) {
        return projectRepo.save(project);
    }

    /**
     * Used to get all Projects
     *
     * @return all projects
     */
    public List<Project> getAllProjects() throws EntityNotFoundException {

        List<Project> projects =  projectRepo.findAll();
        if(projects.isEmpty()) {
            throw new EntityNotFoundException("Unable to retrieve the list of projects");
        }
        return projects;
    }

    /**
     * Used to delete a Project
     *
     * @param projectName
     * @return deleted project
     */
    public void deleteProject(String projectName) {
        projectRepo.deleteProjectByProjectName(projectName);
    }

    /**
     * Used to Update a Project
     *
     * @param projectName
     * @return updated project
     */
    public Project updateProject(UpdatedProject updatedProject,String projectName) {
        Project project = projectRepo.findProjectByProjectName(projectName);
        project.setTeamName(updatedProject.getTeamName());
        project.setProjectDescription(updatedProject.getProjectDescription());
        project.setProjectType(updatedProject.getProjectType());
        project.setStoryPoints(updatedProject.getStoryPoints());
        project.setTotalSprints(updatedProject.getTotalSprints());
        project.setStartDate(updatedProject.getStartDate());
        project.setEndDate(updatedProject.getEndDate());
        return projectRepo.save(project);
    }

    /**
     * Used to get a Project details
     *
     * @param projectName
     * @return project
     */
    public Project getProjectByProjectName(String projectName) throws EntityNotFoundException {
        Project project = projectRepo.findProjectByProjectName(projectName);
        if(Objects.isNull(project)) {
            throw new EntityNotFoundException("Requested Project Details Not Found");
        }
        return project;
    }

}
