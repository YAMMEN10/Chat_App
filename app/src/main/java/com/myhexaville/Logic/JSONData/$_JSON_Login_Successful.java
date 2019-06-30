package com.myhexaville.Logic.JSONData;

import com.myhexaville.Logic.Room.$_Group;

import java.util.List;

public class $_JSON_Login_Successful extends $_JSON_Account_Response {
    private String username;
    private String state;
    private String bytes;
    private List<$_Group> groups;
    private List<Integer> length_photo;

    public $_JSON_Login_Successful(String type, String idReceived, String username, String state, String bytes, List<$_Group> groups, List<Integer> length_photo, boolean Done) {
        super(type, idReceived, Done);
        this.username = username;
        this.state = state;
        this.bytes = bytes;
        this.groups = groups;
        this.length_photo = length_photo;

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBytes() {
        return bytes;
    }

    public void setBytes(String bytes) {
        this.bytes = bytes;
    }

    public List<$_Group> getGroups() {
        return groups;
    }

    public void setGroups(List<$_Group> groups) {
        this.groups = groups;
    }
}
