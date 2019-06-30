package com.myhexaville.Logic.JSONData;

public class $_JSON_Remove_Group_Successful extends $_JSON_Group_Response {
    String idGroup;

    public $_JSON_Remove_Group_Successful(String type, String idReceived, String idGroup, boolean Done) {
        super(type, idReceived, Done);
        this.idGroup = idGroup;
    }

    public String getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(String idGroup) {
        this.idGroup = idGroup;
    }
}
