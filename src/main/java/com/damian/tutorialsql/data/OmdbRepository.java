package com.damian.tutorialsql.data;

import com.damian.tutorialsql.logic.MovieResults;
import com.damian.tutorialsql.logic.OmdbMovie;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class OmdbRepository {

    public MovieResults getMovieResults(String title){
        RestTemplate restTemplate = new RestTemplate();
        MovieResults movieResults = restTemplate.getForObject("http://www.omdbapi.com/?apikey=8abe9507&s="+title,MovieResults.class);
        return movieResults;

    }
    public List<OmdbMovie> getOmdbMovies(String title){
        RestTemplate restTemplate = new RestTemplate();
        MovieResults movieResults = restTemplate.getForObject("http://www.omdbapi.com/?apikey=8abe9507&s="+title,MovieResults.class);
        List<OmdbMovie> omdbMovieList = movieResults.getSearch();
        return omdbMovieList;
    }

}
