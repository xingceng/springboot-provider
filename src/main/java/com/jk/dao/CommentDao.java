package com.jk.dao;


import com.jk.model.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CommentDao {

   //查询总条数
     @Select("select count(*) from t_comment c, t_blog b,t_blogger a where c.blog_id=b.id and a.id=c.userip and c.state =0")
     long queryCommentCount();

     //分页查询
     @Select("select c.id,c.userip,c.content,c.commentdate,c.blog_id from t_comment c, t_blog b,t_blogger a where c.blog_id=b.id and a.id=c.userip and c.state=0 limit #{start},#{rows}")
    List<Comment> queryCommentPage(@Param("start") int start, @Param("rows") Integer rows);

     //审核通过
    @Update("update t_comment set state=1 where id=#{id}")
    void tongguo(Integer id);

    //审核不通过
    @Update("update t_comment set state=2 where id=#{id}")
    void bohui(Integer id);


    //查询总条数
    @Select("select count(*) from t_comment c, t_blog b,t_blogger a where c.blog_id=b.id and a.id=c.userip and c.state in (1,2)")
    long queryCommentCount2();

    //分页查询
    @Select("select c.state, b.title,c.id,c.userip,c.content,c.commentdate,c.blog_id from t_comment c, t_blog b,t_blogger a where c.blog_id=b.id and a.id=c.userip and c.state in (1,2) limit #{start},#{rows}")
    List<Comment> queryCommentPage2(@Param("start") int start, @Param("rows") Integer rows);

    //新增评论
    @Insert("insert into t_comment(userip,content,commentdate,state,blog_id) values(#{userip},#{content},SYSDATE(),0,#{blog_id})")
    void addComment(Comment comment);

    //删除评论
    @Delete("delete from t_comment where id=#{id}")
    void delComment(Integer id);
}

