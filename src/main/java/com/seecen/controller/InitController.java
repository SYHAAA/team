package com.seecen.controller;

import com.seecen.pojo.Group;
import com.seecen.pojo.Subscriber;

import com.seecen.service.IFriendService;
import com.seecen.service.IFritypeService;
import com.seecen.service.IGroupService;
import com.seecen.service.IsubscriberService;
import com.seecen.vo.SNSfrined;
import com.seecen.vo.SNSgruop;
import com.seecen.vo.SNSmine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/user")
public class InitController {

    @Autowired
    private IsubscriberService isubscriberService;
    @Autowired
    private IFriendService iFriendService;
    @Autowired
    private IFritypeService iFritypeService;
    @Autowired
    private IGroupService iGroupService;
//初始化用户信息

    @ResponseBody
    @RequestMapping("/initById/{id}.action")
    public HashMap getUser(@PathVariable Integer id){
        //好友分组
        List<SNSfrined> friend = new ArrayList<>();
        Set<Integer> typeIds = iFriendService.findtype(id);
        for (Integer typeId:typeIds
             ) {
            List<Subscriber> Sublist = new ArrayList<>();
            SNSfrined snsfrined = new SNSfrined();
            String typeNmae = iFritypeService.findname(typeId);
            snsfrined.setGroupname(typeNmae);
            snsfrined.setId(typeId);
            Sublist = isubscriberService.friendList(id,typeId);
            List<SNSmine> snsmineList = new ArrayList<>();
            for (Subscriber s:Sublist
            ) {
                SNSmine snsmine = new SNSmine();
                snsmine.setId(s.getUserId());
                snsmine.setUsername(s.getUserName());
                snsmine.setSign(s.getSign());
                snsmine.setAvatar(s.getAvatar());
                snsmine.setStatus(s.getStatus());
                snsmineList.add(snsmine);
            }
            snsfrined.setList(snsmineList);
            friend.add(snsfrined);
        }
        //群
         List<Group> group = iGroupService.findGruop(id);
         List<SNSgruop>  list = new ArrayList<>();
         for (Group groups: group
             ) {
               SNSgruop snsgruop = new SNSgruop();
               snsgruop.setId(groups.getGroupId());
               snsgruop.setGroupname(groups.getGroupName());
               snsgruop.setAvatar(groups.getAvatar());
               list.add(snsgruop);
         }

//用户自己信息
      Subscriber subscribe = isubscriberService.getById(id);
      SNSmine snsmine = new SNSmine();
      snsmine.setId(subscribe.getUserId());
      snsmine.setUsername(subscribe.getUserName());
      snsmine.setSign(subscribe.getSign());
      snsmine.setAvatar(subscribe.getAvatar());
      snsmine.setStatus(subscribe.getStatus());
      HashMap hashMap1  = new HashMap();
      hashMap1.put("code",0);
      hashMap1.put("msg","");
      HashMap hashMap2 = new HashMap();
      hashMap2.put("mine",snsmine);
      hashMap2.put("friend",friend);
      hashMap2.put("group",list);
      hashMap1.put("data",hashMap2);
      return hashMap1;

    }




}
