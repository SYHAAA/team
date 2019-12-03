package com.seecen.domain;

import com.seecen.util.StringUtil;
import org.springframework.aop.target.LazyInitTargetSource;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 沈煜辉
 * @date 2019/10/24 14:14
 * @describe 题库的实体类
 */
public class SubjectBank extends Father {
    private Integer subjectId;
    private String subjectPoints;
    private String subjectContent;
    private String subjectOption;
    private String subjectAnswer;
    private String subjectAnalytical;
    private Date createTime;
    private Integer valid;
    private Integer subjectSource;
    private String userAnswer;

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public Integer getSubjectSource() {
        return subjectSource;
    }

    public void setSubjectSource(Integer subjectSource) {
        this.subjectSource = subjectSource;
    }

    private SubjectType subjectType = new SubjectType();

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectPoints() {
        return StringUtil.isNotEmpty(subjectPoints)?subjectPoints.trim():null;
    }

    public void setSubjectPoints(String subjectPoints) {
        this.subjectPoints = subjectPoints;
    }

    public SubjectType getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(SubjectType subjectType) {
        this.subjectType = subjectType;
    }

    public String getSubjectContent() {
        return StringUtil.isNotEmpty(subjectContent)?subjectContent.trim():null;
    }

    public void setSubjectContent(String subjectContent) {
        this.subjectContent = subjectContent;
    }

    public String getSubjectOption() {
        return StringUtil.isNotEmpty(subjectOption)?subjectOption.trim():null;
    }

    public void setSubjectOption(String subjectOption) {
        this.subjectOption = subjectOption;
    }

    public String getSubjectAnswer() {
        return StringUtil.isNotEmpty(subjectAnswer)?subjectAnswer.trim():null;
    }

    public void setSubjectAnswer(String subjectAnswer) {
        this.subjectAnswer = subjectAnswer;
    }

    public String getSubjectAnalytical() {
        return StringUtil.isNotEmpty(subjectAnalytical)?subjectAnalytical.trim():null;
    }

    public void setSubjectAnalytical(String subjectAnalytical) {
        this.subjectAnalytical = subjectAnalytical;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getCreateTimeStr(){
        String createTimeStr = null;
        if(createTime!=null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            createTimeStr = simpleDateFormat.format(createTime);
        }
        return createTimeStr;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }
}
