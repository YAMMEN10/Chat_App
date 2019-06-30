package com.myhexaville.Logic.JSONData;

import java.util.List;

public class $_JSON_Message_Text_Group extends $_JSON_Message_Group {
    private String message;
    private String idGroup;


    public $_JSON_Message_Text_Group(String type, String idFrom, List<String> idTos, String MType, String idGroup, String message, String time, String username) {
        super(type, idFrom, idTos, MType, time, username);
        this.message = message;
        this.idGroup = idGroup;
    }

    public String getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(String idGroup) {
        this.idGroup = idGroup;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
