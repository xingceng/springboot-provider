package com.jk.service;

import com.jk.model.BlogType;

import java.util.HashMap;

public interface TypeService {

    HashMap<String,Object> queryType(int page, int rows);

    void saveType(BlogType type);

    void delType(String ids);
}
