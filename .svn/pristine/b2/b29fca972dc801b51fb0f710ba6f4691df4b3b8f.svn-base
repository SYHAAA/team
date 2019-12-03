package com.seecen.controller;

import com.seecen.bo.UserRefloorsBo;
import com.seecen.service.UserRoolrsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/floors")
public class UserRefloorsController {
    @Autowired
    private UserRoolrsService userRoolrsService;

    @ResponseBody
    @RequestMapping("/list.action")
    public List<UserRefloorsBo> list(){
        System.out.println("接收到了数据");
        return userRoolrsService.list();
    }


}
