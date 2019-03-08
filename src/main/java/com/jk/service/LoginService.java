package com.jk.service;

import com.jk.model.Blog;
import com.jk.model.Blogger;
import com.jk.model.Comment;
import com.jk.model.Photo;

import java.util.List;

public interface LoginService {
    String login(Blogger blogger);

    List<Blog> findblog(Integer id);

    List<Blog> findblogs();

    Blog quertbolgg(Integer id);

    List<Comment> findcomment(Integer id);

    void addcomment(Comment comment);


    void updateClick(Integer id);

    List<Photo> queryImg(Integer id);

    void savePhoto(Photo photo);


}
