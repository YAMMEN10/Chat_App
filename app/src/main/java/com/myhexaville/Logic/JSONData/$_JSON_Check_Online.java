package com.myhexaville.Logic.JSONData;

public class $_JSON_Check_Online extends $_JSON_Comunication {
    String value;

    public $_JSON_Check_Online(String type, String idFrom, String value) {
        super(type, idFrom);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
