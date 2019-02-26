package com.jk.model;

import java.io.Serializable;

public class Photo implements Serializable {

    private static final long serialVersionUID = 3305275608523490002L;
    private Integer id;
    private String imgUrl;
    private Integer boId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getBoId() {
        return boId;
    }

    public void setBoId(Integer boId) {
        this.boId = boId;
    }
}
