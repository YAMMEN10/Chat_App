package com.myhexaville.Logic.JSONData;


import java.util.ArrayList;

public class $_JSON_Online_Friends  extends $_JSON_Account {
    public $_JSON_Online_Friends(String type, String idFrom, String user_name,ArrayList<String> Ids) {
        super(type, idFrom, user_name);
        this.Ids=Ids;
    }
    private ArrayList<String> Ids;

    public ArrayList<String> getIds() {
        return Ids;
    }

    public void setIds(ArrayList<String> ids) {
        Ids = ids;
    }


}
