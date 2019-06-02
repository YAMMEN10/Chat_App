package com.myhexaville.Logic.JSONData;

public abstract class $_JSON_Group extends $_JSON_Receive {

    protected String idGroup;

    public $_JSON_Group(String type, String idFrom, String idGroup) {
        super(type, idFrom);
        this.idGroup = idGroup;
    }

}

