package com.myhexaville.Logic.Client;

import android.content.Context;

import com.myhexaville.Logic.ServerManagment.$_CheckOnline;
import com.myhexaville.Logic.Tools.$_SharedPreferences;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class $_Client {
    public static String idRecived = "";
    private static Socket socketOnline;
    private static Socket socketMessage;
    private static DataOutputStream dataOutputStreamOnline = null;
    private static DataInputStream dataInputStreamOnline = null;
    private static DataOutputStream dataOutputStreamMessage = null;
    private static DataInputStream dataInputStreamMessage = null;
    private static $_CheckOnline checkOnline;
    private static $_SharedPreferences sharedPreferences;
    private static String Email = "Email";
    private static String UserName = "Username";

    public $_Client(Context context) throws IOException {
        socketOnline = new Socket("192.168.43.116", 5000);
        socketMessage = new Socket("192.168.43.116", 5000);
        dataOutputStreamOnline = new DataOutputStream(socketOnline.getOutputStream());
        dataInputStreamOnline = new DataInputStream(socketOnline.getInputStream());
        dataOutputStreamMessage = new DataOutputStream(socketMessage.getOutputStream());
        dataInputStreamMessage = new DataInputStream(socketMessage.getInputStream());
    }


    public static Socket getSocketOnline() {
        return socketOnline;
    }

    public static void setSocketOnline(Socket socketOnline) {
        $_Client.socketOnline = socketOnline;
    }

    public static Socket getSocketMessage() {
        return socketMessage;
    }

    public static void setSocketMessage(Socket socketMessage) {
        $_Client.socketMessage = socketMessage;
    }

    public static DataOutputStream getDataOutputStreamMessage() {
        return dataOutputStreamMessage;
    }

    public static void setDataOutputStreamMessage(DataOutputStream dataOutputStreamMessage) {
        $_Client.dataOutputStreamMessage = dataOutputStreamMessage;
    }

    public static DataInputStream getDataInputStreamMessage() {
        return dataInputStreamMessage;
    }

    public static void setDataInputStreamMessage(DataInputStream dataInputStreamMessage) {
        $_Client.dataInputStreamMessage = dataInputStreamMessage;
    }

    public static $_CheckOnline getCheckOnline() {
        return checkOnline;
    }

    public static void setCheckOnline($_CheckOnline checkOnline) {
        $_Client.checkOnline = checkOnline;
    }

    public static $_SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public static void setSharedPreferences($_SharedPreferences sharedPreferences) {
        $_Client.sharedPreferences = sharedPreferences;
    }

    public static String getEmail() {
        return Email;
    }

    public static void setEmail(String email) {
        Email = email;
    }

    public static String getUserName() {
        return UserName;
    }

    public static void setUserName(String userName) {
        UserName = userName;
    }

    public synchronized static Socket getSocket() {
        return socketOnline;
    }

    public synchronized static void setSocket(Socket socket) {
        $_Client.socketOnline = socket;
    }

    public synchronized static DataOutputStream getDataOutputStreamOnline() {
        return dataOutputStreamOnline;
    }

    public synchronized static void setDataOutputStreamOnline(DataOutputStream dataOutputStreamOnline) {
        $_Client.dataOutputStreamOnline = dataOutputStreamOnline;
    }

    public synchronized static DataInputStream getDataInputStreamOnline() {
        return dataInputStreamOnline;
    }

    public synchronized static void setDataInputStreamOnline(DataInputStream dataInputStreamOnline) {
        $_Client.dataInputStreamOnline = dataInputStreamOnline;
    }


}
