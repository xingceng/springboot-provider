package com.jk.model;

import java.io.Serializable;

public class BlogType implements Serializable {


    private static final long serialVersionUID = -8388290593035031733L;
    private Integer id;
    private String typeName;//博客名称
    private Integer orderNum;//优先级
    private Integer blogCount; //博客总数

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getBlogCount() {
        return blogCount;
    }

    public void setBlogCount(Integer blogCount) {
        this.blogCount = blogCount;
    }

    @Override
    public String toString() {
        return "BlogType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", orderNum=" + orderNum +
                ", blogCount=" + blogCount +
                '}';
    }
}
