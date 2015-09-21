package com.wooi.vibox.model;

/**
 * Created by Administrator on 2015/9/21.
 */
public class Comments {

    /**
     * created_at : Mon Sep 21 16:58:04 +0800 2015
     * id : 3889556032253385
     * text : 贾导啊，能不能早点上映。拍半年，后期制作几个月，可宣传要两年，节奏实在有点慢啊!
     * source_allowclick : 0
     * source_type : 1
     * source : <a href="http://weibo.com/" rel="nofollow">微博 weibo.com</a>
     * user : null
     * mid : 3889556032253385
     * idstr : 3889556032253385
     * status : null
     * floor_num : 24
     */

    public String created_at;
    public long id;
    public String text;
    public int source_allowclick;
    public int source_type;
    public String source;
    public User user;
    public String mid;
    public String idstr;
//    public Object status;
    public int floor_num;

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getSource_allowclick() {
        return source_allowclick;
    }

    public void setSource_allowclick(int source_allowclick) {
        this.source_allowclick = source_allowclick;
    }

    public int getSource_type() {
        return source_type;
    }

    public void setSource_type(int source_type) {
        this.source_type = source_type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getIdstr() {
        return idstr;
    }

    public void setIdstr(String idstr) {
        this.idstr = idstr;
    }

    public int getFloor_num() {
        return floor_num;
    }

    public void setFloor_num(int floor_num) {
        this.floor_num = floor_num;
    }
}
