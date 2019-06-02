package com.myhexaville.UI.Adapter.AdapterRoomChat.SendMessage.SendMessageVoice;

import com.myhexaville.UI.Adapter.AdapterRoomChat.SendMessage.SendMessageAbstruct.$_Value_Send_Item_Room_Chat_Message_Abstruct;

public class $_Value_Send_Item_Room_Chat_Message_Voice extends $_Value_Send_Item_Room_Chat_Message_Abstruct {
    double voice_progress;

    public $_Value_Send_Item_Room_Chat_Message_Voice(double voice_progress, String date) {
        super(date);
        this.voice_progress = voice_progress;
    }

    public double getBytes() {
        return voice_progress;
    }

    public void setBytes(double bytes) {
        this.voice_progress = bytes;
    }
}
