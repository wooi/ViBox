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

package com.wooi.vibox.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.sina.weibo.sdk.utils.LogUtil;
import com.wooi.vibox.R;
import com.wooi.vibox.adapter.ImageGridAdapter;
import com.wooi.vibox.logger.Logger;
import com.wooi.vibox.model.Status;
import com.wooi.vibox.openapi.WBAuthActivity;
import com.wooi.vibox.openapi.WBOpenAPIActivity;
import com.wooi.vibox.util.Content;
import com.wooi.vibox.util.GetJSONArray;
import com.wooi.vibox.util.HttpUtil;
import com.wooi.vibox.util.ImageLoaderOptionsUtil;
import com.wooi.vibox.util.Parse;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 该类是整个 DEMO 程序的入口。
 *
 * @author wooi
 * @since 2015-8-21
 */
public class MainActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.button)
    Button button;

    @Bind(R.id.user_ib)
    ImageButton userIb;
    @Bind(R.id.user_tv)
    TextView userTv;
    @Bind(R.id.device_tv)
    TextView deviceTv;
    @Bind(R.id.time_tv)
    TextView timeTv;
    @Bind(R.id.content_tv)
    TextView contentTv;
    @Bind(R.id.retweeted_content_tv)
    TextView retweetedContentTv;
    @Bind(R.id.retweeted_comments_repost_count)
    TextView retweetedCommentsRepostCount;
    @Bind(R.id.comments_repost_count)
    TextView commentsRepostCount;
    @Bind(R.id.content_gv)
    GridView contentGv;
    @Bind(R.id.retweeted_content_gv)
    GridView retweetedContentGv;


    /**
     * @see {@link Activity#onCreate}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        LogUtil.sIsLogEnable = true;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_main);
        setSupportActionBar(toolbar);
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
            case R.id.content:
                startActivity(new Intent(MainActivity.this, ContentActivity.class));
                break;
            case R.id.page:
                startActivity(new Intent(MainActivity.this, UserPage.class));
                break;
            case R.id.follow:
                startActivity(new Intent(MainActivity.this, Follow.class));
                break;
        }
        return true;
    }

    @OnClick(R.id.button)
    public void button() {
        getFriendTimeLine();
    }


    private void getFriendTimeLine() {
        HttpUtil.get(Content.FRIEDNDURL, new RequestParams(), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                JSONArray responseArray = GetJSONArray.getStatuses(response);
                Type listType = new TypeToken<ArrayList<Status>>() {
                }.getType();
                ArrayList<Status> statusList = new Gson().fromJson(responseArray.toString(), listType);
                Status firstStatus = statusList.get(0);
                String creaded = firstStatus.getCreated_at();
                String text = firstStatus.getText();
                String userName = firstStatus.getUser().getName();
                String device = Parse.parseXmlGetDevice(firstStatus.getSource());
                timeTv.setText(creaded);
                contentTv.setText(text);
                userTv.setText(userName);
                deviceTv.setText(device);
                commentsRepostCount.setText(firstStatus.getReposts_count() + "条转发 & " + firstStatus.getComments_count() + "条回复");
                String url = firstStatus.getUser().getProfile_image_url();
                ImageLoader.getInstance().displayImage(url, userIb, ImageLoaderOptionsUtil.getWholeOptions());
                if (firstStatus.getPic_urls() != null) {
                    ImageGridAdapter imageGridAdapter = new ImageGridAdapter(getApplicationContext(), firstStatus.getPic_urls());
                    contentGv.setAdapter(imageGridAdapter);
                }
                if (firstStatus.getRetweeted_status() != null) {
                    retweetedContentTv.setText("@" + firstStatus.getRetweeted_status().getUser().getName() + " : " + firstStatus.getRetweeted_status().getText());
                    retweetedCommentsRepostCount.setText(firstStatus.getRetweeted_status().getReposts_count() + "条转发 & " +
                            firstStatus.getRetweeted_status().getComments_count() + "条回复");
                    ImageGridAdapter imageGridAdapter = new ImageGridAdapter(getApplicationContext(), firstStatus.getRetweeted_status().getPic_urls());
                    retweetedContentGv.setAdapter(imageGridAdapter);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Log.i(this.toString(), errorResponse.toString());

            }
        });

    }


}
