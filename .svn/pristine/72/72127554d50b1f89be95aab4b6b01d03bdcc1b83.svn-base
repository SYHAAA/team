package com.seecen.dao;

import com.seecen.domain.Exam;
import com.seecen.domain.ExamRecord;
import com.seecen.domain.UserExam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 沈煜辉
 * @date 2019/10/31 13:39
 * @describe 试卷记录的dao层
 */
@Repository
public interface ExamRecordDao {

    /**
     * dao 保存考试记录
     * @param record
     * @return
     */
    int saveExamRecord(ExamRecord record);

    /**
     * 保存考生答题信息
     * @param examRecordId 试卷记录id
     * @param userExams 实体信息集合
     */
    void saveExamSubject(@Param(value = "id") int examRecordId,@Param(value = "list") List<UserExam> userExams);

    /**
     * dao层
     * @return
     */
    List<ExamRecord> findExamRecord(Integer userId);

    /**
     * dao层查询用户数据
     * @param history
     * @return
     */
    List<UserExam> finaExamInfo(Integer history);

    /**
     * dao层寻找试卷id
     * @param history
     * @return
     */
    ExamRecord findExamIdByHistory(Integer history);
}
