package com.epicwin.prohub.service;

import com.epicwin.prohub.exception.EntityNotFoundException;
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
     * @throws EntityNotFoundException when requested backlog entity not found
     */
    public Backlog getBacklogByBacklogId(int backlogId) throws EntityNotFoundException {
        Backlog backlog = backlogRepo.findByBacklogId(backlogId);
        if (Objects.isNull(backlog)) {
            throw new EntityNotFoundException("Requested Backlog Entity Not Found");
        } else {
            return backlog;
        }
    }

    /**
     * Used for getting backlog by backlog id and project name.
     *
     * @param backlogId   backlog id
     * @param projectName project name
     * @return backlog entity
     * @throws EntityNotFoundException when requested backlog entity not found
     */
    public Backlog getBacklogByBacklogIdAndProjectName(int backlogId, String projectName)
            throws EntityNotFoundException {
        Backlog backlog = backlogRepo.findBacklogByBacklogIdAndProjectName(backlogId, projectName);
        if (Objects.isNull(backlog)) {
            throw new EntityNotFoundException("Requested Backlog Entity Not Found");
        } else {
            return backlog;
        }
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
     * @throws EntityNotFoundException when requested backlog entity not found
     */
    public Backlog updateBacklog(int backlogId, Backlog backlog) throws EntityNotFoundException {
        Backlog oldBacklog = getBacklogByBacklogId(backlogId);
        if (Objects.isNull(oldBacklog)) {
            throw new EntityNotFoundException("Requested Backlog Entity Not Found");
        } else {
            backlog.setBacklogId(backlogId);
            return backlogRepo.save(backlog);
        }
    }

    /**
     * Used for deleting backlog.
     *
     * @param backlogId backlog id
     * @throws EntityNotFoundException when requested backlog entity not found
     */
    public void deleteBacklogItem(int backlogId) throws EntityNotFoundException {
        Backlog backlog = getBacklogByBacklogId(backlogId);
        if (!Objects.isNull(backlog)) {
            backlogRepo.delete(backlog);
        } else {
            throw new EntityNotFoundException("Requested Backlog Entity Not Found");
        }
    }

    /**
     * Used for getting backlog based on email and projectName.
     *
     * @param email email
     * @param projectName project name
     * @return backlog entity
     */
    public List<Backlog> getBacklogByEmailAndProjectName(String projectName, String email) {
        return backlogRepo.findAllByAssigneeAndProjectName(email, projectName);
    }

    /**
     *  Used for getting backlog based on email.
     *
     * @param email
     * @return backlog entity
     */
    public List<Backlog> getBacklogByEmail(String email) {
        return backlogRepo.findAllByAssignee(email);
    }
}
