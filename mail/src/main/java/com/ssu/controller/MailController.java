package com.ssu.controller;

import com.ssu.model.Mail;
import com.ssu.model.MailInformation;
import com.ssu.model.UsersAndMails;
import com.ssu.service.implementations.MailInformationService;
import com.ssu.service.interfaces.MailServiceInterface;
import com.ssu.service.interfaces.UsersAndMailsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MailController {

    private MailServiceInterface mailService;
    private UsersAndMailsServiceInterface usersAndMailsService;
    private MailInformationService mailInformationService;

    @Autowired
    public MailController(MailServiceInterface mailService, UsersAndMailsServiceInterface usersAndMailsService,
                          MailInformationService mailInformationService){
        this.mailService = mailService;
        this.usersAndMailsService = usersAndMailsService;
        this.mailInformationService = mailInformationService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/mail")
    public void addMailFrom(@RequestBody MailInformation mailInformation, @RequestParam(required = true) String from){
        if(from.equals("blog")) {
            ArrayList<Mail> mails = mailInformationService.getMails(mailInformation);
            for (int i = 0; i < mails.size(); i++) {
                mailService.add(mails.get(i));
            }

            ArrayList<UsersAndMails> usersAndMails = mailInformationService.getUsersAndMails(mailInformation, mails);
            for (int i = 0; i < usersAndMails.size(); i++) {
                usersAndMailsService.add(usersAndMails.get(i));
            }
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addmail")
    public void addMail(@RequestBody Mail mail){
        mailService.add(mail);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/mail/{id}")
    public Mail getMailById(@PathVariable Integer id){
        return (Mail) mailService.getById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/mails")
    public List<Mail> getAll(){
        return mailService.getAll();
    }
}
