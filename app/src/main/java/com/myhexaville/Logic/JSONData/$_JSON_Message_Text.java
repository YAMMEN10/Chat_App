package com.myhexaville.Logic.JSONData;

public class $_JSON_Message_Text extends $_JSON_Message {
    private String message;

    public $_JSON_Message_Text(String type, String idFrom, String idTo, String message, String time, String username) {
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
