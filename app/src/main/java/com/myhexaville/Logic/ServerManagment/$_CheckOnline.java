package com.myhexaville.Logic.ServerManagment;

import com.myhexaville.Logic.Client.$_ClientStatic;
import com.myhexaville.Logic.JSONData.$_JSON_Check_Online;

import org.json.JSONException;

import java.io.IOException;
import java.util.concurrent.Executors;

/**
 *
 */
public class $_CheckOnline extends $_Background {

    /**
     * Default constructor
     */
    private $_SendData sendData;

    public $_CheckOnline(String email, String type, String value) {
        try {
            $_JSON_Check_Online json_check_online = new $_JSON_Check_Online(type, email, value);
            sendData = new $_SendData(json_check_online, type);
            sendData.excute();
        } catch (JSONException e) {
            System.err.println("error put json");
        }
        executorService = Executors.newSingleThreadExecutor();
        future = executorService.submit(this);

    }


    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW = = " + sendData.getJson_object());
                $_ClientStatic.getDataOutputStreamOnline().writeUTF(sendData.getJson_object().toString());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("error interrupt write online");
            } catch (IOException e) {
                try {
                    System.out.println("cloooooooooos");
                    $_ClientStatic.getSocketOnline().close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }

        }

    }
}