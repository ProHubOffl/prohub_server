package com.epicwin.prohub.service;

import com.epicwin.prohub.model.backlog.Backlog;
import com.epicwin.prohub.repo.BacklogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Service class for handling backlog operations.
 */
@Service
public class BacklogService {

    @Autowired
    BacklogRepo backlogRepo;

    /**
     * Used for getting backlog list by project name.
     *
     * @param projectName project name
     * @return backlog list by project name
     */
    public List<Backlog> getBacklogsByProject(String projectName) {
        return backlogRepo.findAllByProjectName(projectName);
    }

    /**
     * Used for getting backlog by backlog id.
     *
     * @param backlogId backlog id
     * @return backlog entity
     */
    public Backlog getBacklogByBacklogId(int backlogId) {
        return backlogRepo.findByBacklogId(backlogId);
    }

    /**
     * Used for getting backlog by backlog id and project name.
     *
     * @param backlogId   backlog id
     * @param projectName project name
     * @return backlog entity
     */
    public Backlog getBacklogByBacklogIdAndProjectName(int backlogId, String projectName) {
        return backlogRepo.findBacklogByBacklogIdAndProjectName(backlogId, projectName);
    }

    /**
     * Used for creating new backlog item.
     *
     * @param backlog new backlog entity
     * @return created backlog entity
     */
    public Backlog createBacklogItem(Backlog backlog) {
        return backlogRepo.save(backlog);
    }

    /**
     * Used for updating backlog.
     *
     * @param backlogId backlog id
     * @param backlog   updated backlog entity
     * @return updated backlog entity
     */
    public Backlog updateBacklog(int backlogId, Backlog backlog) {
        backlog.setBacklogId(backlogId);
        return backlogRepo.save(backlog);
    }

    /**
     * Used for deleting backlog.
     *
     * @param backlogId backlog id
     * @throws Exception when requested backlog entity not found
     */
    public void deleteBacklogItem(int backlogId) throws Exception {
        Backlog backlog = getBacklogByBacklogId(backlogId);
        if (!Objects.isNull(backlog)) {
            backlogRepo.delete(backlog);
        } else {
            throw new Exception("Requested Entity not found");
        }
    }

}
