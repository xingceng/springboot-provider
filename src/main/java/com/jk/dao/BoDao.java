package com.jk.dao;

import com.jk.model.Blog;
import com.jk.model.BlogType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BoDao {

    @Select("select  count(*) from t_blog b1,t_blogtype b2 where b1.type_id=b2.id")
    long queryBlogCount();
    @Select("select  * from t_blog b1,t_blogtype b2 where b1.type_id=b2.id limit #{0},#{1}")
    List<Blog> queryBlogPage(int start, Integer rows);

    @Delete("delete from t_blog where id=#{ids}")
    void deleteAll(Integer ids);


    @Insert("insert into t_blog(title,summary,releaseDate,clickHit,replyHit,content,keyWord,user_id,type_id) values(#{title},#{summary},#{releaseDate},#{clickHit},#{replyHit},#{content},#{keyWord},#{user_id},#{type_id})")
    void addBlog(Blog b);

    @Select("select * from t_blogtype")
    List<BlogType> queryTypeName();

    @Select("select * from t_blog where id=#{id}")
    Blog queryBlogById(Integer id);

    @Update("update t_blog set title=#{title},summary=#{summary},releaseDate=#{releaseDate},clickHit=#{clickHit},replyHit=#{replyHit},content=#{content},keyWord=#{keyWord},user_id=#{user_id},type_id=#{type_id} where id=#{id} ")
    void updateBlog(Blog b);
}
