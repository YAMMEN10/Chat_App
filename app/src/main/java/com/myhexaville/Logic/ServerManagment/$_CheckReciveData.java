package com.myhexaville.Logic.ServerManagment;

import com.myhexaville.Logic.Client.$_Client;

import java.io.IOException;

/**
 *
 */
public class $_CheckReciveData extends $_Background {

    /**
     * Default constructor
     */

    Object result;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public void run() {


    }

    /**
     * @return
     */
    public void excute() {
        // TODO implement here
        try {
            final String s = $_Client.getDataInputStreamMessage().readUTF();
            result = s;

            // new $_TreatmentData(new JSONObject(s)).excute();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}