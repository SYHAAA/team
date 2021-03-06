package com.seecen.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seecen.domain.Note;
import com.seecen.service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private INoteService noteService;

    @PostMapping("/note/add.action")
    public ModelAndView add(Note note){
        noteService.save(note);
        return new ModelAndView("redirect:/pages/new_note.jsp#/result=1");
    }


    @RequestMapping("/note.action")
    public PageInfo<Note> notePageInfoPage(Note note,
                                                  @RequestParam(defaultValue = "1") int pageNum , @RequestParam(defaultValue = "10") int pageSize){
        PageHelper.startPage(pageNum,pageSize,true);
        List<Note> list=noteService.list(note);
        PageInfo<Note> pageInfo = new PageInfo<>(list);
        return  pageInfo;
    }


    @RequestMapping("/note/delete.action")
    public String delete(Integer[] noteIds) {
        noteService.delete(noteIds);
        return "success";
    }


    @RequestMapping ("/note/init/{noteId}.action")
    public Note init(@PathVariable("noteId") Integer noteId, HttpServletRequest request) {
        Note note = noteService.initById(noteId);
        request.getSession().removeAttribute("node");
        request.getSession().setAttribute("note", note);
        return note;
    }


    @PostMapping("/note/update.action")
    public ModelAndView update(Note note){
        noteService.update(note);
        return new ModelAndView("redirect:/pages/note_edit.jsp#/id="+note.getNoteId()+"/result=1");
    }


    @RequestMapping("/note/collections.action")
    public PageInfo<Note> collectionPageInfoPage(Note note,
                                           @RequestParam(defaultValue = "1") int pageNum , @RequestParam(defaultValue = "10") int pageSize){
        PageHelper.startPage(pageNum,pageSize,true);
        List<Note> list=noteService.listCollections(note);
        PageInfo<Note> pageInfo = new PageInfo<>(list);
        return  pageInfo;
    }

    @RequestMapping("/collections.action")
    public PageInfo<Note> collection(Integer noteId) {
        noteService.collection(noteId);
        return collectionPageInfoPage(new Note(),1,10);
    }


    @PostMapping("/share.action")
    public ModelAndView share(Note note){
        noteService.share(note);
        return new ModelAndView("redirect:/pages/shareNote.html#/id="+note.getNoteId()+"/result=1");
    }

}
