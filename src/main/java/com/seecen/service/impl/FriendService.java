package com.seecen.service.impl;

import com.seecen.dao.FriendDao;
import com.seecen.service.IFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FriendService implements IFriendService {
    @Autowired
    private FriendDao friendDao;
    @Override
    public Set<Integer> findtype(Integer id) {
        return friendDao.findtype(id);
    }
}
