package com.seecen.vo;

import java.util.List;

public class SNSfrined {
    private Integer id;
    private String groupname;
    private List<SNSmine> list;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public List<SNSmine> getList() {
        return list;
    }

    public void setList(List<SNSmine> list) {
        this.list = list;
    }
}
