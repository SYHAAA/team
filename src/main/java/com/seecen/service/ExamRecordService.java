package com.seecen.service;

import com.seecen.domain.ExamRecord;
import com.seecen.domain.SubjectBank;
import com.seecen.domain.UserExam;

import java.util.List; /**
 * @author 沈煜辉
 * @date 2019/10/31 13:36
 * @describe 考试记录的业务层
 */
public interface ExamRecordService {

    /**
     * 保存考试记录
     * @param record
     * @return
     */
    void saveExamRecord(ExamRecord record);

    /**
     * 分页查询试卷信息
     * @param id
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<ExamRecord> findExamRecord(Integer id,int pageNum,int pageSize);

    /**
     * 通过考试id值查询用户试卷答案
     * @param history
     * @return
     */
    List<SubjectBank> finaExamInfo(Integer history);

    /**
     * 通过历史id值寻找试卷
     * @param history
     * @return
     */
    ExamRecord findExamIdByHistory(Integer history);
}
