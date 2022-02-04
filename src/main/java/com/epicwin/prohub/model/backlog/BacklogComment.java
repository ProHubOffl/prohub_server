package com.epicwin.prohub.model.backlog;

import javax.persistence.*;

/**
 * Entity class for holding backlog comment information.
 */
@Entity
@Table(name = "backlog_comments")
public class BacklogComment {

    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private int commentId;
    @Column(name = "backlog_id")
    private int backlogId;
    @Column(name = "comment")
    private String comment;
    @Column(name = "comment_owner")
    private String commentOwner;
    @Column(name = "timestamp")
    private String timeStamp;

    public BacklogComment() {
    }

    public BacklogComment(int commentId, int backlogId, String comment, String commentOwner, String timeStamp) {
        this.commentId = commentId;
        this.backlogId = backlogId;
        this.comment = comment;
        this.commentOwner = commentOwner;
        this.timeStamp = timeStamp;
    }

    public BacklogComment(int backlogId, String comment, String commentOwner, String timeStamp) {
        this.backlogId = backlogId;
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

    public int getBacklogId() {
        return backlogId;
    }

    public void setBacklogId(int backlogId) {
        this.backlogId = backlogId;
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
