package com.seecen.domain;

import com.seecen.util.StringUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 沈煜辉
 * @date 2019/10/24 19:01
 * @describe 综合类，一般类都会又的属性
 */
public class Father {
    private Date startTime;
    private Date endTime;
    private String optionsA;
    private String optionsB;
    private String optionsC;
    private String optionsD;

    public String getOptionsA() {
        return StringUtil.isNotEmpty(optionsA)?optionsA:null;
    }

    public void setOptionsA(String optionsA) {
        this.optionsA = optionsA;
    }

    public String getOptionsB() {
        return StringUtil.isNotEmpty(optionsB)?optionsB:null;
    }

    public void setOptionsB(String optionsB) {
        this.optionsB = optionsB;
    }

    public String getOptionsC() {
        return StringUtil.isNotEmpty(optionsC)?optionsC:null;
    }

    public void setOptionsC(String optionsC) {
        this.optionsC = optionsC;
    }

    public String getOptionsD() {
        return StringUtil.isNotEmpty(optionsD)?optionsD:null;
    }

    public void setOptionsD(String optionsD) {
        this.optionsD = optionsD;
    }

    public Date getStartTime() {
        return startTime;
    }

    public String getStartTimeStr(){
        String startTimeStr = null;
        if(startTime!=null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            startTimeStr = simpleDateFormat.format(startTime);
        }
        return startTimeStr;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public String getEndTimeStr(){
        String endTimeStr = null;
        if(endTime!=null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            endTimeStr = simpleDateFormat.format(endTime);
        }
        return endTimeStr;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
