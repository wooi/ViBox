package com.wooi.vibox.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.wooi.vibox.R;
import com.wooi.vibox.model.User;
import com.wooi.vibox.util.ImageLoaderOptionsUtil;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2015/9/28.
 */
public class FollowRVAdapter extends RecyclerView.Adapter<FollowRVAdapter.ViewHolder> {
    private ArrayList<User> userArrayList;
    private Context context;

    public FollowRVAdapter(Context mContext, ArrayList<User> userList) {
        this.userArrayList = userList;
        this.context= mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.follow_item_layout, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        getFollowList(holder, position);
    }

    private void getFollowList(ViewHolder viewHolder, int position){
        User user = userArrayList.get(position);
        viewHolder.followNameTv.setText(user.getName());
        ImageLoader.getInstance().displayImage(user.getAvatar_large(),viewHolder.followImageIv, ImageLoaderOptionsUtil.getWholeOptions());
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'follow_item_layout.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Avast Developers (http://github.com/avast)
     */

    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.follow_image_iv)
        ImageView followImageIv;
        @Bind(R.id.follow_name_tv)
        TextView followNameTv;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
