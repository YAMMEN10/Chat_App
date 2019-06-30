package com.myhexaville.Logic.Interprete;

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
        this.json_object = jsonObject;
    }

    public void run() throws JSONException {
        // TODO implement here
        switch (json_object.getString("Type")) {
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
    }


}