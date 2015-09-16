package com.wooi.vibox.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.wooi.vibox.R;
import com.wooi.vibox.model.PictureUrl;
import com.wooi.vibox.util.ImageLoaderOptionsUtil;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2015/9/16.
 */
public class ImageGridAdapter extends BaseAdapter {
    private List<PictureUrl> picUrlsList;
    private Context context;

    public ImageGridAdapter(Context context, List<PictureUrl> list) {
        this.context = context;
        this.picUrlsList = list;
    }

    @Override
    public int getCount() {
        return picUrlsList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.image_gridview_item_layout, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        int width = parent.getWidth();
        int ivWidth = (width-20)/3;
        viewHolder.picUrlIv.setLayoutParams(new LinearLayout.LayoutParams(ivWidth,ivWidth));
        ImageLoader.getInstance().displayImage(picUrlsList.get(position).getThumbnail_pic(), viewHolder.picUrlIv, ImageLoaderOptionsUtil.getWholeOptions());
        return view;
    }


    static class ViewHolder {
        @Bind(R.id.pic_url_iv)
        ImageView picUrlIv;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
            View parents = (View) picUrlIv.getParent();
            int width = parents.getWidth();
            int ivWidth  = (width -20)/3;

//            picUrlIv.setLayoutParams(new LinearLayout.LayoutParams(ivWidth, ivWidth));
        }
    }
}
