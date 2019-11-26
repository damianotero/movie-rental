package com.damian.tutorialsql.presentation.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("nombre", "Damian");
        return "home";
    }

    @GetMapping("/rentMenu")
    public String rentMenu(Model model){
        return "rentMenu";
    }

    @GetMapping ("/login")
    public String login(Model model){
        return "login";
    }


}
