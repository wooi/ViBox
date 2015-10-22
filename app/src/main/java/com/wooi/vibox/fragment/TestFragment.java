package com.wooi.vibox.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wooi.vibox.R;

/**
 * Created by Administrator on 2015/10/20.
 */
public class TestFragment extends BaseFragment {
    private TestFragment() {
    }
    public static TestFragment newInstance(int page,String title){
        return new TestFragment();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_fragment,container,false);
        return view;
    }
}
