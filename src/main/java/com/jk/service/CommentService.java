package com.jk.service;

import com.jk.model.Comment;

import java.util.HashMap;

public interface CommentService {

    //查询评论审核
    HashMap<String, Object> querycomment(Integer page, Integer rows);

    //审核通过
    void tongguo(Integer id);

    //审核不通过
    void bohui(Integer id);

    //查询评论信息管理
    HashMap<String, Object> querycomment2(Integer page, Integer rows);

    //新增评论
    void addComment(Comment comment);

    //删除评论
    void delComment(Integer id);
}
