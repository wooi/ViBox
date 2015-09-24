package com.wooi.vibox.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.wooi.vibox.R;
import com.wooi.vibox.logger.Logger;
import com.wooi.vibox.model.User;
import com.wooi.vibox.util.Content;
import com.wooi.vibox.util.HttpUtil;
import com.wooi.vibox.util.ImageLoaderOptionsUtil;

import org.apache.http.Header;
import org.json.JSONObject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2015/9/16.
 */
public class ContentActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.navigation_view)
    NavigationView navigationView;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    private ImageView nav_header_bg,nav_header_user_imager;
    private TextView nav_header_user_name_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_layout);
        ButterKnife.bind(this);
        findViewById();
        initToolbar();
        initDrawerView();
        setDrawerContent();
    }

    private void findViewById() {
        nav_header_bg = (ImageView) findViewById(R.id.nav_header_bg_iv);
        nav_header_user_imager = (ImageView) findViewById(R.id.nav_header_user_imager_iv);
        nav_header_user_name_tv = (TextView) findViewById(R.id.nav_header_user_name_tv);
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initDrawerView() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer_content, R.string.close_drawer_content);
        toggle.syncState();
        drawerLayout.setDrawerListener(toggle);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                return false;
            }
        });
    }

    private void setDrawerContent() {
        HttpUtil.get(Content.USER, new RequestParams(), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                User user = new Gson().fromJson(response.toString(), User.class);
                nav_header_user_name_tv.setText(user.getName());
                ImageLoader.getInstance().displayImage(user.getCover_image_phone(), nav_header_bg, ImageLoaderOptionsUtil.getWholeOptions());
                ImageLoader.getInstance().displayImage(user.getAvatar_large(),nav_header_user_imager,ImageLoaderOptionsUtil.getWholeOptions());
            }
        });
    }


}
