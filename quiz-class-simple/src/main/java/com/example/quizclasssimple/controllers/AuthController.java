package com.example.quizclasssimple.controllers;

import com.example.quizclasssimple.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AuthController {
    @Autowired
    UserService userService;
//    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @RequestMapping("/web/login")
    public String customerLogin(@RequestParam(required = false) String message, Model model) {
        if (message != null && !message.isEmpty()) {
            if (message.equals("error")) {
                model.addAttribute("message", "Login Failed!");
            } else if (message.equals("signup")) {
                model.addAttribute("message", "Signup Success!");
            }
        } else
            model.addAttribute("message", "");
        return "web/login";
    }

}
