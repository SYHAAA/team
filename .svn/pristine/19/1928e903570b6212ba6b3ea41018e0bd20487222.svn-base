package com.seecen.controller;

import com.github.pagehelper.PageInfo;
import com.seecen.domain.Exam;
import com.seecen.domain.SubjectBank;
import com.seecen.domain.User;
import com.seecen.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 沈煜辉
 * @date 2019/10/27 11:06
 * @describe 考试管理的controller层
 */
@Controller
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    private ExamService examService;
    @ResponseBody
    @RequestMapping("/findAll.action")
    public PageInfo<Exam> findAllWithPage(Exam exam, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize){
        List<Exam> list = examService.findAllWithPage(exam,pageNum,pageSize);
        PageInfo<Exam> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @RequestMapping("/saveExam.action")
    @ResponseBody
    public void saveExam(Exam exam){
        examService.saveExam(exam);
    }


    @ResponseBody
    @RequestMapping("/findExamAndSubject.action")
    public Exam findExamAndSubject(Integer examId){
        Exam exam = examService.findExamAndSubject(examId);
        return exam;
    }

    @ResponseBody
    @RequestMapping("/deleteExam.action")
    public void deleteExam(Integer examId){
        examService.deleteExam(examId);
    }

    @ResponseBody
    @RequestMapping("/findExamWithClass.action")
    public PageInfo<Exam> findExamWithClass(HttpSession session, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10")int pageSize){
        User user = (User) session.getAttribute("userdata");
        if(user==null){
            return null;
        }
        List<Exam> list = examService.findExamWithClass(user,pageNum,pageSize);
        PageInfo<Exam> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @RequestMapping("/findExamById.action")
    public String findExamById(Integer examId,HttpServletRequest request){
        Exam exam = examService.findExamAndSubject(examId);
        List<SubjectBank> single = new ArrayList<>();
        List<SubjectBank> many = new ArrayList<>();
        List<SubjectBank> judge = new ArrayList<>();
        List<SubjectBank> answer = new ArrayList<>();
        for (SubjectBank subject : exam.getSubjects()) {
            if(subject.getSubjectType().getTypeId()==2){
                single.add(subject);
            }
            if(subject.getSubjectType().getTypeId()==3){
                many.add(subject);
            }
            if(subject.getSubjectType().getTypeId()==4){
                judge.add(subject);
            }
            if(subject.getSubjectType().getTypeId()==5){
                answer.add(subject);
            }
        }
        request.setAttribute("exam",exam);
        request.setAttribute("single",single);
        request.setAttribute("many",many);
        request.setAttribute("judge",judge);
        request.setAttribute("answer",answer);
        return "/pages/examing.jsp";
    }
}
