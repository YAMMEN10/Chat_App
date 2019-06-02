package com.myhexaville.Logic.ServerManagment;

import com.myhexaville.Logic.Client.$_Client;
import com.myhexaville.Logic.JSONData.$_JSONAttributes;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.Executors;

/**
 *
 */
public class $_CheckOnline extends $_Background {

    /**
     * Default constructor
     */

    JSONObject jsonObject;

    public $_CheckOnline(String email, String type, String value) {
        jsonObject = new JSONObject();
        try {
            jsonObject.put($_JSONAttributes.Id.toString(), email);
            jsonObject.put($_JSONAttributes.Type.toString(), type);
            jsonObject.put("Value", value);

        } catch (JSONException e) {
            System.err.println("error put json");
        }
        executorService = Executors.newSingleThreadExecutor();
        future = executorService.submit(this);

    }

    public void excute() {
        // TODO implement here
    }

    @Override
    public void run() {
        while (true) {
            try {
                $_Client.getDataOutputStreamOnline().writeUTF(jsonObject.toString());
                Thread.sleep(1000);
                System.out.println("aaaaaaaaaaaa");
            } catch (InterruptedException e) {
                System.err.println("error interrupt write online");
            } catch (IOException e) {
                try {
                    System.out.println("cloooooooooos");
                    $_Client.getSocketOnline().close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }

        }

    }
}