package com.myhexaville.Logic.Interprete;

import com.myhexaville.Logic.JSONData.$_JSON;

import org.json.JSONException;
import org.json.JSONObject;


/**
 *
 */
public class $_Decode extends $_Interprete {
    /**
     * Default constructor
     */
    public $_Decode(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public $_JSON run() throws JSONException {
        // TODO implement here
        switch (jsonObject.getString("Type")) {
            case "Login_User": {

                break;
            }
            case "Sign_Up": {

                break;
            }

            /// Oday Editing :
            case "User_Image_Edit": {

                break;
            }
            case "User_Name_Edit": {

                break;
            }
            case "User_State_Edit": {


                break;
            }
            case "User_Password_Edit": {


                break;
            }


            default:
                break;
        }
        return my_json;
    }


}