package com.ssu.controller;

import com.ssu.model.User;
import com.ssu.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserServiceInterface userService;

    @Autowired
    public UserController(UserServiceInterface userService){
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public void addUser(@RequestBody User user){
        userService.add(user);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
    public User getUserById(@PathVariable Integer id){
        return (User) userService.getById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<User> getAll(){
        return userService.getAll();
    }
}
