package com.seecen.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seecen.Messagess.JuheDemo;
import com.seecen.domain.Clas;
import com.seecen.domain.SubjectBank;
import com.seecen.domain.User;
import com.seecen.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

//    @Autowired
//    private UserService userService;
//    @PostMapping("/register.action")
//    public ModelAndView register(User user ,HttpServletRequest request){
//        ModelAndView mv = new ModelAndView();
//        int result = userService.save(user);
//        System.out.println(user);
//        if(result > 0 ){
//            mv.setViewName("redirect:/static/login.jsp");
//        }else {
//            mv.setViewName("redirect:/static/register.jsp");
//            mv.addObject("fail","该用户名已经存在，请重新注册");
////            request.setAttribute("fail","该用户名已存在,请重新注册!");
//        }
//        return  mv;
//    }


   //注册功能
    @Autowired
    private UserService userService;
    @PostMapping("/register.action")
    public ModelAndView register(User user ,HttpServletRequest request){
        System.err.println(user.getClassId());
        ModelAndView mv = new ModelAndView();
        int result = userService.findAll(user.getUserName());
        System.out.println(result);
        int yzm = Integer.parseInt(request.getParameter("msgs"));
        int code= JuheDemo.code;
        System.err.println(code);

        System.out.println(user);
        if(result == 0 && yzm==code){
            userService.save(user);
            mv.setViewName("redirect:/static/login.jsp");
        }else {
            mv.setViewName("redirect:/static/register.jsp");
            mv.addObject("fail","该用户名已经存在，请重新注册");
//            request.setAttribute("fail","该用户名已存在,请重新注册!");
        }
        return  mv;
    }




//登录功能
    @PostMapping("/login.action")
    public ModelAndView login(User user  ,HttpServletRequest  request) {
        System.out.println("用户登录："+user.getUserName()+user.getPassword());
        ModelAndView modelAndView = new ModelAndView();

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),user.getPassword());
        try{subject.login(token);
        }catch (UnknownAccountException e){
            modelAndView.addObject("fail","用户名不存在");
            modelAndView.setViewName("redirect:/static/register.jsp");
        }catch (IncorrectCredentialsException e){
            modelAndView.addObject("fail","密码错误！");

            modelAndView.setViewName("redirect:/static/login.jsp");
        }

//        String result = userService.check(user.getUserName());
        User userdata = userService.login(user);
        String ps = request.getParameter("password");

        if(userdata == null){
//            request.setAttribute("fail","用户名不存在,请先进行注册");
            modelAndView.addObject("fail","该用户名不存在，请先进行注册");
            modelAndView.setViewName("redirect:/static/register.jsp");
        }else if(!ps.equals(userdata.getPassword())){
            modelAndView.addObject("fail","用户名或密码错误！");
            modelAndView.setViewName("redirect:/static/login.jsp");
        }else {
//            modelAndView.setViewName("redirect:/index.jsp");
            modelAndView.setViewName("redirect:/static/index.jsp");
            request.getSession().setAttribute("userdata",userdata);

        }
        return modelAndView;


    }




    //    用户列表分页
@ResponseBody
@RequestMapping("/list.action")
public PageInfo<User> list(User user, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize){
    PageHelper.startPage(pageNum, pageSize, true);
    List<User> list = userService.list(user,pageNum,pageSize);
    PageInfo<User> pageInfo = new PageInfo<>(list);
    return pageInfo;
}


//查找用户类型
    @ResponseBody
    @RequestMapping("findIsAdmin.action")
    public List<String> findIsAdmin(){
        return userService.findIsAdmin();
    }


    //查找班级id
    @ResponseBody
    @RequestMapping("findClassId.action")
    public  List<Clas> findClassId(){
        return  userService.findClassId();
    }

//    //删除用户
////    @ResponseBody
////    @GetMapping("/deleteUser.action")
////    public ModelAndView del(@RequestParam("id") int id){
////        ModelAndView mv = new ModelAndView("admin_Jurisdiction");
////        userService.delUser(id);
////        return mv;
////    }


        //删除用户
    @ResponseBody
    @GetMapping("/deleteUser.action")
    public void del(@RequestParam("id") int id){
       // ModelAndView mv = new ModelAndView("admin_Jurisdiction");
        userService.delUser(id);
      //  return mv;
    }


    //根据id查找用户信息
    @ResponseBody
    @GetMapping("/findUserById.action")
    public User findUserById(Integer userId){
        System.out.println(userId);
        User user  = userService.findUserById(userId);
        return user;
    }

    //修改用户信息
    @ResponseBody
    @GetMapping("/updateUser.action")
    public  void updateUser(User user ){
        userService.updateUser(user);
    }


    //添加用户
    @ResponseBody
    @GetMapping("/addUser.action")
    public void addUser(User user){
        userService.addUser(user);
    }



//    public ModelAndView delete(Integer[] userIds){
////        //测试
////        //Arrays.asList(userIds).stream().forEach(System.out::println);
////        userService.delete(userIds);
////        //因为spring不会创建第二层对象 要new
////        return list(new UserBO(), 1,10);
////    }


    //批量删除
    @ResponseBody
    @GetMapping("/deleteAll.action")
    public String deleteAll(Integer[]  ids){
        userService.deleteAll(ids);
        return "success";
    }

//发送短信
    @GetMapping("/yzm.action")
    public void yzm(HttpServletRequest request){
//        ModelAndView mv = new ModelAndView("redirect:/static/register.jsp");
        long tel = Long.parseLong(request.getParameter("telephone"));
        System.err.println(tel);
        JuheDemo.getRequest2(tel);
//        return mv;
    }


}
