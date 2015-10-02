package com.wooi.vibox.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.wooi.vibox.R;
import com.wooi.vibox.fragment.BaseFragment;
import com.wooi.vibox.util.Content;
import com.wooi.vibox.util.GetJSONArray;
import com.wooi.vibox.util.HttpUtil;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Wooi on 15/10/1.
 */
public class CommentsByMeFragment extends BaseFragment {

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.comments_fragment_layout,container,false);
        return view ;
    }

    @Override
    protected void initData() {
        getComments();
    }

    public void getComments() {
        HttpUtil.get(Content.COMMENTSBYME,new RequestParams(),new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                JSONArray byMeJSONArray = GetJSONArray.getComments(response);
            }
        });
    }


}
