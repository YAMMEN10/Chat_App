package com.myhexaville.Logic.JSONData;

public class $_JSON_Message_Image extends $_JSON_Message {
    private String bytes;

    public $_JSON_Message_Image(String type, String idFrom, String idTo, String bytes, String time, String username) {
        super(type, idFrom, idTo, time, username);
        this.bytes = bytes;
    }

    public String getBytes() {
        return bytes;
    }

    public void setBytes(String bytes) {
        this.bytes = bytes;
    }
}
