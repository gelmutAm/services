package com.ssu.model;

import javax.persistence.*;

public class UserAndSession {

    private Integer id;

    private Integer userId;

    private String sessionId;

    public UserAndSession(){}

    public UserAndSession(Integer id, Integer userId, String sessionId){
        this.id = id;
        this.userId = userId;
        this.sessionId = sessionId;
    }

    public UserAndSession(Integer userId, String sessionId){
        this.userId = userId;
        this.sessionId = sessionId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
