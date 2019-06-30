package com.myhexaville.UI.Adapter.AdapterCreateGroup;

public class $_Value_Item_Create_Group {
    private String User_Name;
    private String State;
    private byte[] image;
    private String Id;
    private boolean isSelected;

    public $_Value_Item_Create_Group(String Id, String user_Name, String state, byte[] image, boolean isSelected) {
        User_Name = user_Name;
        State = state;
        this.image = image;
        this.Id = Id;
        this.isSelected = isSelected;

    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
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
