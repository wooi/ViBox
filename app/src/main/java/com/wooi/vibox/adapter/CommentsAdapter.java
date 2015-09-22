package com.wooi.vibox.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.wooi.vibox.R;
import com.wooi.vibox.model.Comments;
import com.wooi.vibox.util.ImageLoaderOptionsUtil;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2015/9/21.
 */
public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ViewHolder> {
    public Context context;
    ArrayList<Comments> commentsList;

    public CommentsAdapter(Context context, ArrayList<Comments> commentsList) {
        this.context = context;
        this.commentsList = commentsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Comments comment = commentsList.get(position);
        String url = comment.getUser().getProfile_image_url();
        ImageLoader.getInstance().displayImage(url, holder.userIb, ImageLoaderOptionsUtil.getWholeOptions());
        holder.userName.setText(comment.getUser().getName());
        holder.comments.setText(comment.getText());
    }

    @Override
    public int getItemCount() {
        return commentsList.size();
    }

    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'comment_item.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Avast Developers (http://github.com/avast)
     */
    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.user_ib)
        ImageButton userIb;
        @Bind(R.id.user_name)
        TextView userName;
        @Bind(R.id.comments)
        TextView comments;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
