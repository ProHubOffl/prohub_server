package com.epicwin.prohub.model.ticket;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity class for holding ticket information.
 */
@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue
    @Column(name = "ticket_id")
    private int ticketId;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "project_name")
    private String projectName;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "finished_at")
    private String finishedAt;
    @Column(name = "operator")
    private String operator;
    @Column(name = "status")
    private String status;

    public Ticket() {
    }

    public Ticket(int ticketId, String title, String description, String projectName,
                  String createdBy, String createdAt, String finishedAt, String operator, String status) {
        this.ticketId = ticketId;
        this.title = title;
        this.description = description;
        this.projectName = projectName;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.finishedAt = finishedAt;
        this.operator = operator;
        this.status = status;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String  getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(String finishedAt) {
        this.finishedAt = finishedAt;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
