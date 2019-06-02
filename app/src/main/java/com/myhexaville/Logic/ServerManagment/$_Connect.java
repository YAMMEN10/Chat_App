package com.myhexaville.Logic.ServerManagment;

import com.myhexaville.Logic.JSONData.$_JSON;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 */
public abstract class $_Connect {

    protected JSONObject json;
    protected $_JSON my_json;
    protected int id_operation;

    /**
     * Default constructor
     */
    public $_Connect() {
    }

    /**
     * @return
     */
    public void excute() throws JSONException {
        // TODO implement here
    }

    public JSONObject getJson() {
        return json;
    }

    public void setJson(JSONObject json) {
        this.json = json;
    }

    public $_JSON getMy_json() {
        return my_json;
    }

    public void setMy_json($_JSON my_json) {
        this.my_json = my_json;
    }

    public int getId_operation() {
        return id_operation;
    }

    public void setId_operation(int id_operation) {
        this.id_operation = id_operation;
    }
}