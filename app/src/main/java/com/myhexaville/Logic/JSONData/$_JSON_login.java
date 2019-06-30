package com.myhexaville.Logic.JSONData;

public class $_JSON_login extends $_JSON_Account {

    private String Password;

    public $_JSON_login(String type, String idFrom, String password, String user_name) {
        super(type, idFrom, user_name);
        this.Password = password;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
