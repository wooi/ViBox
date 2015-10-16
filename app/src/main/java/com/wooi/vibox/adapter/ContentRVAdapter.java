package com.wooi.vibox.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.wooi.vibox.R;
import com.wooi.vibox.model.Status;
import com.wooi.vibox.ui.LinkEnableTextView;
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

    public ContentRVAdapter(Context context) {
        this.context = context;
    }

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
        openLargeImage(viewHolder, position);
        clickUserImage(viewHolder, position);
    }

    protected void setContent(ViewHolder viewHolder, int i) {
        Status status = statusList.get(i);
        setAllText(viewHolder, status);
        setContentImage(viewHolder, status);
        setRetwettedContent(viewHolder, status);
    }

    protected void setAllText(ViewHolder viewHolder, Status status) {
        viewHolder.contentTv.gatherLinksForText(status.getText());
        viewHolder.timeTv.setText(status.getCreated_at());
        viewHolder.userTv.setText(status.getUser().getName());
        String device = Parse.parseXmlGetDevice(status.getSource());
        viewHolder.deviceTv.setText(device);
        viewHolder.commentsRepostCount.setText(status.getReposts_count() + "条转发 & " + status.getComments_count() + "条回复");
    }

    protected void setContentImage(ViewHolder viewHolder, Status status) {
        String url = status.getUser().getAvatar_large();
        ImageLoader.getInstance().displayImage(url, viewHolder.userIb, ImageLoaderOptionsUtil.getWholeOptions());
        if (status.getPic_urls() != null) {
            viewHolder.contentGv.setVisibility(View.VISIBLE);
            ImageGridAdapter imageGridAdapter = new ImageGridAdapter(context, status.getPic_urls());
            viewHolder.contentGv.setAdapter(imageGridAdapter);
        }

    }

    private void setRetwettedContent(ViewHolder viewHolder, Status status) {
        if (status.getRetweeted_status() != null) {
            viewHolder.retweeted_content_ly.setVisibility(View.VISIBLE);
            viewHolder.retweetedContentTv.gatherLinksForText("@" + status.getRetweeted_status().getUser().getName() + " : " + status.getRetweeted_status().getText());
            viewHolder.retweetedCommentsRepostCount.setText(status.getRetweeted_status().getReposts_count() + "条转发 & " +
                    status.getRetweeted_status().getComments_count() + "条回复");
            setRetwettedImage(viewHolder, status);
        } else {
            viewHolder.retweeted_content_ly.setVisibility(View.GONE);
        }
    }

    private void setRetwettedImage(ViewHolder viewHolder, Status status) {
        if (status.getRetweeted_status().getPic_urls() != null) {
            viewHolder.retweetedThumbnailIv.setVisibility(View.GONE);
            viewHolder.retweetedContentGv.setVisibility(View.VISIBLE);
            ImageGridAdapter imageGridAdapter = new ImageGridAdapter(context, status.getRetweeted_status().getPic_urls());
            viewHolder.retweetedContentGv.setAdapter(imageGridAdapter);
        }
    }

    private void openLargeImage(ViewHolder viewHolder, final int ItemPosition) {
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
        LinkEnableTextView contentTv;
        @Bind(R.id.content_gv)
        GridView contentGv;
        @Bind(R.id.retweeted_content_tv)
        LinkEnableTextView retweetedContentTv;
        @Bind(R.id.retweeted_content_gv)
        GridView retweetedContentGv;
        @Bind(R.id.retweeted_comments_repost_count)
        TextView retweetedCommentsRepostCount;
        @Bind(R.id.comments_repost_count)
        TextView commentsRepostCount;
        @Bind(R.id.thumbnail_iv)
        ImageView thumbnailIv;
        @Bind(R.id.retweeted_content_ly)
        LinearLayout retweeted_content_ly;
        @Bind(R.id.retweeted_thumbnail_iv)
        ImageView retweetedThumbnailIv;

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
