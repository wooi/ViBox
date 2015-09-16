package com.wooi.vibox.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.wooi.vibox.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2015/9/16.
 */
public class ContentFragment extends Fragment {
    @Bind(R.id.testbt)
    Button testbt;
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contenr_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.testbt)
    public void test(){
        Log.i("TAG","test");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
