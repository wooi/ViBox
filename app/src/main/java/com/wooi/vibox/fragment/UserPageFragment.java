package com.wooi.vibox.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wooi.vibox.R;

/**
 * Created by Administrator on 2015/9/25.
 */
public class UserPageFragment extends BaseFragment {

    @Override
    protected void initData() {

    }

    @Override
    View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_page_fragment,container,false);
        return view;
    }
}
