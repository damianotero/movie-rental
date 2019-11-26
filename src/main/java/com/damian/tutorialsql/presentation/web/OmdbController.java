package com.damian.tutorialsql.presentation.web;

import com.damian.tutorialsql.logic.OmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/omdb")
public class OmdbController {

    @Autowired
    private OmdbService omdbService;

    @GetMapping("/home")
    public String omdbHome(Model model){
        return "omdbHome";
    }

    @GetMapping("/search")
    public String omdbSearch(Model model, @RequestParam String title){
        model.addAttribute("omdbMovieList", omdbService.getOmdbMovies(title));
        return "listOmdbMovies";
    }
}
