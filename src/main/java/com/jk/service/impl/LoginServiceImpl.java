package com.jk.service.impl;

import com.jk.dao.LoginDao;
import com.jk.dao.TestDao;
import com.jk.model.Blog;
import com.jk.model.Blogger;
import com.jk.model.Comment;
import com.jk.model.Photo;
import com.jk.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.InetAddress;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;

    @Override
    public String login(Blogger blogger) {
        List<Blogger> list = loginDao.getTestNameIsNull(blogger);
        if (list.size() == 1) {
            if (blogger.getPassword().equals(list.get(0).getPassword())) {
                return "loginSuccess" + list.get(0).getId();
            } else {
                return "userPassNo" + list.get(0).getId();
            }
        } else {
            return "userNameNO" + list.get(0).getId();
        }
    }

    @Override
    public List<Blog> findblog(Integer id) {
        return loginDao.findblog(id);
    }

    @Override
    public List<Blog> findblogs() {
        return loginDao.findblogs();
    }

    @Override
    public Blog quertbolgg(Integer id) {
        return loginDao.quertbolgg(id);
    }

    @Override
    public List<Comment> findcomment(Integer id) {
        return loginDao.findcomment(id);
    }

    @Override
    public void addcomment(Comment comment) {
        comment.setUserip("");
        loginDao.addcomment(comment);
    }

    @Override
    public void savePhoto(Photo photo) {
        loginDao.savePhoto(photo);
    }

    @Override
    public List<Photo> queryImg(Integer id) {
        return loginDao.queryImg(id);
    }

    @Override
    public void updateClick(Integer id) {
        loginDao.updateClick(id);
    }
}
