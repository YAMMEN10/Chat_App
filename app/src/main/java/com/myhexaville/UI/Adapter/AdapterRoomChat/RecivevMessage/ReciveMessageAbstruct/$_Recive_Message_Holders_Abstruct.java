package com.myhexaville.UI.Adapter.AdapterRoomChat.RecivevMessage.ReciveMessageAbstruct;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class $_Recive_Message_Holders_Abstruct extends RecyclerView.ViewHolder {
    private $_Item_Recive_Room_Chat_Message_Abstruct item_recive_room_chat_message_abstruct;

    public $_Recive_Message_Holders_Abstruct(@NonNull View itemView) {
        super(itemView);

    }

    public $_Item_Recive_Room_Chat_Message_Abstruct getItem_recive_room_chat_message_abstruct() {
        return item_recive_room_chat_message_abstruct;
    }

    public void setItem_recive_room_chat_message_abstruct($_Item_Recive_Room_Chat_Message_Abstruct item_recive_room_chat_message_abstruct) {
        this.item_recive_room_chat_message_abstruct = item_recive_room_chat_message_abstruct;
    }
}
