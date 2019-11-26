package com.damian.tutorialsql.data;

import com.damian.tutorialsql.logic.Movie;
import com.damian.tutorialsql.logic.MovieResults;
import com.damian.tutorialsql.logic.OmdbMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class MovieRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<Movie> getMovies() {
        return jdbcTemplate.query("select * from movies;", new MovieRowMapper());
    }

    public Movie searchById(int id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        List<Movie> movies = jdbcTemplate.query("select * from movies where m_id = :id ;", namedParameters, new MovieRowMapper());
        return movies.get(0);
    }

    public List<Movie> searchByTitle(String title) {
        String finalName= "%" + title.trim() + "%";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("title", finalName);
        return jdbcTemplate.query("select * from movies where m_title like :title;", namedParameters, new MovieRowMapper());
    }

    public List<Movie> searchByMainActor(String mainActor) {
        String finalName= "%" + mainActor.trim() + "%";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("mainActor", finalName);
        return jdbcTemplate.query("select * from movies where m_main_actor like  :mainActor ;", namedParameters, new MovieRowMapper());
    }

    public List<Movie> searchByYear(int year) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("year", year);

        return jdbcTemplate.query("select * from movies where m_year= :year ;", namedParameters, new MovieRowMapper());
    }

    public List<Movie> searchByGenre(String genre) {
        String finalName= "%" + genre.trim() + "%";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("genre", finalName);

        return jdbcTemplate.query("select * from movies where m_genre like :genre ;",namedParameters, new MovieRowMapper());
    }

    public void addMovie(Movie movie) {
        RestTemplate restTemplate = new RestTemplate();
        MovieResults movieResults = restTemplate.getForObject("http://www.omdbapi.com/?apikey=8abe9507&s="+movie.getTitle(),MovieResults.class);
        OmdbMovie omdbMovie = movieResults.getSearch().get(0);
        movie.setPoster(omdbMovie.getPoster());
        movie.setYear(Integer.valueOf(omdbMovie.getYear()));
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("title", movie.getTitle())
                .addValue("mainActor", movie.getMainActor())
                .addValue("year", movie.getYear())
                .addValue("genre", movie.getGenre())
                .addValue("price",movie.getPrice())
                .addValue("poster", movie.getPoster());
        jdbcTemplate.update("insert into movies (m_title, m_main_actor, m_year, m_genre, m_price, m_poster) values ( :title , :mainActor , :year , :genre, :price, :poster);", namedParameters);
    }

    public void deleteMovie(int id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        jdbcTemplate.update("delete from movies where m_id= :id ;", namedParameters);
    }

    public void changePrice(int id, double newPrice) {
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", id)
                .addValue("newPrice", newPrice)
                ;
        jdbcTemplate.update("update movies set m_price = :newPrice where m_id= :id;", namedParameters);
    }


}
