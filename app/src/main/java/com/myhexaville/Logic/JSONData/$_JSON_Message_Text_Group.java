package com.myhexaville.Logic.JSONData;

import java.util.List;

public class $_JSON_Message_Text_Group extends $_JSON_Message_Group {
    private String message;

    public $_JSON_Message_Text_Group(String type, String idFrom, List<String> idTos, String message, String time, String username) {
        super(type, idFrom, idTos, time, username);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
