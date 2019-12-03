package com.seecen.service.impl;

import com.seecen.dao.UserDao;
import com.seecen.domain.Clas;
import com.seecen.domain.User;
import com.seecen.domain.UserBo;
import com.seecen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PackageName: com.seecen.service.impl
 * @ClassName: UserServiceimpl
 * @Description: TODO
 * @Author: hao
 * @Date: 2019/10/25 - 9:55
 * @Version: 1.0
 **/
@Service
public class UserServiceimpl  implements UserService {

   @Autowired
    private  UserDao  userDao;

    @Override
    public int save(User user) {
        User exist =  userDao.findByName(user.getUserName());
        if(exist == null){
            userDao.save(user);
            return 1;
        }
            return  0 ;
    }

    @Override
    public User login(User user) {
        User userdata = userDao.findByName(user.getUserName());
        return userdata;

    }

    public List<User> findUser(Integer userId) {
        return userDao.findUser(userId);
    }

    //删除用户
    public void delUser(int userId) {
        userDao.delUser(userId);
    }

    @Override
    public void updateUserdata(User user) {
        System.out.println("333333333333");
        userDao.updateUserdata(user);
    }

    @Override
    public List<User> findUserJ(UserBo userBo) {
        return userDao.findUserJ(userBo);
    }

    //    用户列表分页
    public List<User> list(User user, int pageNum, int pageSize) {
        return userDao.list(user);
    }


    //查找用户类型
    public List<String> findIsAdmin() {
        return userDao.findIsAdmin();
    }

    //查找班级id
    public List<Clas> findClassId() {
        return userDao.findClassId();
    }


    //    //根据id查找用户信息
    public User findUserById(Integer userId) {
        return userDao.findUserById(userId);
    }

    /**
     * @Author: hao
     * @Date: 2019/10/29 - 14:18
     * @Description:  修改用户信息
     */
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

/**
 * @Author: hao
 * @Date: 2019/10/29 - 15:36
 * @Description:  添加用户
 */
    public void addUser(User user) {
        userDao.addUser(user);
    }

    //批量删除
    public void deleteAll(Integer[] ids) {
        userDao.deleteAll(ids);
    }

   //注册功能查找
//    public int findAll(String userName) {
//        return 0;
//    }
   public int findAll(String userName) {
       System.err.println(userDao.findAll(userName));
       if(userDao.findAll(userName) != 0){
           return 1;
       }
       return 0;
   }


//    //根据id查找用户信息
//    public User findUserById() {
//        return userDao.findUserById();
//    }


}
