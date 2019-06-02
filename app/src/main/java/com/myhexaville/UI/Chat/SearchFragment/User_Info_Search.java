package com.myhexaville.UI.Chat.SearchFragment;

public class User_Info_Search {
    private byte[] mImageUrl;
    private String mTitle;
    private String mDescription;
    private String Id;
    private String Button_text;

    public User_Info_Search(byte[] mImageUrl, String mTitle, String mDescription, String Id, String Button_text) {

        this.mImageUrl = mImageUrl;
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.Id = Id;
        this.Button_text = Button_text;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getButton_text() {
        return Button_text;
    }

    public void setButton_text(String button_text) {
        Button_text = button_text;
    }

    public byte[] getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(byte[] mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }
}
