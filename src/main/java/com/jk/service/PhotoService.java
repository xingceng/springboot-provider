package com.jk.service;

import com.jk.model.Photo;

import java.util.List;

public interface PhotoService {


    void savePhoto(Photo photo);

    List<Photo> queryImg(Integer id);

}
