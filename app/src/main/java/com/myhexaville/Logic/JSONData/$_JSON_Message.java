package com.myhexaville.Logic.JSONData;

public abstract class $_JSON_Message extends $_JSON_Comunication {
    protected String time;
    protected String username;
    protected String MType;


    public $_JSON_Message(String type, String idFrom, String MType, String time, String username) {
        super(type, idFrom);
        this.time = time;
        this.username = username;
        this.MType = MType;
    }

    public String getMType() {
        return MType;
    }

    public void setMType(String MType) {
        this.MType = MType;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}


