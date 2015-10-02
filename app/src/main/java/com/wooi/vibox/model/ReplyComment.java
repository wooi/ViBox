package com.wooi.vibox.model;

/**
 * Created by Wooi on 15/10/2.
 */
public class ReplyComment {

    /**
     * created_at : Wed Nov 19 16:16:00 +0800 2014
     * id : 3778654754176045
     * text : 水泥里看到我的学费
     * source_allowclick : 0
     * source_type : 1
     * source : <a href="http://app.weibo.com/t/feed/c66T5g" rel="nofollow">Android客户端</a>
     * user : {}
     * mid : 3778654754176045
     * idstr : 3778654754176045
     * floor_num : 2
     */

    private String created_at;
    private long id;
    private String text;
    private int source_allowclick;
    private int source_type;
    private String source;
    private User user;
    private String mid;
    private String idstr;
    private int floor_num;

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSource_allowclick(int source_allowclick) {
        this.source_allowclick = source_allowclick;
    }

    public void setSource_type(int source_type) {
        this.source_type = source_type;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public void setIdstr(String idstr) {
        this.idstr = idstr;
    }

    public void setFloor_num(int floor_num) {
        this.floor_num = floor_num;
    }

    public String getCreated_at() {
        return created_at;
    }

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public int getSource_allowclick() {
        return source_allowclick;
    }

    public int getSource_type() {
        return source_type;
    }

    public String getSource() {
        return source;
    }

    public User getUser() {
        return user;
    }

    public String getMid() {
        return mid;
    }

    public String getIdstr() {
        return idstr;
    }

    public int getFloor_num() {
        return floor_num;
    }

    public static class User {
    }
}
