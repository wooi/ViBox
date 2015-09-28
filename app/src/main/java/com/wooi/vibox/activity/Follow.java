package com.wooi.vibox.activity;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;

import com.wooi.vibox.R;
import com.wooi.vibox.fragment.FollowedFragment;
import com.wooi.vibox.fragment.FollowingFragment;
import com.wooi.vibox.util.Content;

/**
 * Created by Administrator on 2015/9/28.
 */
public class Follow extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.follow_layout);
        FollowingFragment followingFragment = new FollowedFragment(Content.USER_FOLLOWER);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.follow_fm,followingFragment);
        fragmentTransaction.commit();
    }
}
