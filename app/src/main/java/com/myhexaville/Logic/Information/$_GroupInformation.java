package com.myhexaville.Logic.Information;

import java.io.Serializable;

/**
 *
 */
public class $_GroupInformation extends $_Information implements Serializable {

    private String group_id;

    public $_GroupInformation(String state, byte[] picture, String name, String group_id, String user_name) {
        super(state, picture, name, user_name);
        this.group_id = group_id;
    }

    @Override
    public String getID() {
        return group_id;
    }


}