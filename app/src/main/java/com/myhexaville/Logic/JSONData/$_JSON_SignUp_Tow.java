package com.myhexaville.Logic.JSONData;

public class $_JSON_SignUp_Tow extends $_JSON_Account {
    String state;
    //String bytes;

    public $_JSON_SignUp_Tow(String type, String idFrom, String state, String user_name) {
        super(type, idFrom, user_name);
        this.state = state;
        //this.bytes = bytes;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

   /* public String getBytes() {
        return bytes;
    }

    public void setBytes(String bytes) {
        this.bytes = bytes;
    }*/
}
