package com.seecen.service.impl;

import com.github.pagehelper.PageHelper;
import com.seecen.dao.ExamRecordDao;
import com.seecen.dao.SubjectBankDao;
import com.seecen.domain.ExamRecord;
import com.seecen.domain.SubjectBank;
import com.seecen.domain.UserExam;
import com.seecen.service.ExamRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author 沈煜辉
 * @date 2019/10/31 13:37
 * @describe
 */
@Service
public class ExamRecordServiceImpl implements ExamRecordService {

    @Autowired
    private ExamRecordDao examRecordDao;

    @Autowired
    private SubjectBankDao subjectBankDao;
    /**
     * 保存考试记录
     * @param record 考试记录
     * @return
     */
    @Override
    public void saveExamRecord(ExamRecord record) {
        examRecordDao.saveExamRecord(record);
        Integer id = record.getExamRecordId();
        examRecordDao.saveExamSubject(id,record.getUserExams());
    }

    @Override
    public List<ExamRecord> findExamRecord(Integer userId,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return examRecordDao.findExamRecord(userId);
    }

    @Override
    public List<SubjectBank> finaExamInfo(Integer history) {
        List<UserExam> userExams = examRecordDao.finaExamInfo(history);
        Integer[] ids = new Integer[userExams.size()];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = userExams.get(i).getSubjectId();
        }
        List<SubjectBank> subjectBanks = subjectBankDao.findSubjectByIds(ids);
        for (SubjectBank subjectBank : subjectBanks) {
            for (UserExam userExam : userExams) {
                if(userExam.getSubjectId().equals(subjectBank.getSubjectId())){
                    subjectBank.setUserAnswer(userExam.getAnswer());
                }
            }
        }
        return subjectBanks;
    }

    @Override
    public ExamRecord findExamIdByHistory(Integer history) {
        return examRecordDao.findExamIdByHistory(history);
    }

}
