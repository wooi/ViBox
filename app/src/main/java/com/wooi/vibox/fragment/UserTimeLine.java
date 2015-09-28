package com.wooi.vibox.fragment;

import com.loopj.android.http.RequestParams;
import com.wooi.vibox.util.Content;

/**
 * Created by Administrator on 2015/9/28.
 */
public class UserTimeLine extends ContentFragment {
    private String URL = Content.USER_TIMELINE;
    private String UID;

    public UserTimeLine(String UID) {
        this.UID = UID;
    }

    @Override
    protected void initData() {
        getTimeLine(URL,getParams());
    }

    @Override
    protected RequestParams getParams() {
        RequestParams requestParams = new RequestParams();
        requestParams.put("uid",UID);
        return requestParams;
    }
}
