package com.rumofuture.nemo.model.entity;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by WangZhenqi on 2016/12/24.
 */

/**
 * @author 王振琦
 */
public class User extends BmobUser {
    /**
     * 姓名
     */
    private String name;
    /**
     * 座右铭
     */
    private String motto;
    /**
     * 简介
     */
    private String profile;
    /**
     * 职业
     */
    private String profession;
    /**
     * 所在地
     */
    private String location;

    /**
     * 性别
     */
    private String gender;
    /**
     * 生日
     */
    private String birthday;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 关注作家数
     */
    private Integer follow;
    /**
     * 粉丝数
     */
    private Integer follower;
    /**
     * 收藏漫画册数
     */
    private Integer favorite;
    /**
     * 漫画册数量
     */
    private Integer book;
    /**
     * 头像
     */
    private BmobFile avatar;
    /**
     * 个人肖像
     */
    private BmobFile portrait;
    /**
     * 用户状态（0禁用/1普通用户/2可发布漫画用户）
     */
    private Integer status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getFollow() {
        return follow;
    }

    public void setFollow(Integer follow) {
        this.follow = follow;
    }

    public Integer getFollower() {
        return follower;
    }

    public void setFollower(Integer follower) {
        this.follower = follower;
    }

    public Integer getFavorite() {
        return favorite;
    }

    public void setFavorite(Integer favorite) {
        this.favorite = favorite;
    }

    public Integer getBook() {
        return book;
    }

    public void setBook(Integer book) {
        this.book = book;
    }

    public BmobFile getAvatar() {
        return avatar;
    }

    public void setAvatar(BmobFile avatar) {
        this.avatar = avatar;
    }

    public BmobFile getPortrait() {
        return portrait;
    }

    public void setPortrait(BmobFile portrait) {
        this.portrait = portrait;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
