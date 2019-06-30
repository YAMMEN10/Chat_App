package com.myhexaville.Logic.Interprete;

import com.myhexaville.Logic.JSONData.$_JSON;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 */
public abstract class $_Interprete {
    protected JSONObject json_object;
    protected $_JSON my_json;
    String type;

    public $_Interprete() {
    }

    public JSONObject getJson_object() {
        return json_object;
    }

    public void setJson_object(JSONObject json_object) {
        this.json_object = json_object;
    }

    public $_JSON getMy_json() {
        return my_json;
    }

    public void setMy_json($_JSON my_json) {
        this.my_json = my_json;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract void run() throws JSONException;


}