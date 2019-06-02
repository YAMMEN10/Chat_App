package com.myhexaville.Logic.JSONData;

public abstract class $_JSON_Response extends $_JSON {

    protected String idReceived;

    public $_JSON_Response(String type, String idReceived) {
        super(type);
        this.idReceived = idReceived;
    }

    public String getIdReceived() {
        return idReceived;
    }

    public void setIdReceived(String idReceived) {
        this.idReceived = idReceived;
    }


}
