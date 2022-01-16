package com.epicwin.prohub.model.userImage;

/**
 * Entity class for holding user image response message.
 */
public class UserImageResponseMessage {

    private String message;

    public UserImageResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
