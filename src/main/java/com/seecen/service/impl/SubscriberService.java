package com.seecen.service.impl;

import com.seecen.dao.SubscriberDao;
import com.seecen.pojo.Subscriber;
import com.seecen.service.IsubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriberService implements IsubscriberService {
    @Autowired
    private SubscriberDao subscriberDao;
    public Subscriber getById(Integer id) {
        return subscriberDao.getById(id) ;
    }

    @Override
    public void updatesign(Subscriber subscriber) {
        subscriberDao.updatesign(subscriber);
    }

    @Override
    public void updatestatus(Subscriber subscriber) {
        subscriberDao.updatestatus(subscriber);
    }

    @Override
    public List<Subscriber> friendList(Integer id, Integer typeid) {
       return subscriberDao.friendList(id,typeid);
    }

    @Override
    public List<Subscriber> groupUser(Integer id) {
        return  subscriberDao.groupUser(id);
    }

    @Override
    public Subscriber getowner(Integer id) {
        return subscriberDao.getowner(id);
    }

    @Override
    public List<Subscriber> getStranger(Integer id) {
        return subscriberDao.getStranger(id);
    }
}
