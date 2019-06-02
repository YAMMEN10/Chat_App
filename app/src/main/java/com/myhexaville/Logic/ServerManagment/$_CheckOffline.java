package com.myhexaville.Logic.ServerManagment;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class $_CheckOffline extends Thread {
    private Socket socket;

    public $_CheckOffline(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        DataInputStream dis;
        try {
            socket.setSoTimeout(500);
        } catch (SocketException e) {
        }
        try {
            dis = new DataInputStream(socket.getInputStream());
            while (true) {
                dis.readUTF();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            if (socket.isConnected())
                System.out.println("closed");
            else System.out.println("yes");
        }
    }
}
