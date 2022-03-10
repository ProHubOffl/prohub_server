package com.epicwin.prohub.service;

import com.epicwin.prohub.model.announcement.Announcement;
import com.epicwin.prohub.repo.AnnouncementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Service class for handling Announcement operations.
 */
@Service
public class AnnouncementService {

    @Autowired
    AnnouncementRepo announcementRepo;

    /**
     * Used for getting Announcement list by project name.
     *
     * @param projectName project name
     * @return Announcement list by project name
     */
    public List<Announcement> getAnnouncementsByProject(String projectName) {
        return announcementRepo.findAllByProjectName(projectName);
    }

    /**
     * Used for getting Announcement by announcement id.
     *
     * @param announcement_Id announcement id
     * @return Announcement entity
     */
    public Announcement getAnnouncementByAnnouncementId(int announcement_Id) {
        return announcementRepo.FindByAnnouncementId(announcement_Id);
    }

    /**
     * Used for getting Announcement by announcement id and project name.
     *
     * @param announcement_Id   Announcement id
     * @param projectName project name
     * @return Announcement entity
     */
    public Announcement getAnnouncementByAnnouncementIdAndProjectName(int announcement_Id, String projectName) {
        return announcementRepo.findAnnouncementByAnnouncementIdAndProjectName(announcement_Id, projectName);
    }

    /**
     * Used for creating new Announcement item.
     *
     * @param announcement new Announcement entity
     * @return created Announcement entity
     */
    public Announcement createAnnouncement(Announcement announcement) {
        return announcementRepo.save(announcement);
    }

    /**
     * Used for updating Announcement.
     *
     * @param announcement_Id Announcement id
     * @param announcement updated Announcement entity
     * @return updated Announcement entity
     */
    public Announcement updateAnnouncementItem(int announcement_Id, Announcement announcement) {
        announcement.setAnnouncement_Id(announcement_Id);
        return announcementRepo.save(announcement);
    }

    /**
     * Used for deleting Announcement.
     *
     * @param announcement_Id Announcement id
     * @throws Exception when requested Announcement entity not found
     */
    public void deleteAnnouncementItem(int announcement_Id) throws Exception {
        Announcement announcement = getAnnouncementByAnnouncementId(announcement_Id);
        if (!Objects.isNull(announcement)) {
            announcementRepo.delete(announcement);
        } else {
            throw new Exception("Requested Entity not found");
        }
    }

}
