package com.myhexaville.Logic.Interprete;

import com.myhexaville.Logic.JSONData.$_JSON;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class $_Encode extends $_Interprete {

    /**
     * Default constructor
     */
    public $_Encode() {
    }

    @Override
    public $_JSON run() {
        return null;
    }

    public List<JSONObject> run(List<$_JSON> ourListJSON) {

        List<JSONObject> ListJSONObjectToSend = new ArrayList<>();

        for ($_JSON js : ourListJSON) {

            switch (js.getType()) {
                case "Login_User_Successful": {


                }
                break;
                case "Sign_Up_Successful": {


                }
                break;


            }


        }
        return ListJSONObjectToSend;
    }

}