package com.epicwin.prohub.model.announcement;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity class for holding Announcement information.
 */
@Entity
@Table(name = "announcements")
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "announcement_Id")
    private int announcementId;
    @Column(name = "project_name")
    private String projectName;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "author")
    private String author ;
    @Column(name = "created_date")
    private String createdDate;
    @Column(name = "last_updated_at")
    private String updatedDate;

    public Announcement(){
    }

    public Announcement(int announcementId, String projectName, String title, String description, String author, String createdDate, String updatedDate) {
        this.announcementId = announcementId;
        this.projectName = projectName;
        this.title = title;
        this.description = description;
        this.author = author;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public int getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(int announcementId) {
        this.announcementId = announcementId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }
}
