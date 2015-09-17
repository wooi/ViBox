package com.wooi.vibox.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.wooi.vibox.R;
import com.wooi.vibox.adapter.ContentRecyclerViewApater;
import com.wooi.vibox.logger.Logger;
import com.wooi.vibox.model.Status;
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
import butterknife.OnClick;

/**
 * Created by Administrator on 2015/9/16.
 */
public class ContentFragment extends Fragment {
    @Bind(R.id.testbt)
    Button testbt;
    @Bind(R.id.content_rv)
    RecyclerView contentRv;

    RecyclerView.LayoutManager mLayoutManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_fragment, container, false);
        ButterKnife.bind(this, view);
        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        contentRv.setLayoutManager(mLayoutManager);
        contentRv.setHasFixedSize(true);
        return view;
    }

    @OnClick(R.id.testbt)
    public void click() {
        getFriendTimeLine();
    }

    private void getFriendTimeLine() {
        HttpUtil.get(Content.FRIEDNDURL, new RequestParams(), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                JSONArray responseArray = GetJSONArray.getStatuses(response);
                Type listType = new TypeToken<ArrayList<Status>>() {
                }.getType();
                ArrayList<Status> statusList = new Gson().fromJson(responseArray.toString(), listType);
                ContentRecyclerViewApater apater = new ContentRecyclerViewApater(getActivity().getApplicationContext(),statusList);
                contentRv.setAdapter(apater);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Log.i(this.toString(), errorResponse.toString());

            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
