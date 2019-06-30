package com.myhexaville.Logic.JSONData;


import com.myhexaville.Logic.Room.$_Group;

import java.util.List;

public class $_JSON_Create_Group_Successful extends $_JSON_Group_Response {


    $_Group group;
    private List<Integer> length_photo;


    public $_JSON_Create_Group_Successful(String type, String idReceived, $_Group group, List<Integer> length_photo, boolean Done) {
        super(type, idReceived, Done);
        this.group = group;
        this.length_photo = length_photo;
    }

    public $_Group getGroup() {
        return group;
    }

    public void setGroup($_Group group) {
        this.group = group;
    }

    public List<Integer> getLength_photo() {
        return length_photo;
    }

    public void setLength_photo(List<Integer> length_photo) {
        this.length_photo = length_photo;
    }
}
