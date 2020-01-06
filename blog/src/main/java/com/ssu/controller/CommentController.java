package com.ssu.controller;

import com.ssu.model.Comment;
import com.ssu.service.interfaces.CommentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CommentController {

    private CommentServiceInterface commentService;

    @Autowired
    public CommentController(CommentServiceInterface commentService){
        this.commentService = commentService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/comment")
    public void addComment(@RequestBody Comment comment){
        commentService.add(comment);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/comment/{id}")
    public Comment getCommentById(@PathVariable Integer id){
        return (Comment) commentService.getById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/comment")
    public void updateComment(@RequestBody Comment comment){
        commentService.update(comment);
    }

    @RequestMapping(method = RequestMethod.POST, value = "comment/{id}")
    public void deleteComment(@PathVariable int id){
        commentService.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/comments")
    public List<Comment> getAll(){
        return commentService.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/comments/commentators/{postId}")
    public ArrayList<Integer> getCommentatorsByPostId(@PathVariable Integer postId){
        return (ArrayList<Integer>) commentService.getAllUserId(postId);
    }
}
