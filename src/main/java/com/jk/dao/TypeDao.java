package com.jk.dao;

import com.jk.model.BlogType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TypeDao {

    @Select("select count(*) from t_blogtype")
    long queryTypeTotal();

    @Select("select * from t_blogtype limit #{start},#{rows}")
    List<BlogType> queryTypePage(@Param("start") int start, @Param("rows") int rows);

    @Insert("insert into t_blogtype(id,typeName,orderNum) values(#{id},#{typeName},#{orderNum})")
    void saveType(BlogType type);


    @Delete("delete from t_blogtype where id in (#{ids})")
    void delType(String ids);
}
