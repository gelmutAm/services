package com.ssu.model;

import javax.persistence.*;

@Entity
@Table(name = "users_and_sessions")
public class UserAndSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "session_id")
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
