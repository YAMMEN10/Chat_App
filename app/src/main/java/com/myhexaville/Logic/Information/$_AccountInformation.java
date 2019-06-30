package com.myhexaville.Logic.Information;

import java.io.Serializable;

/**
 *
 */
public abstract class $_AccountInformation extends $_Information implements Serializable {

    private String password;

    public $_AccountInformation(String state, byte[] picture, String name, String password) {
        super(state, picture, name, name);
        this.state = state;
        this.picture = picture;
        this.name = name;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}