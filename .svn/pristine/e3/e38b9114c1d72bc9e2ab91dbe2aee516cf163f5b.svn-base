package com.seecen.domain;

import com.seecen.util.StringUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 沈煜辉
 * @date 2019/10/27 10:59
 * @describe 试卷实体
 */
public class Exam {
    private Integer examId;
    private String examName;
    private Date startTime;
    private Date endTime;
    private Integer examGrade;
    private Integer examTotalTime;
    private Integer valid;
    private Clas clas = new Clas();
    private List<SubjectBank> subjects;

    public Clas getClas() {
        return clas;
    }

    public void setClas(Clas clas) {
        this.clas = clas;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return StringUtil.isNotEmpty(examName)?examName:null;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public String getStartTimeStr() {
        String startTimeStr=null;
        if(startTime!=null){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            startTimeStr = dateFormat.format(startTime);
        }
        return startTimeStr;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public String getEndTimeStr() {
        String endTimeStr=null;
        if(endTime!=null){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            endTimeStr = dateFormat.format(endTime);
        }
        return endTimeStr;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getExamGrade() {
        return examGrade;
    }

    public void setExamGrade(Integer examGrade) {
        this.examGrade = examGrade;
    }

    public Integer getExamTotalTime() {
        return examTotalTime;
    }

    public void setExamTotalTime(Integer examTotalTime) {
        this.examTotalTime = examTotalTime;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public List<SubjectBank> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectBank> subjects) {
        this.subjects = subjects;
    }

    private String select;
    private Integer radioNum;
    private Integer radioSource;
    private Integer checkNum;
    private Integer checkSource;
    private Integer judgeNum;
    private Integer judgeSource;
    private Integer briefiyNum;
    private Integer briefiySource;

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public Integer getRadioNum() {
        return radioNum;
    }

    public void setRadioNum(Integer radioNum) {
        this.radioNum = radioNum;
    }

    public Integer getRadioSource() {
        return radioSource;
    }

    public void setRadioSource(Integer radioSource) {
        this.radioSource = radioSource;
    }

    public Integer getCheckNum() {
        return checkNum;
    }

    public void setCheckNum(Integer checkNum) {
        this.checkNum = checkNum;
    }

    public Integer getCheckSource() {
        return checkSource;
    }

    public void setCheckSource(Integer checkSource) {
        this.checkSource = checkSource;
    }

    public Integer getJudgeNum() {
        return judgeNum;
    }

    public void setJudgeNum(Integer judgeNum) {
        this.judgeNum = judgeNum;
    }

    public Integer getJudgeSource() {
        return judgeSource;
    }

    public void setJudgeSource(Integer judgeSource) {
        this.judgeSource = judgeSource;
    }

    public Integer getBriefiyNum() {
        return briefiyNum;
    }

    public void setBriefiyNum(Integer briefiyNum) {
        this.briefiyNum = briefiyNum;
    }

    public Integer getBriefiySource() {
        return briefiySource;
    }

    public void setBriefiySource(Integer briefiySource) {
        this.briefiySource = briefiySource;
    }

}
