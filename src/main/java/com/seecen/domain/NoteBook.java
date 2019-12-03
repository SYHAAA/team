package com.seecen.domain;

public class NoteBook {
    private Integer notebookId;

    private String notebookName;

    private Short nbValid;

    private String noteTitle;

    private String noteContent;

    private Short notenValid;

    private Short noteCollecion;

    public Short getNotenValid() {
        return notenValid;
    }

    public void setNotenValid(Short notenValid) {
        this.notenValid = notenValid;
    }

    public Short getNoteCollecion() {
        return noteCollecion;
    }

    public void setNoteCollecion(Short noteCollecion) {
        this.noteCollecion = noteCollecion;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public Integer getNotebookId() {
        return notebookId;
    }

    public void setNotebookId(Integer notebookId) {
        this.notebookId = notebookId;
    }

    public String getNotebookName() {
        return notebookName;
    }

    public void setNotebookName(String notebookName) {
        this.notebookName = notebookName == null ? null : notebookName.trim();
    }

    public Short getNbValid() {
        return nbValid;
    }

    public void setNbValid(Short nbValid) {
        this.nbValid = nbValid;
    }

    @Override
    public String toString() {
        return "NoteBook{" +
                "notebookId=" + notebookId +
                ", notebookName='" + notebookName + '\'' +
                ", nbValid=" + nbValid +
                ", noteTitle='" + noteTitle + '\'' +
                ", noteContent='" + noteContent + '\'' +
                ", notenValid=" + notenValid +
                ", noteCollecion=" + noteCollecion +
                '}';
    }
}