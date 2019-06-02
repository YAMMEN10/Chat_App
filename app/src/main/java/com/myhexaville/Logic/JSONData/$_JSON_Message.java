package com.myhexaville.Logic.JSONData;

public abstract class $_JSON_Message extends $_JSON_Comunication {
    protected String time;
    protected String username;

    public $_JSON_Message(String type, String idFrom, String idTo, String time, String username) {
        super(type, idFrom, idTo);
        this.time = time;
        this.username = username;
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


