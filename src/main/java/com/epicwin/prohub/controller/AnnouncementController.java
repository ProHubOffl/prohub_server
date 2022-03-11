package com.epicwin.prohub.controller;

import com.epicwin.prohub.model.announcement.Announcement;
import com.epicwin.prohub.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Controller class for handling Announcement operations.
 */
@RestController
@Transactional
public class AnnouncementController {

    @Autowired
    AnnouncementService announcementService;

    /**
     * Used for getting list of Announcement items for a project.
     *
     * @param projectName project name
     * @return list of Announcement items
     */
    @GetMapping("/{projectName}/announcement")
    public List<Announcement> getAnnouncementsByProject(@PathVariable("projectName") String projectName) {
        return announcementService.getAnnouncementsByProject(projectName);
    }

    /**
     * Used for getting Announcement based on announcement id.
     *
     * @param announcementId announcement id
     * @return Announcement entity
     * @throws EntityNotFoundException when requested Announcement entity not found
     */
    @GetMapping("/announcement/{announcementId}")
    public Announcement getAnnouncementByAnnouncementId(@PathVariable("announcementId") int announcementId) throws EntityNotFoundException {
        return announcementService.getAnnouncementByAnnouncementId(announcementId);
    }

    /**
     * Used for getting Announcement based on announcement id and project name.
     *
     * @param projectName project name
     * @param announcementId   announcement id
     * @return Announcement entity
     * @throws EntityNotFoundException when requested Announcement entity not found
     */
    @GetMapping("/{projectName}/announcement/{announcementId}")
    public Announcement getAnnouncementByAnnouncementIdAndProjectName(@PathVariable("projectName") String projectName,
                                                       @PathVariable("announcementId") int announcementId) throws EntityNotFoundException {
        return announcementService.getAnnouncementByAnnouncementIdAndProjectName(announcementId, projectName);
    }

    /**
     * Used for creating new Announcement item.
     *
     * @param announcement new Announcement entity
     * @return created Announcement entity
     */
    @PostMapping("/announcement")
    public Announcement createAnnouncement(@RequestBody Announcement announcement) {
        return announcementService.createAnnouncement(announcement);
    }

    /**
     * Used for updating an Announcement item.
     *
     * @param announcementId Announcement id
     * @param announcement updated Announcement entity
     * @return updated Announcement entity
     * @throws EntityNotFoundException when requested Announcement entity not found
     */
    @PutMapping("/announcement/{announcementId}")
    public Announcement updateAnnouncementItem(@PathVariable("announcementId") int announcementId, @RequestBody Announcement announcement) throws EntityNotFoundException {
        return announcementService.updateAnnouncementItem(announcementId, announcement);
    }

    /**
     * Used for deleting an Announcement item.
     *
     * @param announcementId Announcement id
     * @throws EntityNotFoundException when requested Announcement entity not found
     */
    @DeleteMapping("/announcement/{announcementId}")
    public void deleteAnnouncementItem(@PathVariable("announcementId") int announcementId) throws EntityNotFoundException {
        announcementService.deleteAnnouncementItem(announcementId);
    }
}
