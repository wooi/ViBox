package com.wooi.vibox.adapter;

import android.content.Context;

import com.wooi.vibox.model.Status;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/9/29.
 */
public class FavoritesRVAdapter extends ContentRVAdapter {

    public FavoritesRVAdapter(Context context, ArrayList<Status> statusList) {
        super(context, statusList);
    }

    @Override
    protected void setContent(ViewHolder viewHolder, int i) {

    }
}
