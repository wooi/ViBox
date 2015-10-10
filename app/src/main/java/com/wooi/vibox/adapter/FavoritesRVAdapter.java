package com.wooi.vibox.adapter;
import android.content.Context;
import com.wooi.vibox.model.Favorites;
import com.wooi.vibox.model.Status;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/9/29.
 */
public class FavoritesRVAdapter extends ContentRVAdapter {
    ArrayList<Favorites> favoriteArrayList;

    public FavoritesRVAdapter(Context context, ArrayList<Favorites> favoritesList) {
        super(context);
        this.favoriteArrayList = favoritesList;
    }

    @Override
    protected void setContent(ViewHolder viewHolder, int i) {
        Favorites favorite = favoriteArrayList.get(i);
        Status status = favorite.getStatus();
        if(status.getDeleted()==null && status.getRetweeted_status().getDeleted()==null){
            setAllText(viewHolder,status);
            setContentImage(viewHolder, status);
        }

    }

    @Override
    public int getItemCount() {
        return favoriteArrayList.size();
    }
}
