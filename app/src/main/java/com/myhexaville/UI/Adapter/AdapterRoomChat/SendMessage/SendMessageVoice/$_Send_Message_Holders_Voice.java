package com.myhexaville.UI.Adapter.AdapterRoomChat.SendMessage.SendMessageVoice;

import android.support.annotation.NonNull;
import android.view.View;

import com.myhexaville.UI.Adapter.AdapterRoomChat.SendMessage.SendMessageAbstruct.$_Send_Message_Holders_Abstruct;

public class $_Send_Message_Holders_Voice extends $_Send_Message_Holders_Abstruct {
    private $_Item_Send_Room_Chat_Message_Voice item_send_room_chat_message_voice;

    public $_Send_Message_Holders_Voice(@NonNull View itemView) {
        super(itemView);
        item_send_room_chat_message_voice = new $_Item_Send_Room_Chat_Message_Voice(itemView);
    }

    public $_Item_Send_Room_Chat_Message_Voice getItem_send_room_chat_message_voice() {
        return item_send_room_chat_message_voice;
    }

    public void setItem_send_room_chat_message_voice($_Item_Send_Room_Chat_Message_Voice item_send_room_chat_message_voice) {
        this.item_send_room_chat_message_voice = item_send_room_chat_message_voice;
    }
}
