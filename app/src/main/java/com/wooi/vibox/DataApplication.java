package com.wooi.vibox;

import android.app.Application;
import android.content.Context;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.wooi.vibox.token.AccessTokenKeeper;

/**
 * Created by Administrator on 2015/9/11.
 */
public class DataApplication extends Application {
    private  static DataApplication singleton;
    private Oauth2AccessToken mAccessToken;
    private String mToken;
    private String mUid;


    @Override
    public void onCreate() {
        super.onCreate();
        getTokenAndUid(this);
        singleton = this;
    }

    public static DataApplication getSingleton(){
        return singleton;
    }

    private void getTokenAndUid(Context context) {
         mAccessToken = AccessTokenKeeper.readAccessToken(context);
         mToken = mAccessToken.getToken();
         mUid = mAccessToken.getUid();
    }

    public String getmUid() {
        return mUid;
    }

    public String getmToken() {
        return mToken;
    }

}