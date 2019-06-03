package com.myhexaville.UI.Adapter.AdapterRoomChat.RecivevMessage.ReciveMessageImage;

import android.view.View;
import android.widget.ImageView;

import com.myhexaville.UI.Adapter.AdapterRoomChat.RecivevMessage.ReciveMessageAbstruct.$_Item_Recive_Room_Chat_Message_Abstruct;
import com.myhexaville.login.R;

public class $_Item_Recive_Room_Chat_Message_Image extends $_Item_Recive_Room_Chat_Message_Abstruct {

    private ImageView message_recive_image;

    public $_Item_Recive_Room_Chat_Message_Image(View view) {
        super(view);
        name_recive = view.findViewById(R.id.name_recive_image);
        message_recive_image = view.findViewById(R.id.message_recive_image);
        date_recive = view.findViewById(R.id.date_recive_image);
    }

    public ImageView getMessage_recive_image() {
        return message_recive_image;
    }

    public void setMessage_recive_image(ImageView message_recive_image) {
        this.message_recive_image = message_recive_image;
    }
}
