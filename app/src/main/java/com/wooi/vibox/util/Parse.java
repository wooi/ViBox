package com.wooi.vibox.util;

import android.text.Html;

/**
 * Created by Administrator on 2015/9/17.
 */
public class Parse {
    public static String parseXmlGetDevice(String deviceXml) {
        String datas = String.valueOf(Html.fromHtml(deviceXml));
        return datas;
    }

}
