package com.myhexaville.Logic.JSONData;

public class $_JSON_Accept_Friend_Respons extends $_JSON_Friend_Response {
    private String user_name;
    private int imagelenth;

    public int getImagelenth() {
        return imagelenth;
    }

    public void setImagelenth(int imagelenth) {
        this.imagelenth = imagelenth;
    }

    public $_JSON_Accept_Friend_Respons(String type, String idReceived, boolean Done, String Id_user, String user_name,int imagelenth) {
        super(type, idReceived, Done, Id_user);
        this.user_name = user_name;
        this.imagelenth=imagelenth;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
