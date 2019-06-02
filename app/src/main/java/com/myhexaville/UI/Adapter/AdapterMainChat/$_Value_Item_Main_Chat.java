package com.myhexaville.UI.Adapter.AdapterMainChat;

public class $_Value_Item_Main_Chat {
    private String message;
    private String name;
    private String email;
    private byte[] image;

    public $_Value_Item_Main_Chat(String message, String name, String email, byte[] image) {
        this.message = message;
        this.name = name;
        this.email = email;
        this.image = image;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getId_image() {
        return image;
    }

    public void setId_image(byte[] id_image) {
        this.image = id_image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
