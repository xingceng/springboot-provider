package com.jk.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.BoDao;
import com.jk.model.Blog;
import com.jk.model.BlogType;
import com.jk.service.BoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

@Service
public class BoServiceImpl implements BoService {
    @Autowired
    private BoDao dao;

    @Override
    public HashMap<String, Object> queryBlog(Integer page, Integer rows) {
        HashMap<String, Object> hashMap = new HashMap<>();
        long total =dao.queryBlogCount();
        int start=(page-1)*rows;
        List<Blog> list=dao.queryBlogPage(start,rows);
        hashMap.put("total",total);
        hashMap.put("rows",list);
        return hashMap;
    }

    @Override
    public void deleteAll(Integer ids) {
        dao.deleteAll(ids);
    }


    @Override
    public void addBlog(Blog b) {
        Integer id=b.getId();
        if(id!=null){
            dao.updateBlog(b);
        }else{
            dao.addBlog(b);
        }

    }

    @Override
    public List<BlogType> queryTypeName() {
        return dao.queryTypeName();
    }

    @Override
    public Blog queryBlogById(Integer id) {
        return dao.queryBlogById(id);
    }

}
