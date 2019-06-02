package com.myhexaville.UI.Adapter.AdapterRoomChat.SendMessage.SendMessageAbstruct;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class $_Send_Message_Holders_Abstruct extends RecyclerView.ViewHolder {
    private $_Item_Send_Room_Chat_Message_Abstruct item_send_room_chat_message_abstruct;

    public $_Send_Message_Holders_Abstruct(@NonNull View itemView) {
        super(itemView);
    }

    public $_Item_Send_Room_Chat_Message_Abstruct getItem_send_room_chat_message_abstruct() {
        return item_send_room_chat_message_abstruct;
    }

    public void setItem_send_room_chat_message_abstruct($_Item_Send_Room_Chat_Message_Abstruct item_send_room_chat_message_abstruct) {
        this.item_send_room_chat_message_abstruct = item_send_room_chat_message_abstruct;
    }
}
