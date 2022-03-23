package com.epicwin.prohub.controller;

import com.epicwin.prohub.exception.EntityNotFoundException;
import com.epicwin.prohub.model.backlog.BacklogComment;
import com.epicwin.prohub.service.BacklogCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling backlog comment operations.
 */
@RestController
@Transactional
public class BacklogCommentController {

    @Autowired
    BacklogCommentService backlogCommentService;

    /**
     * Used for getting list of backlog comments for a backlog.
     *
     * @param backlogId backlog id
     * @return list of backlog comments for a backlog
     */
    @GetMapping("/backlog/backlogComment/{backlogId}")
    public List<BacklogComment> getBacklogCommentsForBacklog(@PathVariable("backlogId") int backlogId) {
        return backlogCommentService.getBackLogCommentsByBacklog(backlogId);
    }

    /**
     * Used for getting backlog comment based on comment id.
     *
     * @param backlogCommentId backlog comment id
     * @return backlog comment entity
     * @throws EntityNotFoundException when requested backlog comment entity not found
     */
    @GetMapping("/backlogComment/{backlogCommentId}")
    public BacklogComment getBacklogCommentByCommentId(@PathVariable("backlogCommentId") int backlogCommentId)
            throws EntityNotFoundException {
        return backlogCommentService.getBacklogCommentByCommentId(backlogCommentId);
    }

    /**
     * Used for adding a backlog comment.
     *
     * @param backlogComment new backlog comment
     * @return added backlog comment
     */
    @PostMapping("/backlogComment")
    public BacklogComment addBacklogComment(@RequestBody BacklogComment backlogComment) {
        return backlogCommentService.addBacklogComment(backlogComment);
    }

    /**
     * Used for updating a backlog comment.
     *
     * @param backlogCommentId backlog comment id
     * @param backlogComment   modified backlog comment
     * @return updated backlog comment
     * @throws EntityNotFoundException when requested backlog comment entity not found
     */
    @PutMapping("/backlogComment/{backlogCommentId}")
    public BacklogComment updateBacklogComment(@PathVariable("backlogCommentId") int backlogCommentId,
                                               @RequestBody BacklogComment backlogComment) throws EntityNotFoundException {
        return backlogCommentService.updateBacklogComment(backlogCommentId, backlogComment);
    }

    /**
     * Used for deleting a backlog comment.
     *
     * @param backlogCommentId backlog comment id
     * @throws EntityNotFoundException when requested backlog comment entity not found
     */
    @DeleteMapping("/backlogComment/{backlogCommentId}")
    public void deleteBacklogComment(@PathVariable("backlogCommentId") int backlogCommentId)
            throws EntityNotFoundException {
        backlogCommentService.deleteBacklogComment(backlogCommentId);
    }
}
