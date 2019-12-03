package com.seecen.controller;

import com.github.pagehelper.PageInfo;
import com.seecen.domain.Exam;
import com.seecen.domain.ExamRecord;
import com.seecen.domain.SubjectBank;
import com.seecen.service.ExamRecordService;
import com.seecen.service.ExamService;
import com.seecen.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 沈煜辉
 * @date 2019/11/1 19:33
 * @describe 后台的成绩管理
 */
@Controller
@RequestMapping("/source")
public class SourceController {

    @Autowired
    private SourceService sourceService;
    @Autowired
    private ExamRecordService examRecordService;
    @Autowired
    private ExamService examService;

    @ResponseBody
    @RequestMapping("/findAllSource.action")
    public PageInfo<ExamRecord> findAllSource(ExamRecord examRecord, @RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "10") int pageSize){
        List<ExamRecord> examRecords = sourceService.findAllSource(examRecord,pageNum,pageSize);
        PageInfo<ExamRecord> pageInfo = new PageInfo<>(examRecords);
        return pageInfo;
    }

    @RequestMapping("/findExamInfo.action")
    public String finaExamInfo(Integer history, HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        List<SubjectBank> subjectBanks = examRecordService.finaExamInfo(history);
        ExamRecord examRecord = examRecordService.findExamIdByHistory(history);
        Exam exam = examService.findExamById(examRecord.getExamId());
        List<SubjectBank> single = new ArrayList<>();
        List<SubjectBank> many = new ArrayList<>();
        List<SubjectBank> judge = new ArrayList<>();
        List<SubjectBank> answer = new ArrayList<>();
        for (SubjectBank subjectBank : subjectBanks) {
            if(subjectBank.getSubjectType().getTypeId()==2){
                String[] split = subjectBank.getSubjectOption().split("@#%");
                if(split.length==3){
                    subjectBank.setOptionsA(split[0]);
                    subjectBank.setOptionsB(split[1]);
                    subjectBank.setOptionsC(split[2]);
                }
                if(split.length==4){
                    subjectBank.setOptionsA(split[0]);
                    subjectBank.setOptionsB(split[1]);
                    subjectBank.setOptionsC(split[2]);
                    subjectBank.setOptionsD(split[3]);
                }
                single.add(subjectBank);
            }
            if(subjectBank.getSubjectType().getTypeId()==3){
                String[] split = subjectBank.getSubjectOption().split("@#%");
                if(split.length==3){
                    subjectBank.setOptionsA(split[0]);
                    subjectBank.setOptionsB(split[1]);
                    subjectBank.setOptionsC(split[2]);
                }
                if(split.length==4){
                    subjectBank.setOptionsA(split[0]);
                    subjectBank.setOptionsB(split[1]);
                    subjectBank.setOptionsC(split[2]);
                    subjectBank.setOptionsD(split[3]);
                }
                many.add(subjectBank);
            }
            if(subjectBank.getSubjectType().getTypeId()==4){
                judge.add(subjectBank);
            }
            if(subjectBank.getSubjectType().getTypeId()==5){
                answer.add(subjectBank);
            }
        }
        request.setAttribute("exam",exam);
        request.setAttribute("examRecord",examRecord);
        request.setAttribute("single",single);
        request.setAttribute("many",many);
        request.setAttribute("judge",judge);
        request.setAttribute("answer",answer);
//        return examRecord;
        return "/pages/source-history.jsp";
    }

    @RequestMapping("/updateSource.action")
    public String updateSource(HttpServletRequest request){
        Integer answerLength = Integer.valueOf(request.getParameter("answerLength"));
        String historyId = request.getParameter("historyId");
        String evl = request.getParameter("evl");
        String userId = request.getParameter("userId");
        int sum=0;
        for (int i = 0; i < answerLength; i++) {
            String answerId = request.getParameter("answerQuestion" + i);
            int answerSource = Integer.parseInt(request.getParameter("userAnswer"+i));
            sum += answerSource;
//            sourceService.updateSubjectSource(historyId,answerId,answerSource);
        }
        sourceService.updateSource(historyId,userId,sum,evl);
        return "redirect:/pages/source-list.html";
    }
}
