package com.wooi.vibox.fragment;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.sina.weibo.sdk.openapi.models.Favorite;
import com.wooi.vibox.adapter.FavoritesRVAdapter;
import com.wooi.vibox.model.Favorites;
import com.wooi.vibox.model.Status;
import com.wooi.vibox.util.Content;
import com.wooi.vibox.util.GetJSONArray;
import com.wooi.vibox.util.HttpUtil;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Administrator on 2015/9/29.
 */
public class FavoritesFragment extends ContentFragment {
    private String URL = Content.FAVORITES;

    public static FavoritesFragment newInstance(int page,String title){
        FavoritesFragment favoritesFragment = new FavoritesFragment();
        return favoritesFragment;
    }
    @Override
    protected void initData() {
        getFavorites();
    }

    private void getFavorites() {
        HttpUtil.get(URL, new RequestParams(), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                JSONArray responeseArray = GetJSONArray.getFavoritesList(response);
                ArrayList<Favorites> favoritesList = getFavorites(responeseArray);
                setViewAdpater(favoritesList);

            }
        });
    }

    private ArrayList<Favorites> getFavorites(JSONArray responeseArray) {
        Type typelist = new TypeToken<ArrayList<Favorites>>(){}.getType();
        return new Gson().fromJson(responeseArray.toString(),typelist);
    }

    @Override
    public void setViewAdapter(ArrayList<Status> statusList) {
        super.setViewAdapter(statusList);
    }

    private void setViewAdpater(ArrayList<Favorites> arrayList){
        FavoritesRVAdapter adapter = new FavoritesRVAdapter(mContext,arrayList);
        contentRv.setAdapter(adapter);
//        setListener(adapter);
    }
}
