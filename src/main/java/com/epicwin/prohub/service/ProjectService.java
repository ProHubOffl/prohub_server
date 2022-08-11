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
     * @throws Exception when project name already taken in
     */
    public Project saveProject(Project project) throws Exception {
        Project oldProject = projectRepo.findProjectByProjectName(project.getProjectName());
        if(Objects.isNull(oldProject)){
            return projectRepo.save(project);
        }
        else {
            throw new Exception("Project Name Already Taken In");
        }
    }

    /**
     * Used to get all Projects
     *
     * @return all projects
     */
    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }

    /**
     * Used to delete a Project
     *
     * @param projectName
     * @return deleted project
     * @throws EntityNotFoundException when requested project entity not found
     */
    public void deleteProject(String projectName) throws EntityNotFoundException {
        Project project = projectRepo.findProjectByProjectName(projectName);
        if (Objects.isNull(project)) {
            throw new EntityNotFoundException("Requested Project Details Not Found");
        } else {
            projectRepo.deleteProjectByProjectName(projectName);
        }
    }

    /**
     * Used to update a project
     *
     * @param updatedProject updated project
     * @param projectName    project name
     * @return updated project
     * @throws EntityNotFoundException when requested project entity not found
     */
    public Project updateProject(UpdatedProject updatedProject, String projectName) throws EntityNotFoundException {
        Project project = projectRepo.findProjectByProjectName(projectName);
        if (Objects.isNull(project)) {
            throw new EntityNotFoundException("Requested Project Details Not Found");
        } else {
            project.setTeamName(updatedProject.getTeamName());
            project.setProjectDescription(updatedProject.getProjectDescription());
            project.setProjectType(updatedProject.getProjectType());
            project.setStoryPoints(updatedProject.getStoryPoints());
            project.setTotalSprints(updatedProject.getTotalSprints());
            project.setStartDate(updatedProject.getStartDate());
            project.setEndDate(updatedProject.getEndDate());
            return projectRepo.save(project);
        }
    }

    /**
     * Used to get a Project details
     *
     * @param projectName
     * @return project
     * @throws EntityNotFoundException when requested project entity not found
     */
    public Project getProjectByProjectName(String projectName) throws EntityNotFoundException {
        Project project = projectRepo.findProjectByProjectName(projectName);
        if (Objects.isNull(project)) {
            throw new EntityNotFoundException("Requested Project Details Not Found");
        }
        return project;
    }

}
