package com.jk.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.TypeDao;
import com.jk.model.BlogType;
import com.jk.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    @Override
    public HashMap<String, Object> queryType(int page, int rows) {
        HashMap<String,Object> hashMap = new HashMap<>();
        long total = typeDao.queryTypeTotal();
        int start = (page-1) * rows;
        List<BlogType> list = typeDao.queryTypePage(start,rows);
        hashMap.put("total",total);
        hashMap.put("rows",list);
        return hashMap;
    }

    @Override
    public void saveType(BlogType type) {
        typeDao.saveType(type);
    }

    @Override
    public void delType(String ids) {
        typeDao.delType(ids);
    }

    @Override
    public void editType(BlogType type) {
        typeDao.editType(type);
    }
}
