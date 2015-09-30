package com.wooi.vibox.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.wooi.vibox.R;
import com.wooi.vibox.model.Status;
import com.wooi.vibox.util.ImageLoaderOptionsUtil;
import com.wooi.vibox.util.Parse;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2015/9/17.
 */
public class ContentRVAdapter extends RecyclerView.Adapter<ContentRVAdapter.ViewHolder> {
    protected ArrayList<Status> statusList;
    private Context context;
    private RvOnClickListner rvOnClickListner = null;
    private GvOnClickListener gvOnClickListener = null;
    private IbOnClickListener ibOnClickListener = null;

    public ContentRVAdapter(Context context, ArrayList<Status> statusList) {
        this.statusList = statusList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_item_fragment, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        setContent(viewHolder, position);
        getLargeImage(viewHolder, position);
        clickUserImage(viewHolder,position);
    }

    protected void setContent(ViewHolder viewHolder, int i) {
        Status status = statusList.get(i);
        setAllText(viewHolder, status);
        setImage(viewHolder, status);

    }

    protected void setImage(ViewHolder viewHolder, Status status) {
        viewHolder.commentsRepostCount.setText(status.getReposts_count() + "条转发 & " + status.getComments_count() + "条回复");
        String url = status.getUser().getAvatar_large();
        ImageLoader.getInstance().displayImage(url, viewHolder.userIb, ImageLoaderOptionsUtil.getWholeOptions());
        int numColumns = status.getPic_urls().size();
        if (numColumns >= 3) {
            numColumns = 3;
        }
        if (status.getPic_urls() != null) {
            ImageGridAdapter imageGridAdapter = new ImageGridAdapter(context, status.getPic_urls());
            viewHolder.contentGv.setAdapter(imageGridAdapter);
            viewHolder.contentGv.setNumColumns(numColumns);
        }
        if (status.getRetweeted_status() != null) {
            viewHolder.retweetedContentTv.setText("@" + status.getRetweeted_status().getUser().getName() + " : " + status.getRetweeted_status().getText());
            viewHolder.retweetedCommentsRepostCount.setText(status.getRetweeted_status().getReposts_count() + "条转发 & " +
                    status.getRetweeted_status().getComments_count() + "条回复");
            ImageGridAdapter imageGridAdapter = new ImageGridAdapter(context, status.getRetweeted_status().getPic_urls());
            viewHolder.retweetedContentGv.setAdapter(imageGridAdapter);
            int retweetedNumColumns = status.getPic_urls().size();
            if (retweetedNumColumns >= 3) {
                retweetedNumColumns = 3;
            }
            viewHolder.retweetedContentGv.setNumColumns(numColumns);
            viewHolder.retweetedContentGv.setNumColumns(retweetedNumColumns);
        }
    }

    protected void setAllText(ViewHolder viewHolder, Status status) {
        viewHolder.contentTv.setText(status.getText());
        viewHolder.timeTv.setText(status.getCreated_at());
        viewHolder.userTv.setText(status.getUser().getName());
        String device = Parse.parseXmlGetDevice(status.getSource());
        viewHolder.deviceTv.setText(device);
    }

    private void getLargeImage(ViewHolder viewHolder, final int ItemPosition) {
        viewHolder.contentGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                gvOnClickListener.gvItemClick(ItemPosition, position);
            }
        });
    }

    private void clickUserImage(ViewHolder viewHolder, final int ItemPosition) {
        viewHolder.userIb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ibOnClickListener.ibItemClick(ItemPosition);
            }
        });
    }

    @Override
    public int getItemCount() {
        return statusList.size();
    }

    public void setRvOnClickListener(RvOnClickListner rvOnClickListner) {
        this.rvOnClickListner = rvOnClickListner;
    }

    public void setGvOnClickListener(GvOnClickListener gvOnClickListener) {
        this.gvOnClickListener = gvOnClickListener;
    }

    public void setIbOnClickListener(IbOnClickListener ibOnClickListener) {
        this.ibOnClickListener = ibOnClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
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

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void onClick(View v) {
            if (rvOnClickListner != null) {
                rvOnClickListner.rvItemClick(v, getPosition());
            }
        }

    }

    public static interface RvOnClickListner {
        void rvItemClick(View v, int posistion);
    }

    public static interface GvOnClickListener {
        void gvItemClick(int itemPosition, int position);
    }

    public static interface IbOnClickListener {
        void ibItemClick(int itemPostion);
    }
}
