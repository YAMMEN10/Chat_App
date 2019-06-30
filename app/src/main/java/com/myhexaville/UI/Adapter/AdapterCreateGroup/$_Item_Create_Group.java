package com.myhexaville.UI.Adapter.AdapterCreateGroup;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.myhexaville.login.R;

public class $_Item_Create_Group {
    private TextView User_Name;
    private TextView State;
    private ImageView image;
    private CheckBox checkBox;

    public $_Item_Create_Group(View view) {
        User_Name = view.findViewById(R.id.OnlineName);
        State = view.findViewById(R.id.FriendState);
        image = view.findViewById(R.id.imageOnline);
        checkBox = view.findViewById(R.id.checkFriend);

    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }

    public TextView getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(TextView user_Name) {
        User_Name = user_Name;
    }

    public TextView getState() {
        return State;
    }

    public void setState(TextView state) {
        State = state;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }
}
