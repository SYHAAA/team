package com.seecen.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seecen.domain.TieziMessage;
import com.seecen.service.TieziMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/replyMessage")
public class ReplyMessageController {

    @Autowired
    private TieziMessageService tieziMessageService;
    @ResponseBody
    @RequestMapping("/find.action")
    public List<TieziMessage> select(){
        //ModelAndView mv = new ModelAndView("post_look_show");
        //PageHelper.startPage(pageNum,pageSize,true);
        //List<TieziMessage> list = tieziMessageService.selectById();
        //PageInfo<TieziMessage> pageInfo = new PageInfo<>(list);
        //mv.addObject("pageInfo",pageInfo);
        // mv.addObject("post_look_show");

        return tieziMessageService.select();
    }

    @RequestMapping("/initById/{id}.action")
    @ResponseBody
    public TieziMessage initById(@PathVariable("id") Integer id)
    {
        System.out.println("接收到的id为:"+id);
        return tieziMessageService.initById(id);
    }

    @RequestMapping("/insert.action")
    @ResponseBody
    public ModelAndView insert(TieziMessage tieziMessage){
        tieziMessageService.insert(tieziMessage);
        ModelAndView modelAndView =new ModelAndView("redirect:/pages/test.html");
        return modelAndView;

    }

}
