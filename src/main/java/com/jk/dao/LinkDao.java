package com.jk.dao;

import com.jk.model.BlogType;
import com.jk.model.Link;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface LinkDao {
    @Select("select count(*) from t_link")
    long queryTypeTotal();

    @Select("select * from t_link limit #{start},#{rows}")
    List<Link> queryTypePage(@Param("start") int start, @Param("rows") int rows);

    @Insert("insert into t_link(id,linkname,linkurl,ordernum) values(#{id},#{linkname},#{linkurl},#{ordernum})")
    void saveLink(Link link);

    @Delete("delete from t_link where id in (#{ids})")
    void delType(String ids);

    @Update("update t_link set linkname = #{linkname},linkurl = #{linkurl},ordernum = #{ordernum} where id = #{id}")
    void editType(Link link);
}
