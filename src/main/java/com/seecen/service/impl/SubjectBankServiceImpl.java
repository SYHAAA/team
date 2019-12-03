package com.seecen.service.impl;

import com.github.pagehelper.PageHelper;
import com.seecen.dao.SubjectBankDao;
import com.seecen.domain.SubjectBank;
import com.seecen.domain.SubjectType;
import com.seecen.service.SubjectBankService;
import com.seecen.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 沈煜辉
 * @date 2019/10/24 14:40
 * @describe 查询题库的业务层接口
 */
@Service
public class SubjectBankServiceImpl implements SubjectBankService {

    @Autowired
    private SubjectBankDao subjectBankDao;

    @Override
    public List<SubjectBank> findAllWithPage(SubjectBank subjectBank,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return subjectBankDao.findAllWithPage(subjectBank);
    }

    @Override
    public List<SubjectType> findAllSubjectType() {
        return subjectBankDao.findAllSubjectType();
    }

    @Override
    public List<String> findAllSubjectPoints() {
        return subjectBankDao.findAllSubjectPoints();
    }

    @Override
    public void deleteSubject(int id) {
        subjectBankDao.deleteSubject(id);
    }

    @Override
    public void saveSubject(SubjectBank subjectBank) {
        StringBuffer content = new StringBuffer();
        if(StringUtil.isNotEmpty(subjectBank.getOptionsA())){
            content.append(subjectBank.getOptionsA());
        }
        if(StringUtil.isNotEmpty(subjectBank.getOptionsB())){
            content.append("@#%"+subjectBank.getOptionsB());
        }
        if(StringUtil.isNotEmpty(subjectBank.getOptionsC())){
            content.append("@#%"+subjectBank.getOptionsC());
        }
        if(StringUtil.isNotEmpty(subjectBank.getOptionsD())){
            content.append("@#%"+subjectBank.getOptionsD());
        }
        subjectBank.setSubjectOption(content.toString());

        subjectBankDao.saveSubject(subjectBank);
    }

    @Override
    public SubjectBank findSubjectById(Integer subjectId) {
        SubjectBank subjectBank = subjectBankDao.findSubjectById(subjectId);
        String option = subjectBank.getSubjectOption();
        if(StringUtil.isNotEmpty(option)){
            String[] options = option.split("@#%");
            int i = options.length;
            if(3==i){
                subjectBank.setOptionsA(options[0]);
                subjectBank.setOptionsB(options[1]);
                subjectBank.setOptionsC(options[2]);
            }
            if(4==i){
                subjectBank.setOptionsA(options[0]);
                subjectBank.setOptionsB(options[1]);
                subjectBank.setOptionsC(options[2]);
                subjectBank.setOptionsD(options[3]);
            }
        }
        return subjectBank;
    }

    @Override
    public void updateSubject(SubjectBank subjectBank) {
        if(subjectBank.getSubjectType().getTypeId()==4){
//            更新判断题
            subjectBankDao.updateJudgeSubject(subjectBank);
        }
        else if(subjectBank.getSubjectType().getTypeId()==5){
//            更新简述题
            subjectBankDao.updateBrieflySubject(subjectBank);
        }else{
            StringBuffer content = new StringBuffer();
            if(StringUtil.isNotEmpty(subjectBank.getOptionsA())){
                content.append(subjectBank.getOptionsA());
            }
            if(StringUtil.isNotEmpty(subjectBank.getOptionsB())){
                content.append("@#%"+subjectBank.getOptionsB());
            }
            if(StringUtil.isNotEmpty(subjectBank.getOptionsC())){
                content.append("@#%"+subjectBank.getOptionsC());
            }
            if(StringUtil.isNotEmpty(subjectBank.getOptionsD())){
                content.append("@#%"+subjectBank.getOptionsD());
            }
            subjectBank.setSubjectOption(content.toString());
//            更新选择题
            subjectBankDao.updateCheckSubject(subjectBank);
        }
    }

    @Override
    public String findQuestionAnswer(Integer questionId) {
        return subjectBankDao.findQuestionAnswer(questionId);
    }


}
