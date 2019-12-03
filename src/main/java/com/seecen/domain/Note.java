package com.seecen.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Note extends Entity{
    private Integer noteId;

    private Integer notebookId;

    private Integer userId;

    private Short nValid;

    private String title;

    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;

    private Short Collection;

    public Short getCollection() {
        return Collection;
    }

    public void setCollection(Short collection) {
        Collection = collection;
    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public Integer getNotebookId() {
        return notebookId;
    }

    public void setNotebookId(Integer notebookId) {
        this.notebookId = notebookId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Short getnValid() {
        return nValid;
    }

    public void setnValid(Short nValid) {
        this.nValid = nValid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }


    @Override
    public String toString() {
        return "Note{" +
                "noteId=" + noteId +
                ", notebookId=" + notebookId +
                ", userId=" + userId +
                ", nValid=" + nValid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", Collection=" + Collection +
                '}';
    }
}