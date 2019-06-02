package com.myhexaville.UI.Adapter.AdapterRoomChat.RecivevMessage.ReciveMessageImage;

import com.myhexaville.UI.Adapter.AdapterRoomChat.RecivevMessage.ReciveMessageAbstruct.$_Value_Recive_Item_Room_Chat_Message_Abstruct;

public class $_Value_Recive_Item_Room_Chat_Message_Image extends $_Value_Recive_Item_Room_Chat_Message_Abstruct {
    byte[] bytes;

    public $_Value_Recive_Item_Room_Chat_Message_Image(byte[] bytes, String name, String date) {
        super(name, date);
        this.bytes = bytes;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
