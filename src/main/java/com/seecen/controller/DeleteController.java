package com.seecen.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seecen.domain.Note;
import com.seecen.service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/delete")
public class DeleteController {
    @Autowired
    private INoteService noteService;


    @RequestMapping("/show.action")
    public PageInfo<Note> deleteNotePageInfoPage(Note note,
                                                 @RequestParam(defaultValue = "1") int pageNum , @RequestParam(defaultValue = "10") int pageSize){
        PageHelper.startPage(pageNum,pageSize,true);
        List<Note> list=noteService.listDelete(note);
        PageInfo<Note> pageInfo = new PageInfo<>(list);
        return  pageInfo;
    }

    @RequestMapping("/deleteForever.action")
    public String delete(Integer[] noteIds) {
        noteService.deleteF(noteIds);
        return "success";
    }

    @RequestMapping("/callback.action")
    public String revoke(Integer noteId) {
        noteService.callback(noteId);
        return "success";
    }


    @RequestMapping("/cancel.action")
    public String cancel(Integer noteId) {
        noteService.cancel(noteId);
        return "success";
    }


}
