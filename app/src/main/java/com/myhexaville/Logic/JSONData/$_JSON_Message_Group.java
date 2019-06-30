package com.myhexaville.Logic.JSONData;

import java.util.List;

public class $_JSON_Message_Group extends $_JSON_Message {
    List<String> idTos;

    public $_JSON_Message_Group(String type, String idFrom, List<String> idTos, String time, String username) {
        super(type, idFrom, time, username);
        this.idTos = idTos;
    }

    public List<String> getIdTos() {
        return idTos;
    }

    public void setIdTos(List<String> idTos) {
        this.idTos = idTos;
    }
}
