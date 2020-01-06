package com.ssu.controller;

import com.ssu.model.SignInInfo;
import com.ssu.model.User;
import com.ssu.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private UserServiceInterface userService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public UserController(UserServiceInterface userService){
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public void addUser(@RequestBody User user){
        userService.add(user);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
    public User getById(@PathVariable int id){
        return (User)userService.getById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/user")
    public void updateUser(@RequestBody User user){
        userService.update(user);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<User> getAll(){
        return userService.getAll();
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "/users/search")
    public void searchBySignInInfo(@RequestBody SignInInfo signInInfo){
        List<User> users = new ArrayList<>();
        users.addAll(userService.getAll());
        Integer id = null;

        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getLogin().equals(signInInfo.getLogin()) && users.get(i).getPass().equals(signInInfo.getPass())){
                id = users.get(i).getId();
                break;
            }
        }

        String url = "http://localhost:8090/signin/getuserid";
        restTemplate.postForObject(url, id, Integer.class);
    }
}
