package com.myhexaville.Logic.JSONData;


public class $_JSON_Accept_Friend extends $_JSON_Friend {
    String user_name_request;

    public $_JSON_Accept_Friend(String type, String idFrom, String user_name, String user_name_request, String idTo) {
        super(type, idFrom, user_name, idTo);
        this.user_name_request = user_name_request;
    }

    public String getUser_name_request() {
        return user_name_request;
    }

    public void setUser_name_request(String user_name_request) {
        this.user_name_request = user_name_request;
    }
}
