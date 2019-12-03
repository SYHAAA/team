package com.seecen.controller;

import com.github.pagehelper.PageInfo;
import com.seecen.domain.SubjectBank;
import com.seecen.domain.SubjectType;
import com.seecen.service.SubjectBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 沈煜辉
 * @date 2019/10/24 14:43
 * @describe 题库管理controller
 */
@Controller
@RequestMapping("/subjectBank")
public class SubjectBankController {

    @Autowired
    private SubjectBankService subjectBankService;
    @ResponseBody
    @RequestMapping("/findAll.action")
    public PageInfo<SubjectBank> findAll(SubjectBank subjectBank, @RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "10") int pageSize){
        List<SubjectBank> list = subjectBankService.findAllWithPage(subjectBank,pageNum,pageSize);
        PageInfo<SubjectBank> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @ResponseBody
    @RequestMapping("/findAllSubjectType.action")
    public List<SubjectType> findAllSubjectType(){
        return subjectBankService.findAllSubjectType();
    }

    @ResponseBody
    @RequestMapping("findAllSubjectPoints.action")
    public List<String> findAllSubjectPoints(){
        return subjectBankService.findAllSubjectPoints();
    }

    @RequestMapping("/deleteSubject.action")
    @ResponseBody
    public void deleteSubject(Integer id){
        subjectBankService.deleteSubject(id);
    }

    @ResponseBody
    @RequestMapping("/saveSubject.action")
    public void saveSubject(SubjectBank subjectBank){
        subjectBankService.saveSubject(subjectBank);
    }

    @ResponseBody
    @RequestMapping("/findSubjectById.action")
    public SubjectBank findSubjectById(Integer subjectId){
        SubjectBank subjectBank = subjectBankService.findSubjectById(subjectId);
        return subjectBank;
    }

    @ResponseBody
    @RequestMapping("/updateSubjectById.action")
    public void updateSubject(SubjectBank subjectBank){
        subjectBankService.updateSubject(subjectBank);
    }
}
