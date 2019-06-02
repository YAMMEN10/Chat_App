package com.myhexaville.Logic.Information;

import java.io.File;
import java.io.Serializable;

public class $_AccountInformationById extends $_AccountInformation implements Serializable {

    private String id;

    public $_AccountInformationById(String id, String state, File picture, String name, String password) {
        super(state, picture, name, password);
        this.id = id;

    }

    @Override
    public String getID() {
        return id;
    }


}