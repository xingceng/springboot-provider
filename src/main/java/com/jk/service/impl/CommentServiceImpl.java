package com.jk.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.CommentDao;
import com.jk.model.Comment;
import com.jk.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao dao;

    //查询评论审核
    @Override
    public HashMap<String, Object> querycomment(Integer page, Integer rows) {
        HashMap<String, Object> hashMap = new HashMap<>();
        long total = dao.queryCommentCount();
        int start = (page - 1) * rows;
        List<Comment> list = dao.queryCommentPage(start, rows);
        hashMap.put("total", total);
        hashMap.put("rows", list);
        return hashMap;
    }

    //审核通过
    @Override
    public void tongguo(Integer id) {
        dao.tongguo(id);
        dao.addreplyHit(id);

    }

    //审核不通过
    @Override
    public void bohui(Integer id) {
        dao.bohui(id);
    }

    @Override
    public HashMap<String, Object> querycomment2(Integer page, Integer rows) {
        HashMap<String, Object> hashMap = new HashMap<>();
        long total = dao.queryCommentCount2();
        int start = (page - 1) * rows;
        List<Comment> list = dao.queryCommentPage2(start, rows);
        hashMap.put("total", total);
        hashMap.put("rows", list);
        return hashMap;
    }

    //新增评论
    @Override
    public void addComment(Comment comment) {
        dao.addComment(comment);
    }

    //删除评论
    @Override
    public void delComment(Integer id) {
        dao.delComment(id);
    }

}
