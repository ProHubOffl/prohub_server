package com.epicwin.prohub.model.ticket;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entity class for holding ticket comment information.
 */
@Entity
public class TicketComment {

    @Id
    @Column(name = "comment_id")
    private int commentId;
    @Column(name = "ticket_id")
    private int ticketId;
    @Column(name = "comment")
    private String comment;
    @Column(name = "comment_owner")
    private String commentOwner;
    @Column(name = "timestamp")
    private String timeStamp;

    public TicketComment() {
    }

    public TicketComment(int commentId, int ticketId, String comment, String commentOwner, String timeStamp) {
        this.commentId = commentId;
        this.ticketId = ticketId;
        this.comment = comment;
        this.commentOwner = commentOwner;
        this.timeStamp = timeStamp;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentOwner() {
        return commentOwner;
    }

    public void setCommentOwner(String commentOwner) {
        this.commentOwner = commentOwner;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
