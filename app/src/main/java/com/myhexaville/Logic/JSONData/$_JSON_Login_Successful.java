package com.myhexaville.Logic.JSONData;

public class $_JSON_Login_Successful extends $_JSON_Account_Response {
    private String username;
    private String state;
    private String bytes;

    public $_JSON_Login_Successful(String type, String idReceived, String username, String state, String bytes, boolean Done) {
        super(type, idReceived, Done);
        this.username = username;
        this.state = state;
        this.bytes = bytes;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBytes() {
        return bytes;
    }

    public void setBytes(String bytes) {
        this.bytes = bytes;
    }
}
