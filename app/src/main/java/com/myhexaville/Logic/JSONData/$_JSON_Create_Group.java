package com.myhexaville.Logic.JSONData;


import com.myhexaville.Logic.Room.$_Group;

public class $_JSON_Create_Group extends $_JSON_Group {
    $_Group group;

    public $_JSON_Create_Group(String type, String idFrom, String idGroup, $_Group group) {
        super(type, idFrom, idGroup);
        this.group = group;
    }

    public $_Group getGroup() {
        return group;
    }

    public void setGroup($_Group group) {
        this.group = group;
    }


}
