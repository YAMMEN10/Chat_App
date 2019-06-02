package com.myhexaville.UI.Adapter.AdapterRoomChat.RecivevMessage.ReciveMessageVoice;

import android.support.annotation.NonNull;
import android.view.View;

import com.myhexaville.UI.Adapter.AdapterRoomChat.RecivevMessage.ReciveMessageAbstruct.$_Recive_Message_Holders_Abstruct;

public class $_Recive_Message_Holders_Voice extends $_Recive_Message_Holders_Abstruct {
    private $_Item_Recive_Room_Chat_Message_Voice item_recive_room_chat_message_voice;

    public $_Recive_Message_Holders_Voice(@NonNull View itemView) {
        super(itemView);
        item_recive_room_chat_message_voice = new $_Item_Recive_Room_Chat_Message_Voice(itemView);
    }

    public $_Item_Recive_Room_Chat_Message_Voice getItem_recive_room_chat_message_voice() {
        return item_recive_room_chat_message_voice;
    }

    public void setItem_recive_room_chat_message_voice($_Item_Recive_Room_Chat_Message_Voice item_send_room_chat_message_voice) {
        this.item_recive_room_chat_message_voice = item_send_room_chat_message_voice;
    }
}
