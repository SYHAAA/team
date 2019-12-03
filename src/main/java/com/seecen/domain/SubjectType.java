package com.seecen.domain;

import com.seecen.util.StringUtil;

/**
 * @author 沈煜辉
 * @date 2019/10/24 19:21
 * @describe 题目类型
 */
public class SubjectType {
    private Integer typeId;
    private String typeName;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return StringUtil.isNotEmpty(typeName)?typeName:null;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
