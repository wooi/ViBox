package com.wooi.vibox.demo.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2015/9/11.
 */
public class User {

    /**
     * id : 1802726235
     * idstr : 1802726235
     * class : 1
     * screen_name : 作家张大春
     * name : 作家张大春
     * province : 71
     * city : 1
     * location : 台湾 台北市
     * description : 好故事、練说书、學书法、爱赋诗。 豆瓣个人小站：http://site.douban.com/106711/
     * url : http://blog.sina.com.cn/zhangdachunblog
     * profile_image_url : http://tp4.sinaimg.cn/1802726235/50/40029077387/1
     * profile_url : sixiyouguo
     * domain : sixiyouguo
     * weihao :
     * gender : m
     * followers_count : 2318480
     * friends_count : 341
     * pagefriends_count : 0
     * statuses_count : 2873
     * favourites_count : 10
     * created_at : Fri Aug 27 09:04:45 +0800 2010
     * following : true
     * allow_all_act_msg : false
     * geo_enabled : true
     * verified : true
     * verified_type : 0
     * remark :
     * ptype : 3
     * allow_all_comment : true
     * avatar_large : http://tp4.sinaimg.cn/1802726235/180/40029077387/1
     * avatar_hd : http://ww1.sinaimg.cn/crop.70.326.980.980.1024/6b736b5bgw1e6u7gcoxa6j20v719eqbj.jpg
     * verified_reason : 作家
     * verified_trade : 1101
     * verified_reason_url :
     * verified_source :
     * verified_source_url :
     * verified_state : 0
     * verified_level : 1
     * verified_reason_modified :
     * verified_contact_name :
     * verified_contact_email :
     * verified_contact_mobile :
     * follow_me : false
     * online_status : 0
     * bi_followers_count : 312
     * lang : zh-tw
     * star : 0
     * mbtype : 2
     * mbrank : 4
     * block_word : 0
     * block_app : 0
     * credit_score : 80
     * user_ability : 0
     * urank : 25
     */

    public int id;
    public String idstr;
    @SerializedName("class")
    public int classX;
    public String screen_name;
    public String name;
    public String province;
    public String city;
    public String location;
    public String description;
    public String url;
    public String profile_image_url;
    public String profile_url;
    public String domain;
    public String weihao;
    public String gender;
    public int followers_count;
    public int friends_count;
    public int pagefriends_count;
    public int statuses_count;
    public int favourites_count;
    public String created_at;
    public boolean following;
    public boolean allow_all_act_msg;
    public boolean geo_enabled;
    public boolean verified;
    public int verified_type;
    public String remark;
    public int ptype;
    public boolean allow_all_comment;
    public String avatar_large;
    public String avatar_hd;
    public String verified_reason;
    public String verified_trade;
    public String verified_reason_url;
    public String verified_source;
    public String verified_source_url;
    public int verified_state;
    public int verified_level;
    public String verified_reason_modified;
    public String verified_contact_name;
    public String verified_contact_email;
    public String verified_contact_mobile;
    public boolean follow_me;
    public int online_status;
    public int bi_followers_count;
    public String lang;
    public int star;
    public int mbtype;
    public int mbrank;
    public int block_word;
    public int block_app;
    public int credit_score;
    public int user_ability;
    public int urank;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdstr() {
        return idstr;
    }

    public void setIdstr(String idstr) {
        this.idstr = idstr;
    }

    public int getClassX() {
        return classX;
    }

    public void setClassX(int classX) {
        this.classX = classX;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProfile_image_url() {
        return profile_image_url;
    }

    public void setProfile_image_url(String profile_image_url) {
        this.profile_image_url = profile_image_url;
    }

    public String getProfile_url() {
        return profile_url;
    }

    public void setProfile_url(String profile_url) {
        this.profile_url = profile_url;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getWeihao() {
        return weihao;
    }

    public void setWeihao(String weihao) {
        this.weihao = weihao;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(int followers_count) {
        this.followers_count = followers_count;
    }

    public int getFriends_count() {
        return friends_count;
    }

    public void setFriends_count(int friends_count) {
        this.friends_count = friends_count;
    }

    public int getPagefriends_count() {
        return pagefriends_count;
    }

    public void setPagefriends_count(int pagefriends_count) {
        this.pagefriends_count = pagefriends_count;
    }

    public int getStatuses_count() {
        return statuses_count;
    }

    public void setStatuses_count(int statuses_count) {
        this.statuses_count = statuses_count;
    }

    public int getFavourites_count() {
        return favourites_count;
    }

    public void setFavourites_count(int favourites_count) {
        this.favourites_count = favourites_count;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public boolean isFollowing() {
        return following;
    }

    public void setFollowing(boolean following) {
        this.following = following;
    }

    public boolean isAllow_all_act_msg() {
        return allow_all_act_msg;
    }

    public void setAllow_all_act_msg(boolean allow_all_act_msg) {
        this.allow_all_act_msg = allow_all_act_msg;
    }

    public boolean isGeo_enabled() {
        return geo_enabled;
    }

    public void setGeo_enabled(boolean geo_enabled) {
        this.geo_enabled = geo_enabled;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public int getVerified_type() {
        return verified_type;
    }

    public void setVerified_type(int verified_type) {
        this.verified_type = verified_type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getPtype() {
        return ptype;
    }

    public void setPtype(int ptype) {
        this.ptype = ptype;
    }

    public boolean isAllow_all_comment() {
        return allow_all_comment;
    }

    public void setAllow_all_comment(boolean allow_all_comment) {
        this.allow_all_comment = allow_all_comment;
    }

    public String getAvatar_large() {
        return avatar_large;
    }

    public void setAvatar_large(String avatar_large) {
        this.avatar_large = avatar_large;
    }

    public String getAvatar_hd() {
        return avatar_hd;
    }

    public void setAvatar_hd(String avatar_hd) {
        this.avatar_hd = avatar_hd;
    }

    public String getVerified_reason() {
        return verified_reason;
    }

    public void setVerified_reason(String verified_reason) {
        this.verified_reason = verified_reason;
    }

    public String getVerified_trade() {
        return verified_trade;
    }

    public void setVerified_trade(String verified_trade) {
        this.verified_trade = verified_trade;
    }

    public String getVerified_reason_url() {
        return verified_reason_url;
    }

    public void setVerified_reason_url(String verified_reason_url) {
        this.verified_reason_url = verified_reason_url;
    }

    public String getVerified_source() {
        return verified_source;
    }

    public void setVerified_source(String verified_source) {
        this.verified_source = verified_source;
    }

    public String getVerified_source_url() {
        return verified_source_url;
    }

    public void setVerified_source_url(String verified_source_url) {
        this.verified_source_url = verified_source_url;
    }

    public int getVerified_state() {
        return verified_state;
    }

    public void setVerified_state(int verified_state) {
        this.verified_state = verified_state;
    }

    public int getVerified_level() {
        return verified_level;
    }

    public void setVerified_level(int verified_level) {
        this.verified_level = verified_level;
    }

    public String getVerified_reason_modified() {
        return verified_reason_modified;
    }

    public void setVerified_reason_modified(String verified_reason_modified) {
        this.verified_reason_modified = verified_reason_modified;
    }

    public String getVerified_contact_name() {
        return verified_contact_name;
    }

    public void setVerified_contact_name(String verified_contact_name) {
        this.verified_contact_name = verified_contact_name;
    }

    public String getVerified_contact_email() {
        return verified_contact_email;
    }

    public void setVerified_contact_email(String verified_contact_email) {
        this.verified_contact_email = verified_contact_email;
    }

    public String getVerified_contact_mobile() {
        return verified_contact_mobile;
    }

    public void setVerified_contact_mobile(String verified_contact_mobile) {
        this.verified_contact_mobile = verified_contact_mobile;
    }

    public boolean isFollow_me() {
        return follow_me;
    }

    public void setFollow_me(boolean follow_me) {
        this.follow_me = follow_me;
    }

    public int getOnline_status() {
        return online_status;
    }

    public void setOnline_status(int online_status) {
        this.online_status = online_status;
    }

    public int getBi_followers_count() {
        return bi_followers_count;
    }

    public void setBi_followers_count(int bi_followers_count) {
        this.bi_followers_count = bi_followers_count;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getMbtype() {
        return mbtype;
    }

    public void setMbtype(int mbtype) {
        this.mbtype = mbtype;
    }

    public int getMbrank() {
        return mbrank;
    }

    public void setMbrank(int mbrank) {
        this.mbrank = mbrank;
    }

    public int getBlock_word() {
        return block_word;
    }

    public void setBlock_word(int block_word) {
        this.block_word = block_word;
    }

    public int getBlock_app() {
        return block_app;
    }

    public void setBlock_app(int block_app) {
        this.block_app = block_app;
    }

    public int getCredit_score() {
        return credit_score;
    }

    public void setCredit_score(int credit_score) {
        this.credit_score = credit_score;
    }

    public int getUser_ability() {
        return user_ability;
    }

    public void setUser_ability(int user_ability) {
        this.user_ability = user_ability;
    }

    public int getUrank() {
        return urank;
    }

    public void setUrank(int urank) {
        this.urank = urank;
    }
}
