package com.myhexaville.Logic.JSONData;

public class $_JSON_Change_Image extends $_JSON_Account {
    Integer bytes;

    public $_JSON_Change_Image(String type, String idFrom, String user_name, Integer bytes) {
        super(type, idFrom, user_name);
        this.bytes = bytes;
    }

    public Integer getBytes() {
        return bytes;
    }

    public void setBytes(Integer bytes) {
        this.bytes = bytes;
    }
}
