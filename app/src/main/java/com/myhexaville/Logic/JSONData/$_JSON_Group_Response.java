package com.myhexaville.Logic.JSONData;

public abstract class $_JSON_Group_Response extends $_JSON_Response {
    protected boolean Done;

    public $_JSON_Group_Response(String type, String idReceived, boolean Done) {
        super(type, idReceived);
        this.Done = Done;

    }


    public boolean isDone() {
        return Done;
    }

    public void setDone(boolean done) {
        Done = done;
    }


}
