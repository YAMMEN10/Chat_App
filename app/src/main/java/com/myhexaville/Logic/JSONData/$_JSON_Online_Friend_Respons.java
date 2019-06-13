package com.myhexaville.Logic.JSONData;



import java.util.ArrayList;

public class $_JSON_Online_Friend_Respons extends $_JSON_Account_Response {
    public $_JSON_Online_Friend_Respons(String type, String idReceived, boolean Done, ArrayList<String> Ids,ArrayList<String> OnlineState) {
        super(type, idReceived, Done);
        this.Ids=Ids;
        this.OnlineState=OnlineState;

    }
    private ArrayList<String> Ids;
    private ArrayList<String> OnlineState;

    public ArrayList<String> getIds() {
        return Ids;
    }

    public void setIds(ArrayList<String> ids) {
        Ids = ids;
    }

    public ArrayList<String> getOnlineState() {
        return OnlineState;
    }

    public void setOnlineState(ArrayList<String> onlineState) {
        OnlineState = onlineState;
    }

}
