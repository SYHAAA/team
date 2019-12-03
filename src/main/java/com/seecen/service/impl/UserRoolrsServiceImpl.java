package com.seecen.service.impl;

import com.seecen.bo.UserRefloorsBo;
import com.seecen.dao.UserFloorsDao;
import com.seecen.service.UserRoolrsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoolrsServiceImpl implements UserRoolrsService {
    @Autowired
    private UserFloorsDao userFloorsDao;
    @Override
    public List<UserRefloorsBo> list() {
        return userFloorsDao.list();
    }
}
