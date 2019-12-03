package com.seecen.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seecen.domain.User;
import com.seecen.domain.UserBo;
import com.seecen.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;
import java.util.UUID;

/**
 * @Author 鞠志超
 * @Date 2019/10/25 14:50
 * @Description
 */
@Controller
@RequestMapping("/user")
public class Myself {
    @Autowired
    private UserService userService;

    @RequestMapping("/myself.action")
    public ModelAndView updateUser(User user, MultipartFile file, HttpSession session) throws IOException {

        ModelAndView mv  = new ModelAndView("redirect:/static/Myself.jsp");
        if(StringUtils.isNotEmpty(file.getOriginalFilename())){
            File f = buildFile(file.getOriginalFilename());
            file.transferTo(f);
            user.setFacePath(f.getName());
        }
        System.out.println(user.toString());
        userService.updateUserdata(user);

        List<User> list = userService.findUser(user.getUserId());
        mv.addObject("user",list);
        User userdata = (User)session.getAttribute("userdata");
        userdata.setFacePath(user.getFacePath());
        return mv;
    }

    private File buildFile(String fileName) throws IOException {
        String fileUniqueName = UUID.randomUUID().toString().replaceAll("-","");
        fileUniqueName += fileName.substring(fileName.lastIndexOf("."));
        File file = new File("g:" + File.separator + "upload" + File.separator + fileUniqueName);
        file.createNewFile();
        return file;
    }

    @RequestMapping("/deleteUser.action")
    public void delUser(int userId){
        userService.delUser(userId);
    }

    @GetMapping("/goout.action")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/static/login.jsp";
    }

        @RequestMapping("/image.action")
        public void getImage(String fileName, HttpServletResponse response) throws UnsupportedEncodingException {
            File file = new File("g:/upload/" + fileName);
            if(!file.exists()) return;
            byte[] data = new byte[1024 * 1024];
            try(InputStream is = new FileInputStream(file);
                ServletOutputStream os = response.getOutputStream();) {
                // 告诉浏览器准备下载,并赋予下载文件的名字
                response.setHeader("Content-Disposition", "attachment;");
                // 告诉浏览器, 我不是响应页面, 而是响应一个二进制数据(流)
                response.setContentType("application/octet-stream");
                int len = 0;
                while((len = is.read(data)) != -1) {
                    os.write(data, 0, len);
                }
            } catch (Exception e) {e.printStackTrace();}
        }


}
