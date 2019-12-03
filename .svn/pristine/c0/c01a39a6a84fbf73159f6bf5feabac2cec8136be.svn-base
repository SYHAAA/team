package com.seecen.service;

import com.seecen.domain.Exam;
import com.seecen.domain.User;

import java.util.List;

/**
 * @author 沈煜辉
 * @date 2019/10/27 11:07
 * @describe 考试模块的service接口
 */
public interface ExamService {
    /**
     * service 分页查询查询所有的试卷
     * @param exam 带有参数的查询
     * @param pageNum 起始页数
     * @param pageSize 起始大小
     * @return
     */
    List<Exam> findAllWithPage(Exam exam, int pageNum, int pageSize);

    /**
     * 保存试卷信息
     * @param exam
     */
    void saveExam(Exam exam);

    /**
     * 查找试卷信息
     * @param examId 试卷id值
     * @return
     */
    Exam findExamAndSubject(Integer examId);

    /**
     * 通过id删除试卷
     * @param examId
     */
    void deleteExam(Integer examId);

    /**
     * 通过用户的id值返回数据
     * @param user
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Exam> findExamWithClass(User user, int pageNum, int pageSize);

    /**
     * service层通过试卷信息，试题
     * @param examId
     * @return
     */
    Exam queryExam(int examId);

    /**
     * 通过
     * @param examId
     * @return
     */
    Exam findExamById(Integer examId);
}
