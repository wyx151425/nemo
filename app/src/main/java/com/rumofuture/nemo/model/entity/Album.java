package com.rumofuture.nemo.model.entity;

import cn.bmob.v3.BmobObject;

/**
 * Created by WangZhenqi on 2017/8/31.
 */

public class Album extends BmobObject {

    private Integer imageId;  // 专辑封面图片id

    private String style;  // 专辑的风格
    private String note;  // 专辑的注释

    private Integer number;
    private Integer bookTotal;  // 专辑漫画册总数

    private Integer status;

    public Album() {

    }

    public Album(Integer imageId, String style, String note) {
        this.imageId = imageId;
        this.style = style;
        this.note = note;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getBookTotal() {
        return bookTotal;
    }

    public void setBookTotal(Integer bookTotal) {
        this.bookTotal = bookTotal;
    }
}
