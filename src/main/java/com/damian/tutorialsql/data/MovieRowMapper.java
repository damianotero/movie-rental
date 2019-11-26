package com.damian.tutorialsql.data;

import com.damian.tutorialsql.logic.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRowMapper implements RowMapper<Movie> {

    @Override
    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
        Movie movie = new Movie();

        movie.setId(rs.getInt("m_id"));
        movie.setTitle(rs.getString("m_title"));
        movie.setMainActor(rs.getString("m_main_actor"));
        movie.setYear(rs.getInt("m_year"));
        movie.setGenre(rs.getString("m_genre"));
        movie.setPrice(rs.getDouble("m_price"));
        movie.setPoster(rs.getString("m_poster"));

        return movie;
    }

}
