package com.epicwin.prohub.controller;

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
     */
    @GetMapping("/backlogComment/{backlogCommentId}")
    public BacklogComment getBacklogCommentByCommentId(@PathVariable("backlogCommentId") int backlogCommentId) {
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
     */
    @PutMapping("/backlogComment/{backlogCommentId}")
    public BacklogComment updateBacklogComment(@PathVariable("backlogCommentId") int backlogCommentId,
                                               @RequestBody BacklogComment backlogComment) {
        return backlogCommentService.updateBacklogComment(backlogCommentId, backlogComment);
    }

    /**
     * Used for deleting a backlog comment.
     *
     * @param backlogCommentId backlog comment id
     * @throws Exception when requested backlog comment not found
     */
    @DeleteMapping("/backlogComment/{backlogCommentId}")
    public void deleteBacklogComment(@PathVariable("backlogCommentId") int backlogCommentId) throws Exception {
        backlogCommentService.deleteBacklogComment(backlogCommentId);
    }
}
