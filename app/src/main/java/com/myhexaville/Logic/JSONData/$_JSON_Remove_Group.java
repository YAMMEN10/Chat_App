package com.myhexaville.Logic.JSONData;


import java.util.List;

public class $_JSON_Remove_Group extends $_JSON_Group {
    List<String> clients_id;

    public $_JSON_Remove_Group(String type, String idFrom, String idGroup, List<String> clients_id) {
        super(type, idFrom, idGroup);
        this.clients_id = clients_id;
    }

    public List<String> getClients_id() {
        return clients_id;
    }

    public void setClients_id(List<String> clients_id) {
        this.clients_id = clients_id;
    }


}
