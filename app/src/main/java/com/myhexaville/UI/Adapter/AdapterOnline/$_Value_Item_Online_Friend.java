package com.myhexaville.UI.Adapter.AdapterOnline;

public class $_Value_Item_Online_Friend{
    private String Id;
    private String FriendName;
    private String Online;
    private byte[] Image;

    public $_Value_Item_Online_Friend(String id, String friendName, String online, byte[] image) {
        Id = id;
        FriendName = friendName;
        Online = online;
        Image = image;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getFriendName() {
        return FriendName;
    }

    public void setFriendName(String friendName) {
        FriendName = friendName;
    }

    public String getOnline() {
        return Online;
    }

    public void setOnline(String online) {
        Online = online;
    }

    public byte[] getImage() {
        return Image;
    }

    public void setImage(byte[] image) {
        Image = image;
    }
}
