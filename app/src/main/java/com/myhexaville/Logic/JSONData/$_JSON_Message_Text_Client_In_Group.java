package com.myhexaville.Logic.JSONData;


public class $_JSON_Message_Text_Client_In_Group extends $_JSON_Message_Text_Client {
    private String idGroup;

    public $_JSON_Message_Text_Client_In_Group(String type, String idFrom, String idTo, String idGroup, String MType, String time, String message, String username) {
        super(type, idFrom, idTo, MType, time, message, username);
        this.idGroup = idGroup;
    }

    public String getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(String idGroup) {
        this.idGroup = idGroup;
    }
}
