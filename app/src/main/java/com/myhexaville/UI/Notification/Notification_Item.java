package com.myhexaville.UI.Notification;


public class Notification_Item {
    private String id;
    private String name;
    private String description;


    private String thumbnail;

    public Notification_Item() {
    }

    public Notification_Item(String id, String name, String description, String thumbnail) {
        this.id = id;
        this.name = name;
        this.description = description;

        this.thumbnail = thumbnail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
