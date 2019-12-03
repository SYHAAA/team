package com.seecen.service.impl;

import com.seecen.dao.GroupDao;
import com.seecen.pojo.Group;
import com.seecen.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService implements IGroupService {
   @Autowired
   private GroupDao groupDao;
    public List<Group> findGruop(Integer id) {
        return  groupDao.findgroup(id);
    }

    @Override
    public int groupnum(Integer id) {
        return groupDao.groupnum(id);
    }
}
