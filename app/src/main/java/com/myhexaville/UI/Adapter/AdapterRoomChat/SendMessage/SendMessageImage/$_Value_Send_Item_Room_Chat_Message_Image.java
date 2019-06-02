package com.myhexaville.UI.Adapter.AdapterRoomChat.SendMessage.SendMessageImage;

import com.myhexaville.UI.Adapter.AdapterRoomChat.SendMessage.SendMessageAbstruct.$_Value_Send_Item_Room_Chat_Message_Abstruct;

public class $_Value_Send_Item_Room_Chat_Message_Image extends $_Value_Send_Item_Room_Chat_Message_Abstruct {
    byte[] bytes;

    public $_Value_Send_Item_Room_Chat_Message_Image(byte[] bytes, String date) {
        super(date);
        this.bytes = bytes;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
