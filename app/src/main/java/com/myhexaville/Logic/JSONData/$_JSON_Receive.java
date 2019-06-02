package com.myhexaville.Logic.JSONData;

public abstract class $_JSON_Receive extends $_JSON {

    protected String idFrom;


    public $_JSON_Receive(String type, String idFrom) {
        super(type);
        this.idFrom = idFrom;
    }

    public String getIdFrom() {
        return idFrom;
    }

    public void setIdFrom(String idFrom) {
        this.idFrom = idFrom;
    }


}
