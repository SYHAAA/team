package com.seecen.controller;

import com.seecen.dao.TabRlyDao;
import com.seecen.domain.TabRly;
import com.seecen.domain.TieziMessage;
import com.seecen.service.TabRlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/reply")
public class TabRlyController {
    @Autowired
    private TabRlyService tabRlyService;

    @ResponseBody
    @RequestMapping("/find.action")
    public List<TabRly> select(){
        return tabRlyService.select();
    }

    @ResponseBody
    @RequestMapping("/findrly/{postId}.action")
    public TabRly findrly( @PathVariable("postId") Integer postId){
        System.out.println("接收到了数据:"+postId);
        return tabRlyService.findrly(postId);
    }

    @RequestMapping("/add.action")
    @ResponseBody
    public ModelAndView add(TabRly tabRly){
        tabRlyService.add(tabRly);
        ModelAndView modelAndView =new ModelAndView("redirect:/pages/test.html");
        return modelAndView;

    }

}
