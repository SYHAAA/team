package com.seecen.service;

import com.seecen.bo.NoteBookBo;
import com.seecen.domain.NoteBook;

import java.util.List;

public interface INoteBookService {
    int save(NoteBook noteBook);

    List<NoteBook> list(NoteBookBo noteBookBo);

}
