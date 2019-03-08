package com.jk.dao;

import com.jk.model.Blog;
import com.jk.model.Blogger;
import com.jk.model.Comment;
import com.jk.model.Photo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface LoginDao {
    @Select("SELECT * FROM  t_blogger s WHERE s.`username`=#{username}")
    List<Blogger> getTestNameIsNull(Blogger blogger);

    @Select("SELECT * FROM  t_blog s WHERE s.`user_id`=#{id}")
    List<Blog> findblog(Integer id);

    @Select("SELECT * FROM  t_blog  ")
    List<Blog> findblogs();

    @Select("SELECT * FROM  t_blog  s where s.id=#{id}")
    Blog quertbolgg(Integer id);

    @Select("SELECT  c.*,l.imagename,l.`nickname` FROM t_comment c ,t_blog b ,t_blogger l WHERE l.id=b.user_id AND c.blog_id=#{id} AND c.state=1 GROUP BY c.id")
    List<Comment> findcomment(Integer id);

    @Insert("INSERT INTO t_comment (commentdate,`content`,`blog_id`)VALUES (SYSDATE(),#{content},#{blog_id})")
    void addcomment(Comment comment);

    @Update("update t_blog set clickHit=clickHit+1 where id= #{id}")
    void updateClick(Integer id);

    @Insert("insert into t_photo(imgUrl,boId) values(#{imgUrl},#{boId})")
    void savePhoto(Photo photo);

    @Select("select * from t_photo where boId=#{id}")
    List<Photo> queryImg(Integer id);

}
