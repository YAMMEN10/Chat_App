package com.myhexaville.UI.Adapter.AdapterRoomChat.RecivevMessage.ReciveMessageText;

import android.view.View;
import android.widget.TextView;

import com.myhexaville.UI.Adapter.AdapterRoomChat.RecivevMessage.ReciveMessageAbstruct.$_Item_Recive_Room_Chat_Message_Abstruct;
import com.myhexaville.login.R;

public class $_Item_Recive_Room_Chat_Text extends $_Item_Recive_Room_Chat_Message_Abstruct {


    private TextView message_recive;

    public $_Item_Recive_Room_Chat_Text(View view) {
        super(view);
        message_recive = view.findViewById(R.id.message_recive_text);
        name_recive = view.findViewById(R.id.name_recive_text);
        date_recive = view.findViewById(R.id.date_recive_text);
    }


    public TextView getMessage_recive() {
        return message_recive;
    }

    public void setMessage_recive(TextView message_recive) {
        this.message_recive = message_recive;
    }


}
