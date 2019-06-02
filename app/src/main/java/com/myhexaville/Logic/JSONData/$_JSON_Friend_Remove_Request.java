package com.myhexaville.Logic.JSONData;

public class $_JSON_Friend_Remove_Request extends $_JSON_Friend_Response {
    private String user_friend_request;

    public $_JSON_Friend_Remove_Request(String type, String idReceived, String Id_user, String user_friend_request) {
        super(type, idReceived, true, Id_user);
        this.user_friend_request = user_friend_request;
    }

    public String getUser_friend_request() {
        return user_friend_request;
    }

    public void setUser_friend_request(String user_friend_request) {
        this.user_friend_request = user_friend_request;
    }
}
