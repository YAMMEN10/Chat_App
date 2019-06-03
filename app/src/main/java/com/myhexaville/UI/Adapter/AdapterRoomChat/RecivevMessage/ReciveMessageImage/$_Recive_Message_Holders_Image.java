package com.myhexaville.UI.Adapter.AdapterRoomChat.RecivevMessage.ReciveMessageImage;

import android.support.annotation.NonNull;
import android.view.View;

import com.myhexaville.UI.Adapter.AdapterRoomChat.RecivevMessage.ReciveMessageAbstruct.$_Recive_Message_Holders_Abstruct;

public class $_Recive_Message_Holders_Image extends $_Recive_Message_Holders_Abstruct implements View.OnClickListener {

    private $_Item_Recive_Room_Chat_Message_Image item_recive_room_chat_message_image;


    public $_Recive_Message_Holders_Image(@NonNull View itemView) {
        super(itemView);
        item_recive_room_chat_message_image = new $_Item_Recive_Room_Chat_Message_Image(itemView);
        initAction();
    }

    public $_Item_Recive_Room_Chat_Message_Image getItem_send_room_chat_message_image() {
        return item_recive_room_chat_message_image;
    }

    public void setItem_send_room_chat_message_image($_Item_Recive_Room_Chat_Message_Image item_send_room_chat_message_image) {
        this.item_recive_room_chat_message_image = item_send_room_chat_message_image;
    }


    private void initAction() {
        //itemView.setOnClickListener(this::onClick);
        item_recive_room_chat_message_image.getMessage_recive_image().setOnClickListener(this::onClick);

    }

    @Override
    public void onClick(View v) {

    }
}
