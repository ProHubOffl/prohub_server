package com.epicwin.prohub.repo;

import com.epicwin.prohub.model.project.ProjectUserRole;
import com.epicwin.prohub.model.project.ProjectUserRoleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for handling project user role operations.
 */
@Repository
public interface ProjectUserRoleRepo extends JpaRepository<ProjectUserRole, ProjectUserRoleId> {

    List<ProjectUserRole> findAllByEmail(String email);

    void deleteByProjectNameAndEmail(String projectName, String email);

    ProjectUserRole findByProjectNameAndEmail(String projectName, String email);
}
