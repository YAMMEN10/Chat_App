package com.myhexaville.Logic.JSONData;

import java.util.List;

public class $_JSON_Message_Voice_Group extends $_JSON_Message_Group {
    private String bytes;

    public $_JSON_Message_Voice_Group(String type, String idFrom, List<String> idTos, String bytes, String time, String username) {
        super(type, idFrom, idTos, time, username);
        this.bytes = bytes;
    }

    public String getBytes() {
        return bytes;
    }

    public void setBytes(String bytes) {
        this.bytes = bytes;
    }
}
