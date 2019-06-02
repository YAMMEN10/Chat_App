package com.myhexaville.Logic.Friend;

import java.io.Serializable;

public class $_FriendInfo implements Serializable {
    private String id;
    private String user;
    private byte[] photo;
    private String state;

    public $_FriendInfo(String id, String user, byte[] photo, String state) {
        this.id = id;
        this.user = user;
        this.photo = photo;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
