package com.myhexaville.Logic.JSONData;

public class $_JSON_SignUp_Tow extends $_JSON_Account {
    String state;
    String byteBuffer;

    public $_JSON_SignUp_Tow(String type, String idFrom, String state, String byteBuffer, String user_name) {
        super(type, idFrom, user_name);
        this.state = state;
        this.byteBuffer = byteBuffer;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getByteBuffer() {
        return byteBuffer;
    }

    public void setByteBuffer(String byteBuffer) {
        this.byteBuffer = byteBuffer;
    }

}
