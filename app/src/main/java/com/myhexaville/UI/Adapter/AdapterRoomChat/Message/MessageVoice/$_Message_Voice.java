package com.myhexaville.UI.Adapter.AdapterRoomChat.Message.MessageVoice;

import com.myhexaville.UI.Adapter.AdapterRoomChat.Message.$_Message;

import java.io.Serializable;

public class $_Message_Voice extends $_Message implements Serializable {
    private double voice_bar;
    private byte[] voice_data;

    public $_Message_Voice(String id, String name, String type, String time, double voice_bar, byte[] voice_data) {
        super(id, name, type, time);
        this.voice_bar = voice_bar;
        this.voice_data = voice_data;
    }

    public double getVoice_bar() {
        return voice_bar;
    }

    public void setVoice_bar(double voice_bar) {
        this.voice_bar = voice_bar;
    }

    public byte[] getVoice_data() {
        return voice_data;
    }

    public void setVoice_data(byte[] voice_data) {
        this.voice_data = voice_data;
    }
}
