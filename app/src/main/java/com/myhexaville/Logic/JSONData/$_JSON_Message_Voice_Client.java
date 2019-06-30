package com.myhexaville.Logic.JSONData;

public class $_JSON_Message_Voice_Client extends $_JSON_Message_Client {
    private String bytes;

    public $_JSON_Message_Voice_Client(String type, String idFrom, String idTo, String bytes, String time, String username) {
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
