package com.seecen.service.impl;

import com.seecen.bo.UserRefloorsBo;
import com.seecen.dao.TieziMessageDao;
import com.seecen.domain.TabRly;
import com.seecen.domain.TieziMessage;
import com.seecen.service.TieziMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TieziMessageServiceImpl implements TieziMessageService {
    @Autowired
   private TieziMessageDao tieziMessageDao;

    @Override
    public List<TieziMessage> select() { return tieziMessageDao.select();}

    @Override
    public TieziMessage initById(Integer id) {
        TieziMessage tieziMessage = new TieziMessage();
        tieziMessage.setId(id);
        return tieziMessage;
    }

    @Transactional
    public void insert(TieziMessage tieziMessage) {
        tieziMessageDao.insert(tieziMessage);
    }



}
