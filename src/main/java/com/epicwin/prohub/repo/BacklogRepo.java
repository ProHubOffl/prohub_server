package com.epicwin.prohub.repo;

import com.epicwin.prohub.model.backlog.Backlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Repository for handling backlog operations.
 */
@Repository
public interface BacklogRepo extends JpaRepository<Backlog, Integer> {

    List<Backlog> findAllByProjectName(String name);

    Backlog findBacklogByBacklogIdAndProjectName(int backlogId, String projectName);

    Backlog findByBacklogId(int backlogId);
}
