package com.epicwin.prohub.model.backlog;

import javax.persistence.*;

@Entity
@Table(name = "backlog")
public class Backlog {

    @Id
    @GeneratedValue
    @Column(name = "backlog_id")
    private int backlogId;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "projectName")
    private String projectName;
    @Column(name = "sprint")
    private int sprint;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "assignee")
    private String assignee;
    @Column(name = "status")
    private String status;
    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "finished_at")
    private String finishedAt;
    @Column(name = "last_updated")
    private String lastUpdated;
    @Column(name = "last_updated_user")
    private String lastUpdatedUser;

    public Backlog() {
    }

    public Backlog(int backlogId, String title, String description, String projectName, int sprint, String createdBy,
                   String assignee, String status, String createdAt, String finishedAt, String lastUpdated,
                   String lastUpdatedUser) {
        this.backlogId = backlogId;
        this.title = title;
        this.description = description;
        this.projectName = projectName;
        this.sprint = sprint;
        this.createdBy = createdBy;
        this.assignee = assignee;
        this.status = status;
        this.createdAt = createdAt;
        this.finishedAt = finishedAt;
        this.lastUpdated = lastUpdated;
        this.lastUpdatedUser = lastUpdatedUser;
    }

    public Backlog(String title, String description, String projectName, int sprint, String createdBy,
                   String assignee, String status, String createdAt, String finishedAt, String lastUpdated,
                   String lastUpdatedUser) {
        this.title = title;
        this.description = description;
        this.projectName = projectName;
        this.sprint = sprint;
        this.createdBy = createdBy;
        this.assignee = assignee;
        this.status = status;
        this.createdAt = createdAt;
        this.finishedAt = finishedAt;
        this.lastUpdated = lastUpdated;
        this.lastUpdatedUser = lastUpdatedUser;
    }

    public Backlog(String title, String description, String projectName, int sprint, String createdBy,
                   String assignee, String status, String createdAt) {
        this.title = title;
        this.description = description;
        this.projectName = projectName;
        this.sprint = sprint;
        this.createdBy = createdBy;
        this.assignee = assignee;
        this.status = status;
        this.createdAt = createdAt;
    }

    public int getBacklogId() {
        return backlogId;
    }

    public void setBacklogId(int backlogId) {
        this.backlogId = backlogId;
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getSprint() {
        return sprint;
    }

    public void setSprint(int sprint) {
        this.sprint = sprint;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(String finishedAt) {
        this.finishedAt = finishedAt;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getLastUpdatedUser() {
        return lastUpdatedUser;
    }

    public void setLastUpdatedUser(String lastUpdatedUser) {
        this.lastUpdatedUser = lastUpdatedUser;
    }
}
