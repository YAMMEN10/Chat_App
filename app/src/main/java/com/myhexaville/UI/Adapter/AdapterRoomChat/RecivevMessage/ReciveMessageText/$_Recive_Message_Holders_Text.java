package com.myhexaville.UI.Adapter.AdapterRoomChat.RecivevMessage.ReciveMessageText;

import android.support.annotation.NonNull;
import android.view.View;

import com.myhexaville.UI.Adapter.AdapterRoomChat.RecivevMessage.ReciveMessageAbstruct.$_Recive_Message_Holders_Abstruct;

public class $_Recive_Message_Holders_Text extends $_Recive_Message_Holders_Abstruct implements View.OnClickListener {
    private $_Item_Recive_Room_Chat_Text item_recive_room_chat_text;

    public $_Recive_Message_Holders_Text(@NonNull View itemView) {
        super(itemView);
        item_recive_room_chat_text = new $_Item_Recive_Room_Chat_Text(itemView);
        initAction();
    }

    public $_Item_Recive_Room_Chat_Text getItem_recive_room_chat_text() {
        return item_recive_room_chat_text;
    }

    public void setItem_recive_room_chat_text($_Item_Recive_Room_Chat_Text item_recive_room_chat_text) {
        this.item_recive_room_chat_text = item_recive_room_chat_text;
    }

    private void initAction() {
        //itemView.setOnClickListener(this::onClick);
        item_recive_room_chat_text.getMessage_recive().setOnClickListener(this::onClick);

    }

    @Override
    public void onClick(View v) {

    }


}
