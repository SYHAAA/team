package com.seecen.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class TabRly {
    private Integer postId;

    private Integer floorNum;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date rlyTime;

    private String facePath;

    private String rlyContent;

    private String username;

    private String reuserName;

    private String valid;

    private BigDecimal userId;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(Integer floorNum) {
        this.floorNum = floorNum;
    }

    public Date getRlyTime() {
        return rlyTime;
    }

    public void setRlyTime(Date rlyTime) {
        this.rlyTime = rlyTime;
    }

    public String getRlyContent() {
        return rlyContent;
    }

    public void setRlyContent(String rlyContent) {
        this.rlyContent = rlyContent == null ? null : rlyContent.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getReuserName() {
        return reuserName;
    }

    public void setReuserName(String reuserName) {
        this.reuserName = reuserName == null ? null : reuserName.trim();
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid == null ? null : valid.trim();
    }

    public BigDecimal getUserId() {
        return userId;
    }

    public void setUserId(BigDecimal userId) {
        this.userId = userId;
    }


    public String getFacePath() { return facePath; }

    public void setFacePath(String facePath) { this.facePath = facePath; }
}