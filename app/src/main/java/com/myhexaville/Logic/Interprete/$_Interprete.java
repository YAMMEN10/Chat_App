package com.myhexaville.Logic.Interprete;

import com.myhexaville.Logic.JSONData.$_JSON;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 */
public abstract class $_Interprete {
    protected JSONObject jsonObject;
    protected $_JSON my_json;

    public $_Interprete() {
    }

    public abstract $_JSON run() throws JSONException;


}