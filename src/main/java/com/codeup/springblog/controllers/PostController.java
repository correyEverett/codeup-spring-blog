package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping("/post")
    @ResponseBody
    public String indexPage() {
        return "This is and index page!";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String post(@PathVariable int id) {
        return "You are viewing post #" + id + "!";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String postForm() {
        return "View post form!";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String createPost() {
        return "Create post!";
    }


}
