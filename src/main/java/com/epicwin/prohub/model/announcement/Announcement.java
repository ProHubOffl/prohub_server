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
    private int announcement_Id;
    @Column(name = "project_name")
    private String projectName;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "author")
    private String author ;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "last_updated_at")
    private Date updatedDate;

    public Announcement(){
    }

    public Announcement(int announcement_Id, String projectName, String title, String description, String author, Date createdDate, Date updatedDate) {
        this.announcement_Id = announcement_Id;
        this.projectName = projectName;
        this.title = title;
        this.description = description;
        this.author = author;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public int getAnnouncement_Id() {
        return announcement_Id;
    }

    public void setAnnouncement_Id(int announcement_Id) {
        this.announcement_Id = announcement_Id;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
