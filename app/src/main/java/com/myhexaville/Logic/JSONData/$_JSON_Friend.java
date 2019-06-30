package com.myhexaville.Logic.JSONData;


public class $_JSON_Friend extends $_JSON_Account {
    private String idTo;
    private String user_friend_request;

    public $_JSON_Friend(String type, String idFrom, String user_name, String user_friend_request, String idTo) {
        super(type, idFrom, user_name);
        this.idTo = idTo;
        this.user_friend_request = user_friend_request;
    }

    public String getUser_friend_request() {
        return user_friend_request;
    }

    public void setUser_friend_request(String user_friend_request) {
        this.user_friend_request = user_friend_request;
    }

    public String getIdTo() {
        return idTo;
    }

    public void setIdTo(String idTo) {
        this.idTo = idTo;
    }


}
