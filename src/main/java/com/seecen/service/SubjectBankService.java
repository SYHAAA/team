package com.seecen.service;

import com.seecen.domain.SubjectBank;
import com.seecen.domain.SubjectType;

import java.util.List;

/**
 * @author 沈煜辉
 * @date 2019/10/24 14:40
 * @describe
 */
public interface SubjectBankService {
    /**
     * service层查询题库中的所有题
     * @param subjectBank 查询参数
     * @param pageNum 起始页
     * @param pageSize 页面大小
     * @return list集合题库
     */
    List<SubjectBank> findAllWithPage(SubjectBank subjectBank,int pageNum,int pageSize);

    /**
     * 查询所有的题目类型
     * @return
     */
    List<SubjectType> findAllSubjectType();

    /**
     * 查询所有的题目知识点
     * @return
     */
    List<String> findAllSubjectPoints();

    /**
     * 通过id值逻辑删除题库中的题
     * @param id
     */
    void deleteSubject(int id);

    /**
     * service层 保存题目
     * @param subjectBank 数据对象
     */
    void saveSubject(SubjectBank subjectBank);

    /**
     * 通过题目id查询题目
     * @param subjectId 题目Id
     * @return
     */
    SubjectBank findSubjectById(Integer subjectId);

    /**
     * 更新题目信息
     * @param subjectBank
     */
    void updateSubject(SubjectBank subjectBank);


    /**
     * 通过试卷id值查找答案
     * @param questionId 题目id
     * @return
     */
    String findQuestionAnswer(Integer questionId);
}
