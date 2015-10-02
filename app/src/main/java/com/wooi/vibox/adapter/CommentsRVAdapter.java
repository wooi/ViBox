package com.wooi.vibox.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sina.weibo.sdk.openapi.models.Comment;
import com.wooi.vibox.R;
import com.wooi.vibox.model.Comments;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Wooi on 15/10/2.
 */
public class CommentsRVAdapter extends RecyclerView.Adapter<CommentsRVAdapter.ViewHolder> {
    private ArrayList<Comments> commentsList;
    private Context context;

    public CommentsRVAdapter(Context context, ArrayList<Comments> commentsList) {
        this.context = context;
        this.commentsList = commentsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.comments_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Comments comments = commentsList.get(position);
        holder.commentTv.setText(comments.getText());
        if(comments.getReply_comment()!=null){
            holder.replyCommentTv.setText(comments.getReply_comment().getText());
        }else{
            holder.replyCommentTv.setText(comments.getStatus().getText());
        }
    }

    @Override
    public int getItemCount() {
        return commentsList.size();
    }

    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'comments_item.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Avast Developers (http://github.com/avast)
     */
    static

    public class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.comment_tv)
        TextView commentTv;
        @Bind(R.id.reply_comment_tv)
        TextView replyCommentTv;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
