package com.epicwin.prohub.repo;

import com.epicwin.prohub.model.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository for handling project operations.
 */

public interface ProjectRepo extends JpaRepository<Project, String> {
    Project findProjectByProjectName(String projectName);

    @Transactional
    void deleteProjectByProjectName(String projectName);

}
