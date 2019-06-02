package com.myhexaville.Logic.JSONData;


public class $_JSON_Friend extends $_JSON_Account {
    private String idTo;

    public $_JSON_Friend(String type, String idFrom, String user_name, String idTo) {
        super(type, idFrom, user_name);
        this.idTo = idTo;
    }

    public String getIdTo() {
        return idTo;
    }

    public void setIdTo(String idTo) {
        this.idTo = idTo;
    }


}
