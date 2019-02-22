package com.jk.service;

import com.jk.model.BlogType;
import com.jk.model.Blogger;
import com.jk.model.Tree;

import java.util.HashMap;
import java.util.List;

public interface TestService {
    String say(String something);

    String login(Blogger blogger);

    List<Tree> findTree(Integer pid);

    List<BlogType> queryBolgclickHit();

    HashMap<String, Object> queryusers(Integer page, Integer rows);

    Blogger upuser(Integer id);


    void updateuser(Blogger blogger);


}
