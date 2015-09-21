package com.wooi.vibox.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/9/11.
 */
public class PictureUrl implements Serializable {

    /**
     * thumbnail_pic : http://ww2.sinaimg.cn/thumbnail/7049c17bjw1evylm2gueqj20b00gitac.jpg
     */

    public String thumbnail_pic;

    public String getThumbnail_pic() {
        return thumbnail_pic;
    }

    public void setThumbnail_pic(String thumbnail_pic) {
        this.thumbnail_pic = thumbnail_pic;
    }
}
