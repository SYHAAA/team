package com.seecen.domain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 沈煜辉
 * @date 2019/10/31 9:40
 * @describe 考试记录
 */
public class ExamRecord {
    private Integer examRecordId;
    private Integer userId;
    private String username;
    private Integer examId;
    private String examName;
    private Integer objectiveSource;
    private Integer subjectiveSource;
    private String evaluation;
    private Date createTime;
    private Integer review;
    private User user = new User();
    private List<UserExam> userExams = new ArrayList<>();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public Integer getExamRecordId() {
        return examRecordId;
    }

    public void setExamRecordId(Integer examRecordId) {
        this.examRecordId = examRecordId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public Integer getObjectiveSource() {
        return objectiveSource;
    }

    public void setObjectiveSource(Integer objectiveSource) {
        this.objectiveSource = objectiveSource;
    }

    public Integer getSubjectiveSource() {
        return subjectiveSource;
    }

    public void setSubjectiveSource(Integer subjectiveSource) {
        this.subjectiveSource = subjectiveSource;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getCreateTimeStr() {
        String time = null;
        if(createTime!=null){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            time = dateFormat.format(createTime);
        }
        return time;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getReview() {
        return review;
    }

    public void setReview(Integer review) {
        this.review = review;
    }

    public List<UserExam> getUserExams() {
        return userExams;
    }

    public void setUserExams(List<UserExam> userExams) {
        this.userExams = userExams;
    }
}
