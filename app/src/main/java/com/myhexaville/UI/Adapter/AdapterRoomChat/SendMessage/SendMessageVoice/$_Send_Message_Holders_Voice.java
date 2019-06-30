package com.myhexaville.UI.Adapter.AdapterRoomChat.SendMessage.SendMessageVoice;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import com.myhexaville.Logic.Client.$_ClientStatic;
import com.myhexaville.UI.Adapter.AdapterRoomChat.Message.MessageVoice.$_Message_Voice;
import com.myhexaville.UI.Adapter.AdapterRoomChat.SendMessage.SendMessageAbstruct.$_Send_Message_Holders_Abstruct;
import com.myhexaville.UI.PlaySound.$_Play_Sound;
import com.myhexaville.login.MainActivity;

public class $_Send_Message_Holders_Voice extends $_Send_Message_Holders_Abstruct implements View.OnClickListener, View.OnLongClickListener {
    private $_Item_Send_Room_Chat_Message_Voice item_send_room_chat_message_voice;

    public $_Send_Message_Holders_Voice(@NonNull View itemView) {
        super(itemView);
        item_send_room_chat_message_voice = new $_Item_Send_Room_Chat_Message_Voice(itemView);
        initAction();
    }

    public $_Item_Send_Room_Chat_Message_Voice getItem_send_room_chat_message_voice() {
        return item_send_room_chat_message_voice;
    }

    public void setItem_send_room_chat_message_voice($_Item_Send_Room_Chat_Message_Voice item_send_room_chat_message_voice) {
        this.item_send_room_chat_message_voice = item_send_room_chat_message_voice;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == item_send_room_chat_message_voice.getMessage_send_voice().getId()) {
            Toast.makeText(v.getContext(), "ITEM PRESSED = " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
            new $_Play_Sound("Sound", (($_Message_Voice) MainActivity.allMessages.get($_ClientStatic.idRecived).second.get(getAdapterPosition())).getVoice_data(), item_send_room_chat_message_voice.getMessage_send_voice_seek_bar(), item_send_room_chat_message_voice.getMessage_send_voice(), item_send_room_chat_message_voice.getMessage_send_value());

        } else {
            Toast.makeText(v.getContext(), "ROW PRESSED = " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
        }

    }

    private void initAction() {
        //itemView.setOnClickListener(this::onClick);
        item_send_room_chat_message_voice.getMessage_send_voice().setOnClickListener(this::onClick);

    }


}
