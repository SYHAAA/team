package com.seecen.dao;

import com.seecen.bo.UserRefloorsBo;
import com.seecen.domain.UserRloors;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface UserFloorsDao {

    List<UserRefloorsBo> list();
}
