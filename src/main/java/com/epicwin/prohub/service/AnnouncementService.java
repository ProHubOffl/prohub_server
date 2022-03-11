package com.epicwin.prohub.service;

import com.epicwin.prohub.model.announcement.Announcement;
import com.epicwin.prohub.repo.AnnouncementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
     * @param announcementId announcement id
     * @return Announcement entity
     * @throws EntityNotFoundException when requested Announcement entity not found
     */
    public Announcement getAnnouncementByAnnouncementId(int announcementId) throws EntityNotFoundException {
        Announcement announcement = announcementRepo.findAnnouncementByAnnouncementId(announcementId);
        if (Objects.isNull(announcement)) {
            throw new EntityNotFoundException("Requested Announcement Entity Not Found");
        } else {
            return announcement;
        }
    }

    /**
     * Used for getting Announcement by announcement id and project name.
     *
     * @param announcementId   Announcement id
     * @param projectName project name
     * @return Announcement entity
     * @throws EntityNotFoundException when requested Announcement entity not found
     */
    public Announcement getAnnouncementByAnnouncementIdAndProjectName(int announcementId, String projectName) throws EntityNotFoundException {
        Announcement announcement = announcementRepo.findAnnouncementByAnnouncementIdAndProjectName(announcementId, projectName);
        if (Objects.isNull(announcement)) {
            throw new EntityNotFoundException("Requested Announcement Entity Not Found");
        } else {
            return announcement;
        }
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
     * @param announcementId Announcement id
     * @param announcement updated Announcement entity
     * @return updated Announcement entity
     * @throws EntityNotFoundException when requested Announcement entity not found
     */
    public Announcement updateAnnouncementItem(int announcementId, Announcement announcement) throws EntityNotFoundException {

        Announcement oldAnnouncement = getAnnouncementByAnnouncementId(announcementId);
        if (Objects.isNull(oldAnnouncement)) {
            throw new EntityNotFoundException("Requested Announcement Entity Not Found");
        } else {
            announcement.setAnnouncementId(announcementId);
            return announcementRepo.save(announcement);
        }
    }

    /**
     * Used for deleting Announcement.
     *
     * @param announcementId Announcement id
     * @throws EntityNotFoundException when requested Announcement entity not found
     */
    public void deleteAnnouncementItem(int announcementId) throws EntityNotFoundException  {
        Announcement announcement = getAnnouncementByAnnouncementId(announcementId);
        if (!Objects.isNull(announcement)) {
            announcementRepo.delete(announcement);
        } else {
            throw new EntityNotFoundException ("Requested Announcement Entity Not Found");
        }
    }

}
