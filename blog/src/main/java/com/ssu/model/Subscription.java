package com.ssu.model;

import javax.persistence.*;

@Entity
@Table(name = "subscription")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "creator_id")
    private Integer creatorId;

    @Column(name = "subscriber_id")
    private Integer subscriberId;

    public Subscription(){}

    public Subscription(Integer id, Integer creatorId, Integer subscriberId){
        this.id = id;
        this.creatorId = creatorId;
        this.subscriberId = subscriberId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Integer getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(Integer subscriberId) {
        this.subscriberId = subscriberId;
    }
}
