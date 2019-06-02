package com.myhexaville.Logic.JSONData;


public abstract class $_JSON_Account extends $_JSON_Receive {
    private String user_name;

    public $_JSON_Account(String type, String idFrom, String user_name) {
        super(type, idFrom);
        this.user_name = user_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }


}
