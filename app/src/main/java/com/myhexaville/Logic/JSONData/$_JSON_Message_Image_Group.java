package com.myhexaville.Logic.JSONData;

import java.util.List;

public class $_JSON_Message_Image_Group extends $_JSON_Message_Group {
    private String bytes;
    private String idGroup;

    public $_JSON_Message_Image_Group(String type, String idFrom, List<String> idTos, String idGroup, String Mtype, String bytes, String time, String username) {
        super(type, idFrom, idTos, Mtype, time, username);
        this.bytes = bytes;
        this.idGroup = idGroup;
    }


    public String getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(String idGroup) {
        this.idGroup = idGroup;
    }

    public String getBytes() {
        return bytes;
    }

    public void setBytes(String bytes) {
        this.bytes = bytes;
    }
}
