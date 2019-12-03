package com.seecen.controller;

import com.seecen.pojo.Subscriber;
import com.seecen.service.IsubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/monitor")
@Controller
public class monitorController {

    @Autowired
    private IsubscriberService isubscriberService;
    //监听修改签名
    @RequestMapping("/update/sign.action")
    public void  UpdateSign(String sign,Integer id){
        Subscriber subscriber = new Subscriber();
        subscriber.setSign(sign);
        subscriber.setUserId(id);
        isubscriberService.updatesign(subscriber);
    }

    //监听用户状态
    @RequestMapping("/update/status.action")
    public void updatestatus(String status,Integer id){
        Subscriber subscriber = new Subscriber();
        subscriber.setStatus(status);
        subscriber.setUserId(id);
        isubscriberService.updatestatus(subscriber);
    }
}
