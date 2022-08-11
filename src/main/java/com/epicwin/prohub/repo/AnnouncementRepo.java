package com.epicwin.prohub.repo;

import com.epicwin.prohub.model.announcement.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Repository for handling Announcement operations.
 */
@Repository
public interface AnnouncementRepo extends JpaRepository<Announcement, Integer> {

    List<Announcement> findAllByProjectName(String projectName);

    Announcement findAnnouncementByAnnouncementId(int announcementid);

    Announcement findAnnouncementByAnnouncementIdAndProjectName(int announcementid, String projectName);

    Integer countAnnouncementByProjectName(String projectName);

}
