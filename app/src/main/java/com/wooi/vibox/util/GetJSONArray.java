package com.wooi.vibox.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2015/9/11.
 */
public class GetJSONArray {
    public  static JSONArray getStatuses(JSONObject jsonObject)  {
        JSONArray statusJSONArray = null;
        try {
            statusJSONArray = jsonObject.getJSONArray("statuses");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return statusJSONArray;
    }
}
