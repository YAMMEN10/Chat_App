package com.myhexaville.UI.Adapter.AdapterRoomChat.RecivevMessage.ReciveMessageText;


import com.myhexaville.UI.Adapter.AdapterRoomChat.RecivevMessage.ReciveMessageAbstruct.$_Value_Recive_Item_Room_Chat_Message_Abstruct;

public class $_Value_Recive_Item_Room_Chat_Text extends $_Value_Recive_Item_Room_Chat_Message_Abstruct {
    private String content;

    public $_Value_Recive_Item_Room_Chat_Text(String name, String content, String date) {
        super(name, date);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
