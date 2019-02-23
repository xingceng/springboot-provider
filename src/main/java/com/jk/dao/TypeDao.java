package com.jk.dao;

import com.jk.model.BlogType;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TypeDao {

    @Select("select count(*) from t_blogtype")
    long queryTypeTotal();

    @Select("select bt.id,bt.typeName,bt.orderNum,count(*) blogCount from t_blog b,t_blogtype bt where b.type_id=bt.id group by bt.typeName limit #{start},#{rows}")
    List<BlogType> queryTypePage(@Param("start") int start, @Param("rows") int rows);

    @Insert("insert into t_blogtype(id,typeName,orderNum) values(#{id},#{typeName},#{orderNum})")
    void saveType(BlogType type);

    @Delete("delete from t_blogtype where id in (#{ids})")
    void delType(String ids);

    @Update("update t_blogtype set typeName = #{typeName},orderNum = #{orderNum} where id = #{id}")
    void editType(BlogType type);
}
