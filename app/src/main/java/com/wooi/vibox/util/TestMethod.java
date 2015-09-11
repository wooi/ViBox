package com.wooi.vibox.util;

import android.util.Log;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Administrator on 2015/9/11.
 */
public class TestMethod {
    public static void getUserInfo(){
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("access_token", "2.00FLsKEC0JZ_wrb789018166ZPyBUC");
        paramsMap.put("uid", "1893962551");
        RequestParams params = new RequestParams(paramsMap);
        HttpUtil.get("https://api.weibo.com/2/users/show.json", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Log.i("TAG", response.toString());
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Log.i("TAG", errorResponse.toString());

            }
        });
    }


}
