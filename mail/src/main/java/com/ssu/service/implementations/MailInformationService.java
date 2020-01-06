package com.ssu.service.implementations;

import com.ssu.model.Mail;
import com.ssu.model.MailInformation;
import com.ssu.model.UsersAndMails;
import com.ssu.service.interfaces.UserServiceInterface;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Primary
public class MailInformationService {

    private UserServiceInterface userService;

    public MailInformationService(UserServiceInterface userService){
        this.userService = userService;
    }

    public ArrayList<Mail> getMails(MailInformation mailInformation){
        ArrayList<Mail> result = new ArrayList<>();
        ArrayList<String> emails = mailInformation.getToEmails();

        for (int i = 0; i < emails.size(); i++) {
            Mail mail = new Mail();
            mail.setTheme(mailInformation.getTheme());
            mail.setMessage(mailInformation.getMessage());
            mail.setToId(userService.getEmailId(emails.get(i)));

            result.add(mail);
        }

        return result;
    }

    public ArrayList<UsersAndMails> getUsersAndMails(MailInformation mailInformation, ArrayList<Mail> mails){
        ArrayList<UsersAndMails> result = new ArrayList<>();

        for(int i = 0; i < mails.size(); i++){
            UsersAndMails usersAndMails = new UsersAndMails();
            usersAndMails.setMailId(mails.get(i).getId());
            usersAndMails.setFromId(userService.getEmailId(mailInformation.getFromEmail()));

            result.add(usersAndMails);
        }

        return result;
    }
}
