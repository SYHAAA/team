package com.seecen.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seecen.bo.NoteBookBo;
import com.seecen.domain.NoteBook;
import com.seecen.service.INoteBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/notebook")
public class NoteBookController {
    @Autowired
    private INoteBookService noteBookService;

    @PostMapping("/notebook/add.action")
    public ModelAndView add(NoteBook noteBook){
        noteBookService.save(noteBook);
        return new ModelAndView("redirect:/pages/new_note.jsp");
    }

  @RequestMapping("/notebook.action")
    public PageInfo<NoteBook> notebookPageInfoPage(NoteBookBo noteBookBo,
                                           @RequestParam(defaultValue = "1") int pageNum , @RequestParam(defaultValue = "10") int pageSize){
        PageHelper.startPage(pageNum,pageSize,true);
        List<NoteBook> list=noteBookService.list(noteBookBo);
        PageInfo<NoteBook> pageInfo = new PageInfo<>(list);
        return  pageInfo;
    }

}
