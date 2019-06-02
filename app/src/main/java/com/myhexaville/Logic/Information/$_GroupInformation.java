package com.myhexaville.Logic.Information;

import java.io.Serializable;

/**
 *
 */
public class $_GroupInformation extends $_Information implements Serializable {

    private String group_id;

    public $_GroupInformation() {
    }

    @Override
    public String getID() {
        return group_id;
    }


}