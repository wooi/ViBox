package com.wooi.vibox.util;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;
import com.wooi.vibox.DataApplication;

import static com.loopj.android.http.AsyncHttpClient.getUrlWithQueryString;

/**
 * Created by Administrator on 2015/9/7.
 */
public class HttpUtil {
    private final static String UID = DataApplication.getSingleton().getmUid();
    private final static String TOKEN = DataApplication.getSingleton().getmToken();


    static final AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, ResponseHandlerInterface responseHandlerInterface) {
        client.get(url, responseHandlerInterface);
    }

    public static void get(String url,RequestParams params ,ResponseHandlerInterface responseHandlerInterface) {
        params.put("access_token",TOKEN);
        params.put("uid",UID);
        client.get(url,params,responseHandlerInterface);
        Log.i("URL",getUrlWithQueryString(true, url, params));
    }
}
