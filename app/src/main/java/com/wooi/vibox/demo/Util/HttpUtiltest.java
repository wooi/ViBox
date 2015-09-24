package com.wooi.vibox.demo.Util;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;

/**
 * Created by Administrator on 2015/9/7.
 */
public class HttpUtiltest {
    static final AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, ResponseHandlerInterface responseHandlerInterface) {
        client.get(url, responseHandlerInterface);
    }

    public static void get(String url,RequestParams params ,ResponseHandlerInterface responseHandlerInterface) {
        client.get(url,params,responseHandlerInterface);
    }
}
