package com.seecen.controller;

import com.seecen.pojo.Subscriber;
import com.seecen.service.IGroupService;
import com.seecen.service.IsubscriberService;
import com.seecen.vo.SNSmine;
import jdk.nashorn.internal.ir.ObjectNode;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.security.provider.Sun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private IsubscriberService isubscriberService;

    @Autowired
    private IGroupService iGroupService;
    //获取群员
    @ResponseBody
    @RequestMapping("/getmember.action")
    public HashMap getMember(Integer id){
        int members = iGroupService.groupnum(id);
        Subscriber owners = isubscriberService.getowner(id);
        SNSmine owner = new SNSmine();
        owner.setId(owners.getUserId());
        owner.setUsername(owners.getUserName());
        owner.setSign(owners.getSign());
        owner.setAvatar(owners.getAvatar());
        List<Subscriber> list = isubscriberService.groupUser(id);
        List<SNSmine> List = new ArrayList<>();

        for (Subscriber subscriber:list
        ) {
            SNSmine snsmine = new SNSmine();
            snsmine.setId(subscriber.getUserId());
            snsmine.setUsername(subscriber.getUserName());
            snsmine.setSign(subscriber.getSign());
            snsmine.setAvatar(subscriber.getAvatar());
            List.add(snsmine);
        }

        HashMap hashMap1 = new HashMap();
        hashMap1.put("code",0);
        hashMap1.put("msg","");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("owner",owner);
        hashMap1.put("members",members);
        hashMap2.put("list",List);
        hashMap1.put("data",hashMap2);
        return hashMap1;
    }
}
