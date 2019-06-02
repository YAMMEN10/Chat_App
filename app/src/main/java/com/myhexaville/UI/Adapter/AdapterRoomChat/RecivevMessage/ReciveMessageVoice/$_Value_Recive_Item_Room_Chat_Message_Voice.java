package com.myhexaville.UI.Adapter.AdapterRoomChat.RecivevMessage.ReciveMessageVoice;

import com.myhexaville.UI.Adapter.AdapterRoomChat.RecivevMessage.ReciveMessageAbstruct.$_Value_Recive_Item_Room_Chat_Message_Abstruct;

public class $_Value_Recive_Item_Room_Chat_Message_Voice extends $_Value_Recive_Item_Room_Chat_Message_Abstruct {
    double voice_seek_bar;

    public $_Value_Recive_Item_Room_Chat_Message_Voice(double voice_seek_bar, String name, String date) {
        super(name, date);
        this.voice_seek_bar = voice_seek_bar;
    }

    public double getBytes() {
        return voice_seek_bar;
    }

    public void setBytes(double voice_seek_bar) {
        this.voice_seek_bar = voice_seek_bar;
    }
}
