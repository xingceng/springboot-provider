package com.jk.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.PhotoDao;
import com.jk.model.Photo;
import com.jk.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService {


    @Autowired
    private PhotoDao photoDao;


    @Override
    public void savePhoto(Photo photo) {
        photoDao.savePhoto(photo);
    }

    @Override
    public List<Photo> queryImg(Integer id) {
        return photoDao.queryImg(id);
    }
}
