package com.epicwin.prohub.model.document;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity class for holding Document information.
 */
@Entity
@Table(name = "documents")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "document_Id")
    private int documentId;
    @Column(name = "project_name")
    private String projectName;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "author")
    private String author ;
    @Column(name = "file_name")
    private String name;
    @Column(name = "file_type")
    private String type;
    @Lob
    @Column(name = "data")
    private byte[] data;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "last_updated_at")
    private Date updatedDate;

    public Document() {
    }

    public Document(int announcementId, String projectName, String title, String description, String author, String name, String type, byte[] data, Date createdDate, Date updatedDate) {
        this.documentId = announcementId;
        this.projectName = projectName;
        this.title = title;
        this.description = description;
        this.author = author;
        this.name = name;
        this.type = type;
        this.data = data;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public int getAnnouncementId() {
        return documentId;
    }

    public void setAnnouncementId(int announcementId) {
        this.documentId = announcementId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
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
