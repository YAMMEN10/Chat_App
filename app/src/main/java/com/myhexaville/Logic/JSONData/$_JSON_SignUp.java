package com.myhexaville.Logic.JSONData;

public class $_JSON_SignUp extends $_JSON_Account {


    private String password;

    public $_JSON_SignUp(String type, String idFrom, String password, String user_name) {
        super(type, idFrom, user_name);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
