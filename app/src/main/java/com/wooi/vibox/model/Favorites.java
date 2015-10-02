package com.wooi.vibox.model;

/**
 * Created by Wooi on 15/10/1.
 */
public class Favorites {

    /**
     * status : {}
     * favorited_time : Sun Feb 08 19:55:42 +0800 2015
     */

    private Status status;
    private String favorited_time;

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setFavorited_time(String favorited_time) {
        this.favorited_time = favorited_time;
    }

    public Status getStatus() {
        return status;
    }

    public String getFavorited_time() {
        return favorited_time;
    }

    public static class StatusEntity {
    }
}
