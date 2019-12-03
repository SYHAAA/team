package com.seecen.controller;

import com.seecen.pojo.Subscriber;
import com.seecen.service.IsubscriberService;
import com.seecen.vo.SNSmine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ResponseBody
@Controller
@RequestMapping("/Find")
public class FindController {
    @Autowired
    private IsubscriberService isubscriberService;

    @RequestMapping("/ById/{id}.action")
    public HashMap fintStranger(@PathVariable Integer id){
        List<Subscriber> subscribers = isubscriberService.getStranger(id);
        List<SNSmine> List = new ArrayList<>();
        for (Subscriber subscriber :subscribers) {
            SNSmine snsmine = new SNSmine();
            snsmine.setId(subscriber.getUserId());
            snsmine.setUsername(subscriber.getUserName());
            snsmine.setSign(subscriber.getSign());
            snsmine.setAvatar(subscriber.getAvatar());
            List.add(snsmine);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("code",0);
        hashMap.put("msg","");
        hashMap.put("data",List);
        return hashMap;
    }


}
