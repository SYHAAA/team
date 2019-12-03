package com.seecen.dao;

import com.seecen.domain.ExamRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 沈煜辉
 * @date 2019/11/1 19:36
 * @describe
 */
@Repository
public interface SourceDao {

    /**
     * dao层查询所有用户记录
     * @param examRecord
     * @return
     */
     List<ExamRecord> findAllSource(ExamRecord examRecord);

    /**
     * 更新数据库的主观题分数
     * @param historyId
     * @param userId
     * @param sum
     * @param evl
     */
    void updateSource(@Param("id") String historyId,@Param("userId")String userId,@Param("sum") int sum,@Param("evl") String evl);

    /**
     * 更新题目分数
     * @param historyId
     * @param answerId
     * @param answerSource
     */
    void updateSubjectSource(@Param("id") String historyId,@Param("answerId") String answerId, @Param("source") int answerSource);
}
