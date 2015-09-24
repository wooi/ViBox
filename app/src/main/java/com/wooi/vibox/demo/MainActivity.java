/*
 * Copyright (C) 2010-2013 The SINA WEIBO Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wooi.vibox.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.sina.weibo.sdk.utils.LogUtil;
import com.wooi.vibox.R;
import com.wooi.vibox.demo.Util.HttpUtiltest;
import com.wooi.vibox.demo.openapi.WBAuthActivity;
import com.wooi.vibox.demo.openapi.WBOpenAPIActivity;

import org.apache.http.Header;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * 该类是整个 DEMO 程序的入口。
 *
 * @author wooi
 * @since 2015-8-21
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button;
    /**
     * @see {@link Activity#onCreate}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogUtil.sIsLogEnable = true;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_main);
        setSupportActionBar(toolbar);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.demo:
                startActivity(new Intent(MainActivity.this, WBAuthActivity.class));
                break;
            case R.id.open_api:
                startActivity(new Intent(MainActivity.this, WBOpenAPIActivity.class));
                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                HashMap<String ,String> paramsMap = new HashMap<>();
                paramsMap.put("access_token","2.00FLsKEC0JZ_wrb789018166ZPyBUC");
                paramsMap.put("uid","1893962551");
                RequestParams params = new RequestParams(paramsMap);
                HttpUtiltest.get("https://api.weibo.com/2/users/show.json", params, new JsonHttpResponseHandler() {
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
                break;
        }
    }
}
