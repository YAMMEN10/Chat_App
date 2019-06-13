package com.myhexaville.Logic.JSONData;

public class $_JSON_Store_Message_Response extends $_JSON_Response {
    protected boolean Done;

    public $_JSON_Store_Message_Response(String type, String idReceived, boolean Done) {
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
