package com.myhexaville.Logic.ServerManagment;

import com.myhexaville.Logic.Interprete.$_Decode;
import com.myhexaville.Logic.Interprete.$_Interprete;

import org.json.JSONObject;


/**
 *
 */
public class $_ReciveData extends $_Connect {

    /**
     * Default constructor
     */

    private JSONObject json;

    public $_ReciveData(JSONObject json) {
        this.json = json;
    }


    public void excute() {
        // TODO implement here
        $_Interprete interprete = new $_Decode(json);
        //my_json = interprete.run();

    }

}