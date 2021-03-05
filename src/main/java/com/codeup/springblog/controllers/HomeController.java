package com.codeup.springblog.controllers;

import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.security.crypto.password.PasswordEncoder;

@Controller
public class HomeController {

    private final UserRepository usersDao;
    private final PostRepository postsDao;
    private final PasswordEncoder encoder;

    public HomeController(UserRepository usersDao, PostRepository postsDao, PasswordEncoder encoder) {
        this.usersDao = usersDao;
        this.postsDao = postsDao;
        this.encoder = encoder;
    }


    @GetMapping("/")
    public String home(){
        return "redirect:login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String goToPosts(){
        return "redirect:/posts";
    }

    @GetMapping("/sign-up")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "sign-up";
    }

    @PostMapping("/signup")
    public String createUser(@ModelAttribute User user){
        String password = user.getPassword();
        String hash = encoder.encode(password);
        user.setPassword(hash);
        usersDao.save(user);
        return "redirect:/login";
    }








}
