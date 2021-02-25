package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositries.PostRepository;
import com.codeup.springblog.repositries.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

    private final PostRepository postsDao;
    private final UserRepository userDao;

    public PostController(PostRepository postsDao, UserRepository userDao) {
        this.postsDao = postsDao;
        this.userDao = userDao;
    }

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
    public String showAllPosts(Model model) {

        ArrayList<Post> allPosts = new ArrayList<>();
        Post post1 = new Post(1, "title1", "First Post");
        Post post2 = new Post(2, "title2", "Second Post");

        allPosts.add(post1);
        allPosts.add(post2);

        model.addAttribute("posts", allPosts);

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showIndividualPost(Model model, @PathVariable String id) {
        Post singlePost1 = new Post(1,"title" , "body");

        model.addAttribute("post", singlePost1);

        return "posts/show";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, @RequestParam String title, @RequestParam String body) {
        Post post = new Post(
                id,
                title,
                body
        );
        postsDao.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id){
        postsDao.deleteById(id);
        return "redirect:/posts";
    }


}
