package com.wooi.vibox.fragment;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.wooi.vibox.model.Status;
import com.wooi.vibox.util.Content;
import com.wooi.vibox.util.GetJSONArray;
import com.wooi.vibox.util.HttpUtil;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/9/29.
 */
public class FavoritesFragment extends ContentFragment {
    private String URL = Content.FAVORITES;

    @Override
    protected void initData() {
        getFavorites();
    }

    private void getFavorites() {
        HttpUtil.get(URL, new RequestParams(), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                JSONArray favoritesList = GetJSONArray.getFavoritesList(response);
                ArrayList<Status> statusList = getStatuses(favoritesList);

            }
        });
    }
}
