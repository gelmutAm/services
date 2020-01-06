package com.ssu.service.implementations;

import com.ssu.model.MailInformation;
import com.ssu.model.Post;
import com.ssu.model.User;
import com.ssu.service.interfaces.CommentServiceInterface;
import com.ssu.service.interfaces.SubscriptionServiceInterface;
import com.ssu.service.interfaces.UserServiceInterface;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Primary
public class MailInformationService {

    private UserServiceInterface userService;
    private SubscriptionServiceInterface subscriptionService;

    public MailInformationService(UserServiceInterface userService, SubscriptionServiceInterface subscriptionService){
        this.userService = userService;
        this.subscriptionService = subscriptionService;
    }

    public MailInformation getMailInformation(Post post){
        MailInformation result = new MailInformation();

        result.setTheme("your_blog info");

        Integer creatorId = post.getUserId();
        User user = (User) userService.getById(creatorId);
        result.setMessage(user.getUserName() + " just posted a new message");

        ArrayList<Integer> subscribersIds = subscriptionService.getAllSubscribers(creatorId);
        ArrayList<String> toEmails = new ArrayList<>();
        for(int i = 0; i < subscribersIds.size(); i++){
            user = (User) userService.getById(subscribersIds.get(i));
            String email = user.getEmail();
            toEmails.add(email);
        }

        result.setToEmails(toEmails);

        return result;
    }
}
