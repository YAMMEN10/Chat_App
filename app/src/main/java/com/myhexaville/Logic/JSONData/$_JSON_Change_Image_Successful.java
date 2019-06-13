package com.myhexaville.Logic.JSONData;

public class $_JSON_Change_Image_Successful extends $_JSON_Account_Response {
    private String user_name;
    private String bytes;

    public $_JSON_Change_Image_Successful(String type, String idReceived, boolean Done, String user_name, String bytes) {
        super(type, idReceived, Done);
        this.user_name = user_name;
        this.bytes = bytes;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getBytes() {
        return bytes;
    }

    public void setBytes(String bytes) {
        this.bytes = bytes;
    }
}
