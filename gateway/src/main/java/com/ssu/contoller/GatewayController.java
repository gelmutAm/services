package com.ssu.contoller;

import com.ssu.model.SignInInfo;
import com.ssu.model.User;
import com.ssu.model.UserAndSession;
import com.ssu.service.interfaces.UserAndSessionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;

@RestController
public class GatewayController {

    private HttpSession httpSession;

    private UserAndSessionServiceInterface userAndSessionService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public GatewayController(UserAndSessionServiceInterface userAndSessionService){
        this.userAndSessionService = userAndSessionService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public void SignUp(@RequestBody User user){
        String url = "http://localhost:8888/user";

        restTemplate.postForEntity(url, user, User.class);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signin")
    public void SignIn(@RequestBody SignInInfo signInInfo){
        String url = "http://localhost:8888/users/search";
        restTemplate.postForEntity(url, signInInfo, SignInInfo.class);
    }

    @PostMapping(value = "/signin/getuserid")
    public void addUserId(@RequestBody Integer id, HttpSession httpSession) {
        System.out.println(httpSession.getId());
        this.httpSession = httpSession;
        if (userAndSessionService.getByUserId(id) != null) {
            System.out.println("You don't need to logging in");
        } else {
            userAndSessionService.add(new UserAndSession(id, httpSession.getId()));
        }
    }

    @GetMapping(value = "/session/{id}")
    public UserAndSession getSessionById(@PathVariable(name = "id") Integer id){
        return (UserAndSession) userAndSessionService.getById(id);
    }

    @GetMapping(value = "/sessionuser/{userId}")
    public UserAndSession getSessionByUserId(@PathVariable(name = "userId") Integer userId){
        return (UserAndSession) userAndSessionService.getByUserId(userId);
    }

    @PostMapping(value = "/signout")
    public void SignOut(){
        userAndSessionService.deleteBySessionId(httpSession.getId());
    }

    @PostMapping(value = "/session/{id}")
    public void deleteSessionById(@PathVariable(name = "id") Integer id){
        userAndSessionService.deleteById(id);
    }

    @GetMapping(value = "/httpsession")
    public HttpSession getHttpSession(){
        return this.httpSession;
    }
}
