package com.myhexaville.Logic.JSONData;

public class $_JSON_SignUp_Successful extends $_JSON_Account_Response {

    private String user_name;
    private String password;

    public $_JSON_SignUp_Successful(String type, String idReceived, boolean Done, String user_name, String password) {
        super(type, idReceived, Done);
        this.user_name = user_name;
        this.password = password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
