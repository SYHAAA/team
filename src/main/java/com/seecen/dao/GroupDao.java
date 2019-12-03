package com.seecen.dao;

import com.seecen.pojo.Group;

import java.util.List;

public interface GroupDao {

    List<Group> findgroup(Integer id);

    int groupnum(Integer id);
}