package com.seecen.controller;

import com.github.pagehelper.PageInfo;
import com.seecen.domain.*;
import com.seecen.service.ExamRecordService;
import com.seecen.service.ExamService;
import com.seecen.service.SubjectBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 沈煜辉
 * @date 2019/10/31 9:48
 * @describe 考试记录的控制层
 */
@Controller
@RequestMapping("/examRecord")
public class ExamRecordController {

    @Autowired
    private SubjectBankService subjectBankService;

    @Autowired
    private ExamRecordService examRecordService;

    @Autowired
    private ExamService examService;

    @RequestMapping("/saveRecord.action")
    public ModelAndView saveExamRecord(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        User user = (User) request.getSession().getAttribute("userdata");
        Integer examId = Integer.valueOf(request.getParameter("examId"));
        Integer singleNum = Integer.valueOf(request.getParameter("singleLength"));
        Integer manyNum = Integer.valueOf(request.getParameter("manyLength"));
        Integer judgeNum = Integer.valueOf(request.getParameter("judgeLength"));
        Integer answerNum = Integer.valueOf(request.getParameter("answerLength"));
        ExamRecord record = new ExamRecord();
        int sumSource = 0;
        if(user!=null){
            record.setUserId(user.getUserId());
        }else{
            record.setUserId(0);
        }
        record.setExamId(examId);
        record.setReview(0);
        if(singleNum>0){
            for (int i=0;i<singleNum;i++){
                UserExam userExam = new UserExam();
                Integer singleQuestionId = Integer.valueOf(request.getParameter("singleQuestion"+i));
//                正确答案
                String answer = subjectBankService.findQuestionAnswer(singleQuestionId);
//                用户答案
                String userAnswer = request.getParameter("single" + i);
                Integer singleSource = Integer.valueOf(request.getParameter("singleSource"));
                userExam.setSubjectSource(0);
                if(userAnswer.equals(answer)){
                    sumSource += singleSource;
                    userExam.setSubjectSource(singleSource);
                }
                userExam.setSubjectId(singleQuestionId);
                userExam.setAnswer(userAnswer);
                userExam.setReferenceAnswer(answer);
                record.getUserExams().add(userExam);
            }
        }
        if(manyNum>0){
            for (int i=0;i<manyNum;i++){
                UserExam userExam = new UserExam();
                Integer manyQuestionId = Integer.valueOf(request.getParameter("manyQuestion"+i));
//                正确答案
                String answer = subjectBankService.findQuestionAnswer(manyQuestionId);
//                用户答案
                String userAnswer = request.getParameter("manyAnswer" + i);
                Integer manySource = Integer.valueOf(request.getParameter("manySource"));
                userExam.setSubjectSource(0);
                if(userAnswer.equals(answer)){
                    sumSource += manySource;
                    userExam.setSubjectSource(manySource);
                }
                userExam.setSubjectId(manyQuestionId);
                userExam.setAnswer(userAnswer);
                userExam.setReferenceAnswer(answer);
                record.getUserExams().add(userExam);
            }
        }
        if(judgeNum>0){
            for (int i=0;i<judgeNum;i++){
                UserExam userExam = new UserExam();
                Integer judgeQuestionId = Integer.valueOf(request.getParameter("judgeQuestion"+i));
//                正确答案
                String answer = subjectBankService.findQuestionAnswer(judgeQuestionId);
//                用户答案
                String userAnswer = request.getParameter("judge" + i);
                Integer judgeSource = Integer.valueOf(request.getParameter("judgeSource"));
                userExam.setSubjectSource(0);
                if(answer==userAnswer){
                    sumSource += judgeSource;
                    userExam.setSubjectSource(judgeSource);
                }
                userExam.setSubjectId(judgeQuestionId);
                userExam.setAnswer(userAnswer);
                userExam.setReferenceAnswer(answer);
                record.getUserExams().add(userExam);
            }
        }
        if(answerNum>0){
            for (int i=0;i<answerNum;i++){
                UserExam userExam = new UserExam();
                Integer answerQuestionId = Integer.valueOf(request.getParameter("answerQuestion"+i));
                userExam.setSubjectId(answerQuestionId);
                String ref = subjectBankService.findQuestionAnswer(answerQuestionId);
                String answer = request.getParameter("answer" + i);
                userExam.setAnswer(answer);
                userExam.setSubjectId(answerQuestionId);
                userExam.setSubjectSource(0);
                userExam.setReferenceAnswer(ref);
                record.getUserExams().add(userExam);
            }
        }
        record.setObjectiveSource(sumSource);
        examRecordService.saveExamRecord(record);
        mv.setViewName("/pages/exam-result.jsp");
        mv.addObject("source",sumSource);
        return mv;
    }

    @ResponseBody
    @RequestMapping("/findExamRecordWithUser.action")
    public PageInfo<ExamRecord> findExamRecord(HttpSession session,@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "10")int pageSize){
        User user = (User) session.getAttribute("userdata");
        if(user==null){
            return null;
        }
        List<ExamRecord> examRecords = examRecordService.findExamRecord(user.getUserId(),pageNum,pageSize);
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
        return "/pages/exam-history.jsp";
    }
}
