package com.myhexaville.Logic.JSONData;

public class $_JSON_Message_Image_Client_In_Group extends $_JSON_Message_Image_Client {
    private String idGroup;

    public $_JSON_Message_Image_Client_In_Group(String type, String idFrom, String idTo, String idGroup, String MType, String time, String bytes, String username) {
        super(type, idFrom, idTo, MType, bytes, time, username);
        this.idGroup = idGroup;
    }

    public String getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(String idGroup) {
        this.idGroup = idGroup;
    }
}
