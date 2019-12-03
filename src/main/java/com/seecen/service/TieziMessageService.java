package com.seecen.service;

import com.seecen.bo.UserRefloorsBo;
import com.seecen.domain.TabRly;
import com.seecen.domain.TieziMessage;

import java.util.List;

public interface TieziMessageService {
    List<TieziMessage> select();

    TieziMessage initById(Integer id);

    void insert (TieziMessage tieziMessage);

}
