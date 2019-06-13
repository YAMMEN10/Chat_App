package com.myhexaville.Logic.JSONData;

public class $_JSON_Friend_Accept_Response extends $_JSON_Friend_Response {
    private String user_name;
    private int imagelenth;

    public int getImagelenth() {
        return imagelenth;
    }

    public void setImagelenth(int imagelenth) {
        this.imagelenth = imagelenth;
    }

    public $_JSON_Friend_Accept_Response(String type, String idReceived, String Id_user, String user_name, int bytes) {
        super(type, idReceived, true, Id_user);
        this.user_name= user_name;
        this.imagelenth  = bytes;
    }


    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }


}
