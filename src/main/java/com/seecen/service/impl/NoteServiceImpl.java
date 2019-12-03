package com.seecen.service.impl;

import com.seecen.dao.INoteDao;
import com.seecen.domain.Note;
import com.seecen.service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NoteServiceImpl implements INoteService {

@Autowired
private INoteDao noteDao;

    @Transactional
    public int save(Note note) {
        noteDao.save(note);
        return 1;
    }

    @Transactional
    public List<Note> list(Note note) {
        return noteDao.list(note);
    }

    @Transactional
    public Note initById(Integer noteId) {
        return noteDao.initById(noteId);
    }

    @Transactional
    public void delete(Integer[] noteIds) {
        noteDao.logicDeleteByMore(noteIds);
    }

    @Transactional
    public List<Note> listDelete(Note note) {
        return noteDao.listDelete(note);
    }

    @Transactional
    public void deleteF(Integer[] noteIds) {
        noteDao.deleteForever(noteIds);
    }

    @Transactional
    public void callback(Integer noteId) {
        noteDao.revoke(noteId);
    }

    @Transactional
    public void update(Note note) {
        noteDao.update(note);
    }

    @Transactional
    public List<Note> listCollections(Note note) {
        return noteDao.listCollections(note);
    }

    @Transactional
    public void cancel(Integer noteId) {
        noteDao.cancelCollect(noteId);
    }

    @Transactional
    public void collection(Integer noteId) {
        noteDao.collect(noteId);
    }

    @Transactional
    public List<Note> share(Note note) {
        return noteDao.share(note);
    }


}
