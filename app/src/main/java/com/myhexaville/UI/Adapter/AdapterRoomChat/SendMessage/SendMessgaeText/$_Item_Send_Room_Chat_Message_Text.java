package com.myhexaville.UI.Adapter.AdapterRoomChat.SendMessage.SendMessgaeText;

import android.view.View;
import android.widget.TextView;

import com.myhexaville.UI.Adapter.AdapterRoomChat.SendMessage.SendMessageAbstruct.$_Item_Send_Room_Chat_Message_Abstruct;
import com.myhexaville.login.R;

public class $_Item_Send_Room_Chat_Message_Text extends $_Item_Send_Room_Chat_Message_Abstruct {
    private TextView message_send_text;

    public $_Item_Send_Room_Chat_Message_Text(View view) {
        super(view);
        message_send_text = view.findViewById(R.id.message_send_text);
        date_send = view.findViewById(R.id.date_send_text);

    }


    public TextView getMessage_send() {
        return message_send_text;
    }

    public void setMessage_send(TextView message_send) {
        this.message_send_text = message_send;
    }
}
