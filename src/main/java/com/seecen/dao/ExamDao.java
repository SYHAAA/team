package com.seecen.dao;

import com.seecen.domain.Exam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 沈煜辉
 * @date 2019/10/27 11:09
 * @describe 考试模块的dao接口
 */
@Repository
public interface ExamDao {
    /**
     * dao 查询所有试卷
     * @param exam 带有参数的试卷实体
     * @return
     */
    List<Exam> findAllWithPage(Exam exam);

    /**
     * 保存试卷信息，返回试卷的id
     * @param exam
     * @return 试卷id值
     */
    int saveExam(Exam exam);


    /**
     * 保存试卷题目信息
     * @param examId
     * @param radioId
     * @param radioSource
     */
    void saveExamAndSubject(@Param(value = "examId") int examId, @Param("radioId") Integer radioId,@Param(value = "radioSource") Integer radioSource);

    /**
     * 查找试卷信息
     * @param examId 试卷id
     * @return
     */
    Exam findExam(Integer examId);

    /**
     * 删除试卷
     * @param examId
     */
    void deleteExam(Integer examId);

    /**
     * 查询试卷带有班级
     * @param classId
     * @return
     */
    List<Exam> findExamWithClass(int classId);

    /**
     * dao层查询试卷id
     * @param examId
     * @return
     */
    Exam findExamById(Integer examId);
}
