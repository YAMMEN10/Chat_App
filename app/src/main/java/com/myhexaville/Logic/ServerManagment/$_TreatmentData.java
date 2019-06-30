package com.myhexaville.Logic.ServerManagment;

import org.json.JSONObject;

/**
 *
 */
public class $_TreatmentData {

    /**
     * Default constructor
     */

    private JSONObject json;

    public $_TreatmentData(JSONObject json) {
        this.json = json;
    }

    /**
     * @return
     */
    public void excute() {
        // TODO implement here
        $_ReciveData reciveData = new $_ReciveData(json);

        reciveData.excute();


    }
}