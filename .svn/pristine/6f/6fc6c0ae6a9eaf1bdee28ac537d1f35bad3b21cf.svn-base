package com.seecen.dao;

import com.seecen.domain.Clas;
import com.seecen.domain.User;
import com.seecen.domain.UserBo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserDao {


    //查找用户登录
    User findByName(String userName);

    //注册用户
    void save(User user);

    Set<String> getUserRole(String userName);

    Set<String> getUserPermission(String primaryPrincipal);

    User getByName(String toString);

    List<User> findUser(Integer userId);

    //删除用户
    void delUser(int userId);

    void updateUserdata(User user);

    List<User> findUserJ(UserBo userBo);

    //    用户列表分页
    List<User> list(User user);

    //查找用户类型
    List<String> findIsAdmin();

    //查找班级id
    List<Clas> findClassId();

    //    //根据id查找用户信息
    User findUserById(Integer userId);

    /**
     * @Author: hao
     * @Date: 2019/10/29 - 14:18
     * @Description:  修改用户信息
     */
    void updateUser(User user);

    /**
     * @Author: hao
     * @Date: 2019/10/29 - 15:37
     * @Description:  添加用户
     */
    void addUser(User user);

    //批量删除
    void deleteAll(Integer[] ids);

    //注册查找功能
    int findAll(String userName);


//    //根据id查找用户信息
//    User findUserById();

}
