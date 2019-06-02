package com.myhexaville.UI.Adapter.AdapterRoomChat.Message.MessageText;


import com.myhexaville.UI.Adapter.AdapterRoomChat.Message.$_Message;

import java.io.Serializable;

public class $_Message_Text extends $_Message implements Serializable {
    String message_text;

    public $_Message_Text(String id, String name, String type, String time, String message_text) {
        super(id, name, type, time);
        this.message_text = message_text;
    }

    public String getMessage_text() {
        return message_text;
    }

    public void setMessage_text(String message_text) {
        this.message_text = message_text;
    }
}
