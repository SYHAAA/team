package com.seecen.dao;

import com.seecen.pojo.Friend;

import java.util.Set;

public interface FriendDao {
  Set<Integer>  findtype(Integer id);
}