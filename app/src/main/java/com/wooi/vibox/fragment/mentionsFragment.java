package com.wooi.vibox.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loopj.android.http.RequestParams;
import com.wooi.vibox.R;
import com.wooi.vibox.util.Content;

/**
 * Created by Wooi on 15/10/1.
 */
public class mentionsFragment extends ContentFragment {
    String URL = Content.MENTIONS;
    @Override
    protected void initData() {
        getTimeLine(URL,new RequestParams());
    }


}
