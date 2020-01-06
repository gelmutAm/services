package com.ssu.controller;

import com.ssu.model.MailInformation;
import com.ssu.model.Post;
import com.ssu.model.UserAndSession;
import com.ssu.service.implementations.MailInformationService;
import com.ssu.service.interfaces.PostServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class PostController {

    private PostServiceInterface postService;
    private MailInformationService mailInformationService;

    @Autowired
    private RestTemplate restTemplate;

    //private HttpSession httpSession;

    @Autowired
    public PostController(PostServiceInterface postService, MailInformationService mailInformationService) {
        this.postService = postService;
        this.mailInformationService = mailInformationService;
    }

    /*@GetMapping(value = "/session")
    public void setHttpSession() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8090/httpsession";

        this.httpSession = restTemplate.getForEntity(url, HttpSession.class).getBody();
    }

    @GetMapping(value = "/session/{sessionId}")
    public UserAndSession getUserAndSession(@PathVariable(name = "sessionId") String sessionId){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8090/session/" + sessionId;

        return restTemplate.getForEntity(url, UserAndSession.class).getBody();
    }*/

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "/post")
    public void addPost(@RequestBody Post post){
        String url = "http://localhost:8090/sessionuser/" + post.getUserId();

        UserAndSession userAndSession = restTemplate.getForEntity(url, UserAndSession.class).getBody();

        if(userAndSession != null) {
            postService.add(post);

            //RestTemplate restTemplate1 = new RestTemplate();
            url = new String("http://localhost:8080/mail?from=blog");
            restTemplate.postForEntity(url, mailInformationService.getMailInformation(post), MailInformation.class);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/post/{id}")
    public Post getPostById(@PathVariable Integer id){
        return (Post) postService.getById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/post")
    public void updatePost(@RequestBody Post post){
        postService.update(post);
    }

    @RequestMapping(method = RequestMethod.POST, value = "post/{id}")
    public void deletePost(@PathVariable int id){
        postService.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/posts")
    public List<Post> getAll(){
        return postService.getAll();
    }
}
