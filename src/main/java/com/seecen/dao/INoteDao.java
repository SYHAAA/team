package com.seecen.dao;

import com.seecen.domain.Note;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INoteDao {

    int save(Note note);

    List<Note> list(Note note);

    Note initById(Integer noteId);

    void logicDeleteByMore(Integer[] noteIds);

    List<Note> listDelete(Note note);

    void deleteForever(Integer[] noteIds);

    void revoke(Integer noteId);

    void update(Note note);

    List<Note> listCollections(Note note);

    void collect(Integer noteId);

    void cancelCollect(Integer noteId);

    List<Note> share(Note note);
}

