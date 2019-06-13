package com.myhexaville.UI.Adapter.AdapterOnline;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.myhexaville.login.R;

public class $_Item_Online_Friend {
    private TextView FriendName;
    private TextView Online;
    private ImageView imageFriend;

    public TextView getFriendName() {
        return FriendName;
    }

    public void setFriendName(TextView friendName) {
        FriendName = friendName;
    }

    public TextView getOnline() {
        return Online;
    }

    public void setOnline(TextView online) {
        Online = online;
    }

    public ImageView getImageFriend() {
        return imageFriend;
    }

    public void setImageFriend(ImageView imageFriend) {
        this.imageFriend = imageFriend;
    }

    public $_Item_Online_Friend(View itemView) {
        FriendName=itemView.findViewById(R.id.OnlineName);
        Online=itemView.findViewById(R.id.OnlineState);
        imageFriend=itemView.findViewById(R.id.imageOnline);
    }
}
