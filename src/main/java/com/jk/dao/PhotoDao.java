package com.jk.dao;

import com.jk.model.Photo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PhotoDao{


    @Insert("insert into t_photo(imgUrl) values(#{imgUrl})")
    void savePhoto(Photo photo);

    @Select("select * from t_photo")
    List<Photo> queryImg(Integer id);
}
