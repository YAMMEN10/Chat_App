package com.myhexaville.Logic.JSONData;

public class $_JSON_Change_Image_Successful extends $_JSON_Account_Response {
    String user_name;

    public $_JSON_Change_Image_Successful(String type, String idReceived, boolean Done, String user_name) {
        super(type, idReceived, Done);
        this.user_name = user_name;
    }
}
