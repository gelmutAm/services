package com.ssu.controller;

import com.ssu.model.Subscription;
import com.ssu.service.interfaces.SubscriptionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubscriptionController {

    private SubscriptionServiceInterface subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionServiceInterface subscriptionService){
        this.subscriptionService = subscriptionService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/subscription")
    public void addSubscription(@RequestBody Subscription subscription){
        subscriptionService.add(subscription);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/subscription/{id}")
    public Subscription getSubscriptionById(@PathVariable int id){
        return (Subscription) subscriptionService.getById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/subscription")
    public void updateSubscription(Subscription subscription){
        subscriptionService.update(subscription);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/subscription/{id}")
    public void delete(@PathVariable int id){
        subscriptionService.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/subscriptions")
    public List<Subscription> getAll(){
        return (List<Subscription>) subscriptionService.getAll();
    }
}
