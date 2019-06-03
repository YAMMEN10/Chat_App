package com.myhexaville.UI.Adapter.AdapterRoomChat.SendMessage.SendMessgaeText;

import android.support.annotation.NonNull;
import android.view.View;

import com.myhexaville.UI.Adapter.AdapterRoomChat.SendMessage.SendMessageAbstruct.$_Send_Message_Holders_Abstruct;

public class $_Send_Message_Holders_Text extends $_Send_Message_Holders_Abstruct implements View.OnClickListener {

    private $_Item_Send_Room_Chat_Message_Text item_room_chat_text_send;

    public $_Send_Message_Holders_Text(@NonNull View itemView) {
        super(itemView);
        item_room_chat_text_send = new $_Item_Send_Room_Chat_Message_Text(itemView);
        initAction();


    }


    public $_Item_Send_Room_Chat_Message_Text getItem_room_chat_text_send() {
        return item_room_chat_text_send;
    }

    public void setItem_room_chat_text_send($_Item_Send_Room_Chat_Message_Text item_room_chat_text_send) {
        this.item_room_chat_text_send = item_room_chat_text_send;
    }

    @Override
    public void onClick(View v) {

    }

    private void initAction() {
        //itemView.setOnClickListener(this::onClick);
        item_room_chat_text_send.getMessage_send().setOnClickListener(this::onClick);

    }

}
