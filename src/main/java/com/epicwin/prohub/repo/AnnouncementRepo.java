package com.epicwin.prohub.repo;

import com.epicwin.prohub.model.announcement.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * Repository for handling Announcement operations.
 */
public interface AnnouncementRepo extends JpaRepository<Announcement, Integer> {

    List<Announcement> findAllByProjectName(String projectName);

    @Query(value = "SELECT a FROM Announcement a where a.announcement_Id=:announcement_id")
    Announcement FindByAnnouncementId(int announcement_id);

    @Query(value = "SELECT a FROM Announcement a where a.announcement_Id=:announcement_id AND a.projectName=:projectName")
    Announcement findAnnouncementByAnnouncementIdAndProjectName(int announcement_id, String projectName);

}
