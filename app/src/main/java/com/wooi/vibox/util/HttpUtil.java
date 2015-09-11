package com.wooi.vibox.demo.Util;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;

import static com.loopj.android.http.AsyncHttpClient.getUrlWithQueryString;

/**
 * Created by Administrator on 2015/9/7.
 */
public class HttpUtil {
    static final AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, ResponseHandlerInterface responseHandlerInterface) {
        client.get(url, responseHandlerInterface);

    }

    public static void get(String url,RequestParams params ,ResponseHandlerInterface responseHandlerInterface) {
        client.get(url,params,responseHandlerInterface);
        String urlStr = getUrlWithQueryString(true, url, params);
        Log.i("URL",urlStr);
    }
}
