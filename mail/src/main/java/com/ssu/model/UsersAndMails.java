package com.ssu.model;

import javax.persistence.*;

@Entity
@Table(name = "users_and_mails")
public class UsersAndMails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "from_id")
    private Integer fromId;

    @Column(name = "mail_id")
    private Integer mailId;

    public UsersAndMails(){}

    public UsersAndMails(Integer id, Integer fromId, String toId, Integer mailId){
        this.id = id;
        this.fromId = fromId;
        this.mailId = mailId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public Integer getMailId() {
        return mailId;
    }

    public void setMailId(Integer mailId) {
        this.mailId = mailId;
    }
}
