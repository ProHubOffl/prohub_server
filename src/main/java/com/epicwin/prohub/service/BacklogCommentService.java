package com.epicwin.prohub.service;

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
     */
    public BacklogComment getBacklogCommentByCommentId(int commentId) {
        return backlogCommentRepo.findBacklogCommentByCommentId(commentId);
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
     */
    public BacklogComment updateBacklogComment(int commentId, BacklogComment backlogComment) {
        backlogComment.setCommentId(commentId);
        return backlogCommentRepo.save(backlogComment);
    }

    /**
     * Used for deleting a backlog comment.
     *
     * @param commentId comment id
     * @throws Exception when requested backlog comment not found
     */
    public void deleteBacklogComment(int commentId) throws Exception {
        BacklogComment backlogComment = getBacklogCommentByCommentId(commentId);
        if (Objects.isNull(backlogComment)) {
            throw new Exception("Requested Backlog Comment Entity Not found");
        } else {
            backlogCommentRepo.delete(backlogComment);
        }
    }
}
