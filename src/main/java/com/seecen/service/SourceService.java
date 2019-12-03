package com.seecen.service;

import com.seecen.domain.ExamRecord;

import java.util.List;

/**
 * @author 沈煜辉
 * @date 2019/11/1 19:34
 * @describe 成绩的业务层接口
 */
public interface SourceService {

    /**
     * 分页查询所有学生成绩
     * @param examRecord 试卷条件
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<ExamRecord> findAllSource(ExamRecord examRecord, int pageNum, int pageSize);

    /**
     * 添加主观题的分数
     * @param historyId
     * @param userId
     * @param sum
     * @param evl
     */
    void updateSource(String historyId,String userId, int sum,String evl);

    /**
     * 设置主观题的分数
     * @param historyId 历史试卷id
     * @param answerId 问题id
     * @param answerSource 问题分数
     */
    void updateSubjectSource(String historyId, String answerId, int answerSource);
}
