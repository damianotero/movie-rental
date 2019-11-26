package com.damian.tutorialsql.presentation.api;

import com.damian.tutorialsql.logic.Movie;
import com.damian.tutorialsql.logic.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MoviesRestController {


    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> listMovies(){
        return movieService.getMovies();
    }

}
