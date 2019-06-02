package com.myhexaville.UI.Adapter.AdapterRoomChat.SendMessage.SendMessageImage;

import android.view.View;
import android.widget.ImageView;

import com.myhexaville.UI.Adapter.AdapterRoomChat.SendMessage.SendMessageAbstruct.$_Item_Send_Room_Chat_Message_Abstruct;
import com.myhexaville.login.R;

public class $_Item_Send_Room_Chat_Message_Image extends $_Item_Send_Room_Chat_Message_Abstruct {

    private ImageView message_send_image;

    public $_Item_Send_Room_Chat_Message_Image(View view) {
        super(view);
        date_send = view.findViewById(R.id.date_send_image);
        message_send_image = view.findViewById(R.id.message_send_image);

    }

    public ImageView getMessage_send_image() {
        return message_send_image;
    }

    public void setMessage_send_image(ImageView message_send_image) {
        this.message_send_image = message_send_image;
    }
}
