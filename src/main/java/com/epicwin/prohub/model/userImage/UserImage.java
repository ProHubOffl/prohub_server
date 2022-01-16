package com.epicwin.prohub.model.userImage;


import javax.persistence.*;

/**
 * Entity class for holding user image information.
 */
@Entity
@Table(name = "user_images")
public class UserImage {

    @Column
    private String name;
    @Column
    private String type;
    @Lob
    @Column
    private byte[] data;
    @Id
    @Column
    private String email;

    public UserImage() {}

    public UserImage(String name, String type, byte[] data, String email) {
        this.name = name;
        this.type = type;
        this.data = data;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
