package com.jk.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.LinkDao;
import com.jk.model.BlogType;
import com.jk.model.Link;
import com.jk.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkDao linkDao;

    @Override
    public HashMap<String, Object> queryLink(Integer page, Integer rows) {
        HashMap<String,Object> hashMap = new HashMap<>();
        long total = linkDao.queryTypeTotal();
        int start = (page-1) * rows;
        List<Link> list = linkDao.queryTypePage(start,rows);
        hashMap.put("total",total);
        hashMap.put("rows",list);
        return hashMap;
    }

    @Override
    public void saveLink(Link link) {
        linkDao.saveLink(link);
    }

    @Override
    public void delLink(String ids) {
        linkDao.delType(ids);
    }

    @Override
    public void editType(Link link) {
        linkDao.editType(link);
    }
}
