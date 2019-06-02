package com.myhexaville.UI.Adapter.AdapterRoomChat.Message.MessageImage;


import com.myhexaville.UI.Adapter.AdapterRoomChat.Message.$_Message;

import java.io.Serializable;

public class $_Message_Image extends $_Message implements Serializable {
    private byte[] bytes;

    public $_Message_Image(String id, String name, String type, String time, byte[] bytes) {
        super(id, name, type, time);
        this.bytes = bytes;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
