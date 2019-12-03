package com.seecen.service.impl;

import com.github.pagehelper.PageHelper;
import com.seecen.dao.SourceDao;
import com.seecen.domain.ExamRecord;
import com.seecen.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 沈煜辉
 * @date 2019/11/1 19:35
 * @describe
 */
@Service
public class SourceServiceImpl implements SourceService {

    @Autowired
    private SourceDao sourceDao;

    @Override
    public List<ExamRecord> findAllSource(ExamRecord examRecord, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ExamRecord> list = sourceDao.findAllSource(examRecord);
        return list;
    }

    @Override
    public void updateSource(String historyId,String userId, int sum,String evl) {
        sourceDao.updateSource(historyId,userId,sum,evl);
    }

    @Override
    public void updateSubjectSource(String historyId, String answerId, int answerSource) {
        sourceDao.updateSubjectSource(historyId,answerId,answerSource);
    }
}
