package com.wooi.vibox.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.wooi.vibox.DataApplication;
import com.wooi.vibox.R;
import com.wooi.vibox.adapter.UserVPAdapter;
import com.wooi.vibox.util.Content;
import com.wooi.vibox.util.HttpUtil;

import org.apache.http.Header;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2015/9/25.
 */
public class UserPageFragment extends BaseFragment {

    @Bind(R.id.user_cover)
    ImageView userCover;
    @Bind(R.id.user_iv)
    ImageView userIv;
    @Bind(R.id.user_name)
    TextView userName;
    @Bind(R.id.user_description)
    TextView userDescription;
    @Bind(R.id.following_tv)
    TextView followingTv;
    @Bind(R.id.following_ll)
    LinearLayout followingLl;
    @Bind(R.id.follower)
    TextView follower;
    @Bind(R.id.follower_ll)
    LinearLayout followerLl;
    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    @Bind(R.id.user_page_vp)
    ViewPager userPageVp;


    private List<Fragment> listFragment;
    private AppCompatActivity appCompatActivity;
    private String UID = DataApplication.getSingleton().getmUid();
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_page_fragment, container, false);
        ButterKnife.bind(this, view);
//        Intent intent = mActivity.getIntent();
//        UID =intent.getStringExtra("uid");
        listFragment = new ArrayList<Fragment>();
        listFragment.add(new UserTimeLine(UID));
        listFragment.add(new ContentFragment());
        appCompatActivity = (AppCompatActivity) mActivity;
        UserVPAdapter userVPAdapter = new UserVPAdapter(appCompatActivity.getSupportFragmentManager(), listFragment, mContext);
        userPageVp.setAdapter(userVPAdapter);
        tabLayout.setupWithViewPager(userPageVp);
        return view;
    }

    @Override
    protected void initData() {

    }

    private void getPageContent() {
        HttpUtil.get(Content.USER_TIMELINE, new RequestParams(), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
