package com.myhexaville.Logic.Information;

import java.io.Serializable;

/**
 *
 */
public abstract class $_Information implements Serializable {

    protected String state;
    protected byte[] picture;
    protected String name;
    protected String user_name;


    public $_Information(String state, byte[] picture, String name, String user_name) {
        this.state = state;
        this.user_name = user_name;
        this.picture = picture;
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public abstract String getID();

}