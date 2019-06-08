package com.myhexaville.UI.Adapter.AdapterFriend;

public class $_Value_Item_Friend {
    private String User_Name;
    private String State;
    private byte[] image;
    private  String Id;

    public $_Value_Item_Friend(String Id,String user_Name, String state, byte[] image) {
        User_Name = user_Name;
        State = state;
        this.image = image;
        this.Id=Id;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
