package com.jk.service;

import com.jk.model.Blog;
import com.jk.model.BlogType;

import java.util.HashMap;
import java.util.List;

public interface BoService {

    HashMap<String, Object> queryBlog(Integer page, Integer rows);

    void deleteAll(Integer ids);

    void addBlog(Blog b);

    List<BlogType> queryTypeName();

    Blog queryBlogById(Integer id);
}
