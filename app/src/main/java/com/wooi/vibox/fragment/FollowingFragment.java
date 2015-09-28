package com.wooi.vibox.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.wooi.vibox.R;
import com.wooi.vibox.adapter.FollowRVAdapter;
import com.wooi.vibox.logger.Logger;
import com.wooi.vibox.model.User;
import com.wooi.vibox.util.Content;
import com.wooi.vibox.util.GetJSONArray;
import com.wooi.vibox.util.HttpUtil;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2015/9/28.
 */
public class FollowingFragment extends BaseFragment {
    @Bind(R.id.follow_rv)
    RecyclerView followRv;
    private LinearLayoutManager mLayoutManager;
    private String URL ;
    @Override
    View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.follow_fragment_layout, null);
        ButterKnife.bind(this, view);
        mLayoutManager = new LinearLayoutManager(mContext);
        followRv.setLayoutManager(mLayoutManager);
        followRv.setHasFixedSize(true);
        return view;
    }

    @Override
    protected void initData() {
        getFollowingList(Content.USER_FOLLOWER);
    }

    public void getFollowingList(String URL) {
        HttpUtil.get(URL, new RequestParams(), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                JSONArray usersJSONArray = GetJSONArray.getFollowList(response);
                Type typeList = new TypeToken<ArrayList<User>>() {
                }.getType();
                ArrayList<User> userList = new Gson().fromJson(usersJSONArray.toString(), typeList);
                FollowRVAdapter adapter = new FollowRVAdapter(mContext, userList);
                followRv.setAdapter(adapter);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
