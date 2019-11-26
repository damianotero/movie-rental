package com.damian.tutorialsql.presentation.web;

import com.damian.tutorialsql.logic.Movie;
import com.damian.tutorialsql.logic.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/home")
    public String movies(Model model){
        return "movies";
    }

    @GetMapping("/list")
    public String listMovies(Model model){

        model.addAttribute("movieList", movieService.getMovies());

        return "listMovies";
    }

    @GetMapping("/search")
    public String searchMovieByName(Model model, @RequestParam String title){

        model.addAttribute("movieList", movieService.searchByTitle(title));

        return "listMovies";
    }

    @GetMapping("/addMovie")
    public String addMovieForm(Model model){
        model.addAttribute("movie", new Movie());
        return "addMovie";
    }

    @PostMapping("/addMovie")
    public String addMovieSubmit(@ModelAttribute Movie movie, BindingResult errors, Model model) {

        movieService.addMovie(movie);
        model.addAttribute("movieList", movieService.getMovies());
        return "listMovies";
    }

    @GetMapping("/deleteMovie")
    public String deleteMovieForm(Model model){
        model.addAttribute("movie", new Movie());
        model.addAttribute("movieList", movieService.getMovies());

        return "deleteMovie";
    }

    @PostMapping("/deleteMovie")
    public String deleteMovieSubmit(@ModelAttribute Movie movie, BindingResult errors, Model model){
        movieService.deleteMovie(movie.getId());
        model.addAttribute("movieList", movieService.getMovies());
        return "deleteMovie";
    }

    @GetMapping("/changePrice")
    public String changePriceForm(Model model){
        model.addAttribute("movie", new Movie());
        model.addAttribute("movieList", movieService.getMovies());
        return "changeMoviePrice";
    }

    @PostMapping("/changePrice")
    public String changePriceSubmit(@ModelAttribute Movie movie, BindingResult errors, Model model){
        movieService.changePrice(movie.getId(), movie.getPrice());
        model.addAttribute("movieList", movieService.getMovies());
        return "changeMoviePrice";
    }

}

