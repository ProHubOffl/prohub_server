package com.epicwin.prohub.response;

import javax.persistence.Column;
import javax.persistence.Lob;
import java.util.Date;

public class ResponseFile {

    private int documentId;
    private String projectName;
    private String title;
    private String description;
    private String author ;
    private String name;
    private String type;
    private String url;
    private Date createdDate;
    private Date updatedDate;
    private long size;

    public ResponseFile() {
    }

    public ResponseFile(String projectName, String title, String description, String author, String name, String type, String url, Date createdDate, Date updatedDate, long size) {
        this.projectName = projectName;
        this.title = title;
        this.description = description;
        this.author = author;
        this.name = name;
        this.type = type;
        this.url = url;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.size = size;
    }

    public ResponseFile(int documentId, String projectName, String title, String description, String author, String name, String type, String url, Date createdDate, Date updatedDate, long size) {
        this.documentId = documentId;
        this.projectName = projectName;
        this.title = title;
        this.description = description;
        this.author = author;
        this.name = name;
        this.type = type;
        this.url = url;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.size = size;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public long getSize() {
        return size;
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public void setSize(long size) {
        this.size = size;
    }
}