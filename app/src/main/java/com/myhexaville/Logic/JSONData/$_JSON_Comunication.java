package com.myhexaville.Logic.JSONData;


public abstract class $_JSON_Comunication extends $_JSON_Receive {

    protected String idTo;

    public $_JSON_Comunication(String type, String idFrom, String idTo) {
        super(type, idFrom);
        this.idTo = idTo;
    }

    public String getIdTo() {
        return idTo;
    }

    public void setIdTo(String idTo) {
        this.idTo = idTo;
    }

}
