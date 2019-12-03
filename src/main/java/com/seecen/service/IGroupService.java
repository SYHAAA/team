package com.seecen.service;

import com.seecen.pojo.Group;

import java.util.List;

public interface IGroupService {

    List<Group> findGruop(Integer id);

    int groupnum(Integer id);
}
