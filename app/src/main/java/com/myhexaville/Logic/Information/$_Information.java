package com.myhexaville.Logic.Information;

import java.io.File;
import java.io.Serializable;

/**
 *
 */
public abstract class $_Information implements Serializable {

    protected String state;
    protected File picture;
    protected String name;

    public $_Information() {
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public File getPicture() {
        return picture;
    }

    public void setPicture(File picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract String getID();

}