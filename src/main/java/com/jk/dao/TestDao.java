package com.jk.dao;

import com.jk.model.Blog;
import com.jk.model.BlogType;
import com.jk.model.Blogger;
import com.jk.model.Tree;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TestDao {
    @Select("SELECT * FROM  t_blogger s WHERE s.`username`=#{username}")
    List<Blogger> getTestNameIsNull(Blogger blogger);

    @Select("SELECT * FROM t_tree  r ")
    List<Tree> findTree(Integer pid);

    @Select("select t.id,t.typeName,t.orderNum from t_blogtype t")
    List<BlogType> queryBolgType();

    @Select("select count(*) from t_blogger")
    long queryusersTotal();

    @Select("select * from t_blogger  limit #{0},#{1}")
    List<Blogger> queryusersPage(int start, Integer rows);

    @Select("select * from t_blogger  b where b.id=#{id}")
    Blogger upuser(Integer id);

    @Update("UPDATE t_blogger SET username = #{username},password = #{password},profile = #{profile},nickname = #{nickname}, sign = #{sign} WHERE id = #{id};")
    void updateuser(Blogger blogger);

    @Select("select * from t_blog")
    List<Blog> queryBolgclickHit();
}
