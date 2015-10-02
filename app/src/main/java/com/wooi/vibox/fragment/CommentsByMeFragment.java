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
import com.wooi.vibox.adapter.CommentsRVAdapter;
import com.wooi.vibox.model.Comments;
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
 * Created by Wooi on 15/10/1.
 */
public class CommentsByMeFragment extends BaseFragment {

    @Bind(R.id.comments_rv)
    RecyclerView commentsRv;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.comments_fragment_layout, container, false);
        ButterKnife.bind(this, view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mContext);
        commentsRv.setHasFixedSize(true);
        commentsRv.setLayoutManager(layoutManager);
        return view;
    }

    @Override
    protected void initData() {
        getComments();
    }

    public void getComments() {
        HttpUtil.get(Content.COMMENTSBYME, new RequestParams(), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                JSONArray byMeJSONArray = GetJSONArray.getComments(response);
                ArrayList<Comments> commentsList = getComment(byMeJSONArray);
                setViewAdapter(commentsList);
            }
        });
    }

    private ArrayList<Comments> getComment(JSONArray byMeJSONArray) {
        Type typelist = new TypeToken<ArrayList<Comments>>() {
        }.getType();
        return new Gson().fromJson(byMeJSONArray.toString(), typelist);

    }

    private void setViewAdapter(ArrayList<Comments> commentsList) {
        CommentsRVAdapter adapter = new CommentsRVAdapter(mContext, commentsList);
        commentsRv.setAdapter(adapter);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
