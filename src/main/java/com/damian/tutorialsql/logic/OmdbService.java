package com.damian.tutorialsql.logic;

import com.damian.tutorialsql.data.OmdbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OmdbService {

    @Autowired
    private OmdbRepository omdbRepository;

    public MovieResults getMovieResults(String title) {
        return omdbRepository.getMovieResults(title);
    }

    public List<OmdbMovie> getOmdbMovies(String title) {
        return omdbRepository.getOmdbMovies(title);
    }
}