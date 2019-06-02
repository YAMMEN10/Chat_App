package com.myhexaville.UI.Adapter.AdapterRoomChat.RecivevMessage.ReciveMessageAbstruct;

public abstract class $_Value_Recive_Item_Room_Chat_Message_Abstruct {
    private String name;
    private String date;

    public $_Value_Recive_Item_Room_Chat_Message_Abstruct(String name, String date) {
        this.date = date;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
