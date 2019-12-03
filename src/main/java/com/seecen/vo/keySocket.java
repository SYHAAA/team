package com.seecen.vo;

import javax.websocket.Session;

public class keySocket {
    private Session session;
    private Integer userId;

    public keySocket(){

    }
    public keySocket(Session session, Integer userId) {
        this.session = session;
        this.userId = userId;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
