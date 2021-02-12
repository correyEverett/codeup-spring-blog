package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

    @GetMapping("/post")
    @ResponseBody
    public String indexPage() {
        return "This is and index page!";
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

    @GetMapping("index")
    public String showAllPost(Model model) {

        ArrayList<Post> allPosts = new ArrayList<>();
        Post post1 = new Post("title1", "First Post", 1);
        Post post2 = new Post("title2", "Second Post", 2);

        allPosts.add(post1);
        allPosts.add(post2);

        model.addAttribute("posts", allPosts);

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showIndividualPost(Model model, @PathVariable String id) {
        Post singlePost1 = new Post("title", "body", 1);

        model.addAttribute("post", singlePost1);

        return "posts/show";
    }


}
