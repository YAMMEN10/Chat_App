package com.myhexaville.UI.Adapter.AdapterRoomChat.SendMessage.SendMessageImage;

import android.support.annotation.NonNull;
import android.view.View;

import com.myhexaville.UI.Adapter.AdapterRoomChat.SendMessage.SendMessageAbstruct.$_Send_Message_Holders_Abstruct;

public class $_Send_Message_Holders_Image extends $_Send_Message_Holders_Abstruct implements View.OnClickListener {

    private $_Item_Send_Room_Chat_Message_Image item_send_room_chat_message_image;


    public $_Send_Message_Holders_Image(@NonNull View itemView) {
        super(itemView);
        item_send_room_chat_message_image = new $_Item_Send_Room_Chat_Message_Image(itemView);
        initAction();
    }

    public $_Item_Send_Room_Chat_Message_Image getItem_send_room_chat_message_image() {
        return item_send_room_chat_message_image;
    }

    public void setItem_send_room_chat_message_image($_Item_Send_Room_Chat_Message_Image item_send_room_chat_message_image) {
        this.item_send_room_chat_message_image = item_send_room_chat_message_image;
    }

    @Override
    public void onClick(View v) {

    }

    private void initAction() {
        //itemView.setOnClickListener(this::onClick);
        item_send_room_chat_message_image.getMessage_send_image().setOnClickListener(this::onClick);

    }

}
