package com.wooi.vibox.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.wooi.vibox.DataApplication;
import com.wooi.vibox.R;
import com.wooi.vibox.activity.TweetContent;
import com.wooi.vibox.activity.UserPage;
import com.wooi.vibox.adapter.ContentRVAdapter;
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
public class ContentFragment extends BaseFragment {
    @Bind(R.id.testbt)
    Button testbt;
    @Bind(R.id.content_rv)
    RecyclerView contentRv;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Status> statusContentList;
    private String URL = Content.FRIEDNDURL;
    private final static String UID = DataApplication.getSingleton().getmUid();


    @Override
    View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_fragment, container, false);
        ButterKnife.bind(this, view);
        mLayoutManager = new LinearLayoutManager(mContext);
        contentRv.setLayoutManager(mLayoutManager);
        contentRv.setHasFixedSize(true);
        return view;
    }

    @OnClick(R.id.testbt)
    public void click() {
        getTimeLine(URL, getParams());
    }

    @Override
    protected void initData() {
        getTimeLine(URL, getParams());
    }

    protected void getTimeLine(String URL, RequestParams params) {
        HttpUtil.get(URL, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                JSONArray responseArray = GetJSONArray.getStatuses(response);
                ArrayList<Status> statusList = getStatuses(responseArray);
                setViewAdapter(statusList);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Log.i(this.toString(), errorResponse.toString());
            }
        });

    }

    protected void setViewAdapter(ArrayList<Status> statusList) {
        statusContentList = statusList;
        ContentRVAdapter adapter = new ContentRVAdapter(mContext, statusContentList);
        contentRv.setAdapter(adapter);
        setListener(adapter);
    }

    protected void setListener(ContentRVAdapter adapter) {
        adapter.setRvOnClickListener(new MyRvOnClickListener());
        adapter.setGvOnClickListener(new MyGvOnClickListener());
        adapter.setIbOnClickListener(new MyIbOnClickListener());
    }

    @Nullable
    protected ArrayList<Status> getStatuses(JSONArray responseArray) {
        Type listType = new TypeToken<ArrayList<Status>>() {
        }.getType();
        return new Gson().fromJson(responseArray.toString(), listType);
    }

    protected RequestParams getParams() {
        RequestParams requestParams = new RequestParams();
        requestParams.put("uid", UID);
        return requestParams;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    protected class MyRvOnClickListener implements ContentRVAdapter.RvOnClickListner {

        @Override
        public void rvItemClick(View v, int posistion) {
            Toast.makeText(mContext, "" + posistion, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(mActivity, TweetContent.class);
            intent.putExtra("status", statusContentList.get(posistion));
            startActivity(intent);
        }
    }

    protected class MyGvOnClickListener implements ContentRVAdapter.GvOnClickListener {

        @Override
        public void gvItemClick(int itemPosition, int position) {
            Toast.makeText(mContext, itemPosition + "" + position, Toast.LENGTH_SHORT).show();

        }
    }

    protected class MyIbOnClickListener implements ContentRVAdapter.IbOnClickListener {
        @Override
        public void ibItemClick(int itemPostion) {
//            Status status = statusContentList.get(itemPostion);
//            String UID =status.getUser().getIdstr();
            Intent intent = new Intent(mActivity, UserPage.class);
//            intent.putExtra("uid",UID);
            startActivity(intent);
        }
    }
}
