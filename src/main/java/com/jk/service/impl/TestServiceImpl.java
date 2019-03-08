package com.jk.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.TestDao;
import com.jk.model.Blog;
import com.jk.model.BlogType;
import com.jk.model.Blogger;
import com.jk.model.Tree;
import com.jk.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.HashMap;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public String say(String something) {
        return "小明说的" + something;
    }

    @Override
    public String login(Blogger blogger) {
        List<Blogger> list = testDao.getTestNameIsNull(blogger);
        if (list.size() == 1) {
            if (blogger.getPassword().equals(list.get(0).getPassword())) {
                return "loginSuccess";
            } else {
                return "userPassNo";
            }
        } else {
            return "userNameNO";
        }
    }

    @Override
    public List<Tree> findTree(Integer pid) {
        return testDao.findTree(pid);
    }

    @Override
    public List<BlogType> queryBolgType() {
        return testDao.queryBolgType();
    }


    @Override
    public HashMap<String, Object> queryusers(Integer page, Integer rows) {
        HashMap<String, Object> hashMap = new HashMap<>();
        long total = testDao.queryusersTotal();
        int start = (page - 1) * rows;
        List<Blogger> list = testDao.queryusersPage(start, rows);
        hashMap.put("total", total);
        hashMap.put("rows", list);
        return hashMap;
    }

    @Override
    public Blogger upuser(Integer id) {
        return testDao.upuser(id);
    }

    @Override
    public void updateuser(Blogger blogger) {
        testDao.updateuser(blogger);
    }

    @Override
    public List<Blog> queryBolgclickHit() {
        return testDao.queryBolgclickHit();
    }


}
