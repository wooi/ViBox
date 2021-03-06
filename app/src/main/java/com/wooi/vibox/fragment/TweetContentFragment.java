package com.wooi.vibox.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.wooi.vibox.R;
import com.wooi.vibox.adapter.CommentsAdapter;
import com.wooi.vibox.adapter.ImageGridAdapter;
import com.wooi.vibox.model.Comments;
import com.wooi.vibox.model.Status;
import com.wooi.vibox.ui.SimpleDividerItemDecoration;
import com.wooi.vibox.util.Content;
import com.wooi.vibox.util.GetJSONArray;
import com.wooi.vibox.util.HttpUtil;
import com.wooi.vibox.util.ImageLoaderOptionsUtil;
import com.wooi.vibox.util.Parse;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2015/9/21.
 */
public class TweetContentFragment extends BaseFragment {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.user_ib)
    ImageButton userIb;
    @Bind(R.id.user_tv)
    TextView userTv;
    @Bind(R.id.device_tv)
    TextView deviceTv;
    @Bind(R.id.time_tv)
    TextView timeTv;
    @Bind(R.id.content_tv)
    TextView contentTv;
    @Bind(R.id.content_gv)
    GridView contentGv;
    @Bind(R.id.retweeted_content_tv)
    TextView retweetedContentTv;
    @Bind(R.id.retweeted_content_gv)
    GridView retweetedContentGv;
    @Bind(R.id.retweeted_comments_repost_count)
    TextView retweetedCommentsRepostCount;
    @Bind(R.id.comments_repost_count)
    TextView commentsRepostCount;
    @Bind(R.id.comments_rv)
    RecyclerView commentsRv;
    @Bind(R.id.thumbnail_iv)
    ImageView thumbnailIv;
    @Bind(R.id.content_ly)
    LinearLayout contentLy;
    @Bind(R.id.retweeted_thumbnail_iv)
    ImageView retweetedThumbnailIv;
    @Bind(R.id.retweeted_content_ly)
    LinearLayout retweeted_content_ly;
    @Bind(R.id.collapsing_toolbar_layout)
    CollapsingToolbarLayout collapsingToolbarLayout;

    private AppCompatActivity appCompatActivity;
    private Status status;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tweet_content_fragment_layout, container, false);
        ButterKnife.bind(this, view);
        Intent intent = mActivity.getIntent();
        status = (Status) intent.getSerializableExtra("status");
        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        commentsRv.setLayoutManager(mLayoutManager);
        commentsRv.setHasFixedSize(true);
        appCompatActivity = (AppCompatActivity) mActivity;
        appCompatActivity.setSupportActionBar(toolbar);
        appCompatActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new MytoolBarClickListener());
        collapsingToolbarLayout.setPadding(0, getStatusBarHeight(), 0, 0);
        return view;
    }

    @Override
    protected void initData() {
        getSingleContent();
        getComments();
    }

    private void getSingleContent() {
        setAllText(status);
        setContentImage(status);
        setRetwettedContent(status);
        setRetwettedContent(status);
    }

    protected void setAllText(Status status) {
        contentTv.setText(status.getText());
        timeTv.setText(status.getCreated_at());
        userTv.setText(status.getUser().getName());
        String device = Parse.parseXmlGetDevice(status.getSource());
        deviceTv.setText(device);
        commentsRepostCount.setText(status.getReposts_count() + "条转发 & " + status.getComments_count() + "条回复");
    }

    protected void setContentImage(Status status) {
        String url = status.getUser().getAvatar_large();
        ImageLoader.getInstance().displayImage(url, userIb, ImageLoaderOptionsUtil.getWholeOptions());
        if (status.getPic_urls() != null) {
            contentGv.setVisibility(View.VISIBLE);
            ImageGridAdapter imageGridAdapter = new ImageGridAdapter(mContext, status.getPic_urls());
            contentGv.setAdapter(imageGridAdapter);
        }

    }

    private void setRetwettedContent(Status status) {
        if (status.getRetweeted_status() != null) {
            retweeted_content_ly.setVisibility(View.VISIBLE);
            retweetedContentTv.setText("@" + status.getRetweeted_status().getUser().getName() + " : " + status.getRetweeted_status().getText());
            retweetedCommentsRepostCount.setText(status.getRetweeted_status().getReposts_count() + "条转发 & " +
                    status.getRetweeted_status().getComments_count() + "条回复");
            setRetwettedImage(status);
        } else {
            retweeted_content_ly.setVisibility(View.GONE);
        }
    }

    private void setRetwettedImage(Status status) {
        if (status.getRetweeted_status().getPic_urls() != null) {
            retweetedThumbnailIv.setVisibility(View.GONE);
            retweetedContentGv.setVisibility(View.VISIBLE);
            ImageGridAdapter imageGridAdapter = new ImageGridAdapter(mContext, status.getRetweeted_status().getPic_urls());
            retweetedContentGv.setAdapter(imageGridAdapter);
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    private void onBackPress() {
        mActivity.finish();
        mActivity.overridePendingTransition(0, R.anim.slide_out_to_left_from_right);
    }

    public void getComments() {
        RequestParams requestParams = new RequestParams();
        requestParams.put("id", status.getId());
        HttpUtil.get(Content.COMMENTS, requestParams, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                JSONArray commentsJSONArray = GetJSONArray.getComments(response);
                Type listType = new TypeToken<ArrayList<Comments>>() {
                }.getType();
                ArrayList<Comments> commentArrayList = new Gson().fromJson(commentsJSONArray.toString(), listType);
                CommentsAdapter commentsAdapter = new CommentsAdapter(getActivity().getApplicationContext(), commentArrayList);
                commentsRv.setAdapter(commentsAdapter);
                commentsRv.addItemDecoration(new SimpleDividerItemDecoration(getActivity().getApplicationContext()));
            }
        });
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    private class MytoolBarClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            onBackPress();
        }
    }
}
