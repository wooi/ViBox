package com.wooi.vibox.demo.Util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2015/9/11.
 */
public class GetStatusJSONArray {
    public  static JSONArray getStatus(JSONObject jsonObject) throws JSONException {
        JSONArray statusJSONArray = jsonObject.getJSONArray("statuses");

        return statusJSONArray;
    }
}
