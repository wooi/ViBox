package com.wooi.vibox.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wooi.vibox.R;

/**
 * Created by Administrator on 2015/9/28.
 */
public class FollowedFragment extends FollowingFragment {
    private String URL;

    public FollowedFragment(String URL) {
        this.URL = URL;
    }

    @Override
    protected void initData() {
        getFollowingList(URL);
    }
}
