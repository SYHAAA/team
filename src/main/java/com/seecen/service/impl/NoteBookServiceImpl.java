package com.seecen.service.impl;

import com.seecen.bo.NoteBookBo;
import com.seecen.dao.INoteBookDao;
import com.seecen.domain.NoteBook;
import com.seecen.service.INoteBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NoteBookServiceImpl implements INoteBookService {
    @Autowired
    private INoteBookDao noteBookDao;

    @Transactional
    public int save(NoteBook noteBook) {
        noteBookDao.save(noteBook);
        return 0;
    }

    @Transactional
    public List<NoteBook> list(NoteBookBo noteBookBo) {
        return noteBookDao.list(noteBookBo);
    }
}
