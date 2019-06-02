package com.myhexaville.Logic.JSONData;

public class $_JSON_Friend_Accept_Response extends $_JSON_Friend_Response {
    private String user_name;
    private String bytes;

    public $_JSON_Friend_Accept_Response(String type, String idReceived, String Id_user, String user_friend_request, String bytes) {
        super(type, idReceived, true, Id_user);
        this.user_name = user_friend_request;
        this.bytes = bytes;
    }

    public String getBytes() {
        return bytes;
    }

    public void setBytes(String bytes) {
        this.bytes = bytes;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }


}
