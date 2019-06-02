package com.myhexaville.UI.Adapter.AdapterRoomChat.RecivevMessage.ReciveMessageVoice;

import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.myhexaville.UI.Adapter.AdapterRoomChat.RecivevMessage.ReciveMessageAbstruct.$_Item_Recive_Room_Chat_Message_Abstruct;
import com.myhexaville.login.R;

public class $_Item_Recive_Room_Chat_Message_Voice extends $_Item_Recive_Room_Chat_Message_Abstruct {
    private ImageButton message_recived_voice;
    private SeekBar message_recive_voice_seek_bar;
    private TextView message_recive_value;


    public $_Item_Recive_Room_Chat_Message_Voice(View view) {
        super(view);
        date_recive = view.findViewById(R.id.date_recive_voice);
        name_recive = view.findViewById(R.id.name_recive_voice);
        message_recived_voice = view.findViewById(R.id.btn_recive_play_voice);
        message_recive_voice_seek_bar = view.findViewById(R.id.message_recive_voice_seek_bar);
        message_recive_value = view.findViewById(R.id.message_recive_value);
    }

    public SeekBar getMessage_recive_voice_seek_bar() {
        return message_recive_voice_seek_bar;
    }

    public void setMessage_recive_voice_seek_bar(SeekBar message_recive_voice_seek_bar) {
        this.message_recive_voice_seek_bar = message_recive_voice_seek_bar;
    }

    public TextView getMessage_recive_value() {
        return message_recive_value;
    }

    public void setMessage_recive_value(TextView message_recive_value) {
        this.message_recive_value = message_recive_value;
    }

    public ImageButton getMessage_recived_voice() {
        return message_recived_voice;
    }

    public void setMessage_recived_voice(ImageButton message_recived_voice) {
        this.message_recived_voice = message_recived_voice;
    }


}
