package com.seecen.service;

import com.seecen.pojo.Subscriber;


import java.util.List;

public interface IsubscriberService {


    Subscriber getById(Integer id);

    void updatesign(Subscriber subscriber);

    void updatestatus(Subscriber subscriber);

    List<Subscriber> friendList(Integer id, Integer typeid);

    List<Subscriber> groupUser(Integer id);

    Subscriber getowner(Integer id);

    List<Subscriber> getStranger(Integer id);
}
