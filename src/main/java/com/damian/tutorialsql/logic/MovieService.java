package com.damian.tutorialsql.logic;

import com.damian.tutorialsql.data.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> searchByGenre(String genre) {
        return movieRepository.searchByGenre(genre);
    }

    public List<Movie> searchByYear(int year) {
        return movieRepository.searchByYear(year);
    }

    public List<Movie> searchByMainActor(String mainActor) {
        return movieRepository.searchByMainActor(mainActor);
    }

    public List<Movie> searchByTitle(String title) {
        return movieRepository.searchByTitle(title);
    }

    public Movie searchById(int id) {
        return movieRepository.searchById(id);
    }

    public void deleteMovie(int id) {
        movieRepository.deleteMovie(id);
    }

    public void addMovie(Movie movie) {
        movieRepository.addMovie(movie);
    }

    public List<Movie> getMovies() {
        return movieRepository.getMovies();
    }

    public void changePrice(int id, double newPrice){
        movieRepository.changePrice(id, newPrice);
    }
}
