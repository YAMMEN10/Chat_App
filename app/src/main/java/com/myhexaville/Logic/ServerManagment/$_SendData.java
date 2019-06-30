package com.myhexaville.Logic.ServerManagment;

import com.myhexaville.Logic.Interprete.$_Encode;
import com.myhexaville.Logic.JSONData.$_JSON;

/**
 *
 */
public class $_SendData extends $_Connect {

    /**
     * Default constructor
     */

    private String type;

    public $_SendData($_JSON json, String type) {
        this.my_json = json;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return
     */
    public void excute() {
        // TODO implement here
        $_Encode encode = new $_Encode(my_json, type);
        encode.run();
        this.json_object = encode.getJson_object();


    }


}