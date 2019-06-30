package com.myhexaville.Logic.JSONData;

public class $_JSON_Message_Client extends $_JSON_Message {
    String idTo;

    public $_JSON_Message_Client(String type, String idFrom, String MType, String idTo, String time, String username) {
        super(type, idFrom, MType, time, username);
        this.idTo = idTo;
    }

    public String getIdTo() {
        return idTo;
    }

    public void setIdTo(String idTo) {
        this.idTo = idTo;
    }
}
