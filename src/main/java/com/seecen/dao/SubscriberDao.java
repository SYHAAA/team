package com.seecen.dao;

import com.seecen.pojo.Subscriber;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubscriberDao {

    Subscriber getById(Integer id);

    void  updatesign(Subscriber subscriber);

    void updatestatus(Subscriber subscriber);

    List<Subscriber> friendList(@Param("userId") Integer id, @Param("typeIds") int type_id);

    List<Subscriber> groupUser(Integer id);

    Subscriber getowner(Integer id);

    List<Subscriber> getStranger(Integer id);
}