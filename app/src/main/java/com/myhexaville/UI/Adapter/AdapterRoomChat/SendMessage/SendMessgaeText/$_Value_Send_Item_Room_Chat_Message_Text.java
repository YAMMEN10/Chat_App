package com.myhexaville.UI.Adapter.AdapterRoomChat.SendMessage.SendMessgaeText;


import com.myhexaville.UI.Adapter.AdapterRoomChat.SendMessage.SendMessageAbstruct.$_Value_Send_Item_Room_Chat_Message_Abstruct;

public class $_Value_Send_Item_Room_Chat_Message_Text extends $_Value_Send_Item_Room_Chat_Message_Abstruct {
    private String message;

    public $_Value_Send_Item_Room_Chat_Message_Text(String message, String date) {
        super(date);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
