package com.seecen.service.impl;

import com.seecen.dao.FritypeDao;
import com.seecen.service.IFritypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FritypeService implements IFritypeService {
@Autowired
 private FritypeDao fritypeDao;
    @Override
    public String findname(Integer id) {
        return fritypeDao.findname(id) ;
    }
}
