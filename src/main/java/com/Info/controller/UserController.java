package com.Info.controller;// UserController.java
import com.Info.model.entity.MyUser;
import com.Info.repository.UserRepository;
import com.Info.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String allTables() {
        return "all_tables";
    }
//    @GetMapping()
//    public String getAllUsers(Model model) {
//        Iterable<MyUser> users = userRepository.findAll();
//        model.addAttribute("users", users);
//        return "all_tables";
//    }

    @PostMapping()
    public String add(@RequestParam String text, Model model){
        MyUser user = new MyUser(text);
        userRepository.save(user);
        return "redirect:/";
    }
}
