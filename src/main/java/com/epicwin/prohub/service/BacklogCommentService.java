package com.epicwin.prohub.service;

import com.epicwin.prohub.exception.EntityNotFoundException;
import com.epicwin.prohub.model.backlog.BacklogComment;
import com.epicwin.prohub.repo.BacklogCommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Service class for handling backlog comment operations.
 */
@Service
public class BacklogCommentService {

    @Autowired
    BacklogCommentRepo backlogCommentRepo;

    /**
     * Used for getting list of backlog comments for a backlog.
     *
     * @param backlogId backlog id
     * @return list of backlog comments for a backlog
     */
    public List<BacklogComment> getBackLogCommentsByBacklog(int backlogId) {
        return backlogCommentRepo.findAllByBacklogId(backlogId);
    }

    /**
     * Used for getting backlog comment based on comment id.
     *
     * @param commentId comment id
     * @return backlog comment entity
     * @throws EntityNotFoundException when requested backlog comment entity not found
     */
    public BacklogComment getBacklogCommentByCommentId(int commentId) throws EntityNotFoundException {
        BacklogComment backlogComment = backlogCommentRepo.findBacklogCommentByCommentId(commentId);
        if (Objects.isNull(backlogComment)) {
            throw new EntityNotFoundException("Requested Backlog Comment Entity Not Found");
        } else {
            return backlogComment;
        }
    }

    /**
     * Used for adding a backlog comment.
     *
     * @param backlogComment new backlog comment entity
     * @return added backlog comment entity
     */
    public BacklogComment addBacklogComment(BacklogComment backlogComment) {
        return backlogCommentRepo.save(backlogComment);
    }

    /**
     * Used for updating a backlog comment.
     *
     * @param commentId      comment id
     * @param backlogComment modified backlog comment entity
     * @return updated backlog comment entity
     * @throws EntityNotFoundException when requested backlog comment entity not found
     */
    public BacklogComment updateBacklogComment(int commentId, BacklogComment backlogComment)
            throws EntityNotFoundException {
        BacklogComment oldBacklogComment = backlogCommentRepo.findBacklogCommentByCommentId(commentId);
        if (Objects.isNull(oldBacklogComment)) {
            throw new EntityNotFoundException("Requested Backlog Comment Entity Not Found");
        } else {
            backlogComment.setCommentId(commentId);
            return backlogCommentRepo.save(backlogComment);
        }
    }

    /**
     * Used for deleting a backlog comment.
     *
     * @param commentId comment id
     * @throws EntityNotFoundException when requested backlog comment entity not found
     */
    public void deleteBacklogComment(int commentId) throws EntityNotFoundException {
        BacklogComment backlogComment = getBacklogCommentByCommentId(commentId);
        if (Objects.isNull(backlogComment)) {
            throw new EntityNotFoundException("Requested Backlog Comment Entity Not found");
        } else {
            backlogCommentRepo.delete(backlogComment);
        }
    }
}
