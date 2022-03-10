package com.epicwin.prohub.controller;

import com.epicwin.prohub.model.announcement.Announcement;
import com.epicwin.prohub.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
     * @param announcement_Id announcement id
     * @return Announcement entity
     */
    @GetMapping("/announcement/{announcementId}")
    public Announcement getAnnouncementByAnnouncementId(@PathVariable("announcementId") int announcement_Id) {
        return announcementService.getAnnouncementByAnnouncementId(announcement_Id);
    }

    /**
     * Used for getting Announcement based on announcement id and project name.
     *
     * @param projectName project name
     * @param announcement_Id   announcement id
     * @return Announcement entity
     */
    @GetMapping("/{projectName}/announcement/{announcementId}")
    public Announcement getAnnouncementByAnnouncementIdAndProjectName(@PathVariable("projectName") String projectName,
                                                       @PathVariable("announcementId") int announcement_Id) {
        return announcementService.getAnnouncementByAnnouncementIdAndProjectName(announcement_Id, projectName);
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
     * @param announcement_Id Announcement id
     * @param announcement updated Announcement entity
     * @return updated Announcement entity
     */
    @PutMapping("/announcement/{announcementId}")
    public Announcement updateAnnouncementItem(@PathVariable("announcementId") int announcement_Id, @RequestBody Announcement announcement) {
        return announcementService.updateAnnouncementItem(announcement_Id, announcement);
    }

    /**
     * Used for deleting an Announcement item.
     *
     * @param announcement_Id Announcement id
     * @throws Exception when requested Announcement entity not found
     */
    @DeleteMapping("/announcement/{announcementId}")
    public void deleteAnnouncementItem(@PathVariable("announcementId") int announcement_Id) throws Exception {
        announcementService.deleteAnnouncementItem(announcement_Id);
    }
}
