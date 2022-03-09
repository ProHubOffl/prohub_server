package com.epicwin.prohub.controller;

import com.epicwin.prohub.exception.EntityNotFoundException;
import com.epicwin.prohub.model.backlog.Backlog;
import com.epicwin.prohub.service.BacklogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling backlog operations.
 */
@RestController
@Transactional
public class BacklogController {

    @Autowired
    BacklogService backlogService;

    /**
     * Used for getting list of backlog items for a project.
     *
     * @param projectName project name
     * @return list of backlog items
     */
    @GetMapping("/{projectName}/backlog")
    public List<Backlog> getBacklogByProject(@PathVariable("projectName") String projectName) {
        return backlogService.getBacklogsByProject(projectName);
    }

    /**
     * Used for getting backlog based on backlog id.
     *
     * @param backlogId backlog id
     * @return backlog entity
     * @throws EntityNotFoundException when requested backlog entity not found
     */
    @GetMapping("/backlog/{backlogId}")
    public Backlog getBackLogByBackLogId(@PathVariable("backlogId") int backlogId) throws EntityNotFoundException {
        return backlogService.getBacklogByBacklogId(backlogId);
    }

    /**
     * Used for getting backlog based on backlog id and project name.
     *
     * @param projectName project name
     * @param backlogId   backlog id
     * @return backlog entity
     * @throws EntityNotFoundException when requested backlog entity not found
     */
    @GetMapping("/{projectName}/backlog/{backlogId}")
    public Backlog getBacklogByProjectNameAndBacklogId(@PathVariable("projectName") String projectName,
                                           @PathVariable("backlogId") int backlogId) throws EntityNotFoundException {
        return backlogService.getBacklogByBacklogIdAndProjectName(backlogId, projectName);
    }

    /**
     * Used for creating new backlog item.
     *
     * @param backlog new backlog entity
     * @return created backlog entity
     */
    @PostMapping("/backlog")
    public Backlog createBacklogItem(@RequestBody Backlog backlog) {
        return backlogService.createBacklogItem(backlog);
    }

    /**
     * Used for updating a backlog item.
     *
     * @param backlogId backlog id
     * @param backlog   updated backlog entity
     * @return updated backlog entity
     * @throws EntityNotFoundException when requested backlog entity not found
     */
    @PutMapping("/backlog/{backlogId}")
    public Backlog updateBacklogItem(@PathVariable("backlogId") int backlogId,
                                     @RequestBody Backlog backlog) throws EntityNotFoundException {
        return backlogService.updateBacklog(backlogId, backlog);
    }

    /**
     * Used for deleting a backlog item.
     *
     * @param backlogId backlog id
     * @throws EntityNotFoundException when requested backlog entity not found
     */
    @DeleteMapping("/backlog/{backlogId}")
    public void deleteBacklogItem(@PathVariable("backlogId") int backlogId) throws EntityNotFoundException {
        backlogService.deleteBacklogItem(backlogId);
    }
}
