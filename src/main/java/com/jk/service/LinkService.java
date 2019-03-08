package com.jk.service;

import com.jk.model.Link;

import java.util.HashMap;

public interface LinkService {
    HashMap<String, Object> queryLink(Integer page, Integer rows);

    void saveLink(Link link);

    void delLink(String ids);

    void editType(Link link);
}
