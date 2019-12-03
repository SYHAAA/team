package com.seecen.dao;

import com.seecen.domain.TabRly;

import java.util.List;

public interface TabRlyDao {
    int insert(TabRly record);

    int insertSelective(TabRly record);


    TabRly findrly(Integer postId);

    List<TabRly> select();

    void add(TabRly tabRly);
}