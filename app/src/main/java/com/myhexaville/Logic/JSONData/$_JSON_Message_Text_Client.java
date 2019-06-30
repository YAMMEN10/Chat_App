package com.myhexaville.Logic.JSONData;

public class $_JSON_Message_Text_Client extends $_JSON_Message_Client {
    private String message;

    public $_JSON_Message_Text_Client(String type, String idFrom, String idTo, String MType, String message, String time, String username) {
        super(type, idFrom, idTo, time, username);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
