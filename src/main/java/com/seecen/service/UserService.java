package com.seecen.service;

import com.seecen.domain.Clas;
import com.seecen.domain.User;
import com.seecen.domain.UserBo;

import java.util.List;

public interface UserService {
    int save(User user);

    User login(User user);

    List<User> findUser(Integer userId);

    //删除用户
    void delUser(int userId);

    void updateUserdata(User user);

    List<User> findUserJ(UserBo user);

    //    用户列表分页
    List<User> list(User user, int pageNum, int pageSize);

    //查找用户类型
    List<String> findIsAdmin();


    //查找班级id
    List<Clas> findClassId();

    //    //根据id查找用户信息
    User findUserById(Integer userId);

    /**
     * @Author: hao
     * @Date: 2019/10/29 - 14:16
     * @Description:  修改用户信息
     * @Version: 1.0
     */
    void updateUser(User user);

    /**
     * @Author: hao
     * @Date: 2019/10/29 - 15:36
     * @Description:  添加用户
     */
    void addUser(User user);


    //批量删除
    void deleteAll(Integer[] ids);

    //注册功能查找
    int findAll(String userName);


//    //根据id查找用户信息
//    User findUserById();

}
