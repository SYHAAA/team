package com.seecen.dao;

import com.seecen.domain.SubjectBank;
import com.seecen.domain.SubjectType;
import com.seecen.domain.UserExam;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 沈煜辉
 * @date 2019/10/24 14:25
 * @dscribe 例题查询知识点
 */
@Repository
public interface SubjectBankDao {

    /**
     * 分页查询所有题库中的所有题目
     * @param subjectBank 条件
     * @return subjectBank集合
     */
    List<SubjectBank> findAllWithPage(SubjectBank subjectBank);

    /**
     * 查询全部题目类型
     * @return 题目类型集合
     */
    List<SubjectType> findAllSubjectType();

    /**
     * dao层查询所有的知识点
     * @return
     */
    List<String> findAllSubjectPoints();

    /**
     * dao层逻辑删除题目
     * @param id
     */
    void deleteSubject(int id);

    /**
     * dao层 保存题目信息
     * @param subjectBank
     */
    void saveSubject(SubjectBank subjectBank);

    /**
     * 业务层通过id查询题目
     * @param subjectId
     * @return
     */
    SubjectBank findSubjectById(Integer subjectId);

    /**
     * 更新判断题信息
     * @param subjectBank
     */
    void updateJudgeSubject(SubjectBank subjectBank);

    /**
     * 更新简述题
     * @param subjectBank
     */
    void updateBrieflySubject(SubjectBank subjectBank);

    /**
     * 更新选择题
     * @param subjectBank
     */
    void updateCheckSubject(SubjectBank subjectBank);

    /**
     * 查询题目
     * @param type
     * @param points
     * @param num
     * @return
     */
    List<Integer> findSubjectWithNum(@Param(value = "type") int type,@Param(value = "subjectPoints") String[] points,@Param(value = "num") int num);

    /**
     * 通过题目id值查询题目答案
     * @param questionId
     * @return
     */
    String findQuestionAnswer(Integer questionId);

    /**
     * 批处理查询试题
     * @param userExams
     * @return
     */
    List<SubjectBank> findSubjectByIds(@Param(value = "examIds") Integer[] userExams);
}
