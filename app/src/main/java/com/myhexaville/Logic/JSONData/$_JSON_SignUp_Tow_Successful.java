package com.myhexaville.Logic.JSONData;

public class $_JSON_SignUp_Tow_Successful extends $_JSON_Account_Response {
    String state;
    //String bytes;

    public $_JSON_SignUp_Tow_Successful(String type, String idReceived, boolean Done, String state) {
        super(type, idReceived, Done);
        this.state = state;
        //this.bytes = byteBuffer;
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
