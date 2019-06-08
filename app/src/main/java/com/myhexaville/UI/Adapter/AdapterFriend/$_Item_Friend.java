package com.myhexaville.UI.Adapter.AdapterFriend;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.myhexaville.login.R;

public class $_Item_Friend {
    private TextView User_Name;
    private TextView State;
    private ImageView image;

    public $_Item_Friend(View view) {
        User_Name=view.findViewById(R.id.OnlineName);
        State=view.findViewById(R.id.FriendState);
        image=view.findViewById(R.id.imageOnline);

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
