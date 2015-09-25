package com.wooi.vibox.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wooi.vibox.R;
import com.wooi.vibox.adapter.UserVPAdapter;

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
    @Bind(R.id.collapsing_toolbar_layout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @Bind(R.id.user_page_vp)
    ViewPager userPageVp;

    private List<Fragment> listFragment;
    private AppCompatActivity appCompatActivity;
    @Override
    View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_page_fragment, container, false);
        ButterKnife.bind(this, view);
        listFragment=new ArrayList<Fragment>();
        listFragment.add(new ContentFragment());
        listFragment.add(new ContentFragment());
        appCompatActivity = (AppCompatActivity) mActivity;
        UserVPAdapter userVPAdapter = new UserVPAdapter(appCompatActivity.getSupportFragmentManager(),listFragment,mContext);
        userPageVp.setAdapter(userVPAdapter);
        return view;
    }

    @Override
    protected void initData() {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
