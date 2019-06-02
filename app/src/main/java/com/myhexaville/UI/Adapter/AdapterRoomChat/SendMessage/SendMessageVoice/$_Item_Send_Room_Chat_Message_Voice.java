package com.myhexaville.UI.Adapter.AdapterRoomChat.SendMessage.SendMessageVoice;

import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.myhexaville.UI.Adapter.AdapterRoomChat.SendMessage.SendMessageAbstruct.$_Item_Send_Room_Chat_Message_Abstruct;
import com.myhexaville.login.R;

public class $_Item_Send_Room_Chat_Message_Voice extends $_Item_Send_Room_Chat_Message_Abstruct {
    private ImageButton message_send_voice;
    private SeekBar message_send_voice_seek_bar;
    private TextView message_send_value;

    public $_Item_Send_Room_Chat_Message_Voice(View view) {
        super(view);
        date_send = view.findViewById(R.id.date_send_voice);
        message_send_voice = view.findViewById(R.id.btn_send_play_voice);
        message_send_voice_seek_bar = view.findViewById(R.id.message_send_voice_seek_bar);
        message_send_value = view.findViewById(R.id.message_send_value);
    }


    public SeekBar getMessage_send_voice_seek_bar() {
        return message_send_voice_seek_bar;
    }

    public void setMessage_send_voice_seek_bar(SeekBar message_send_voice_seek_bar) {
        this.message_send_voice_seek_bar = message_send_voice_seek_bar;
    }

    public TextView getMessage_send_value() {
        return message_send_value;
    }

    public void setMessage_send_value(TextView message_send_value) {
        this.message_send_value = message_send_value;
    }

    public ImageButton getMessage_send_voice() {
        return message_send_voice;
    }

    public void setMessage_send_voice(ImageButton message_send_voice) {
        this.message_send_voice = message_send_voice;
    }


}
