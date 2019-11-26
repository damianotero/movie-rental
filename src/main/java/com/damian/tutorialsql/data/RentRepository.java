package com.damian.tutorialsql.data;

import com.damian.tutorialsql.logic.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RentRepository {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public void rentMovie(Rent rent){
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("customerId", rent.getCustomer_id())
                .addValue("movieId", rent.getMovie_id())
                .addValue("rentDays", rent.getRentDays())
                .addValue("totalPrice", rent.getPrice())
                .addValue("date", rent.getDate());

        jdbcTemplate.update("insert into rents (r_date, r_c_id, r_m_id, r_days, r_price) values (:date, :customerId, :movieId, :rentDays, :totalPrice);"
                , namedParameters);
    }

    public List<Rent> getRents(){
        return jdbcTemplate.query("select * from rents;", new RentRowMapper());
    }

    public List<Rent> getRentsByCustomer(int id){
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("customerId", id);

        return jdbcTemplate.query("select * from rents where r_c_id= :customerId;",namedParameters, new RentRowMapper());
    }

    public List<Rent> getRentsOfMovie(int id){
        SqlParameterSource namedParameters= new MapSqlParameterSource()
                .addValue("movieId", id);

        return jdbcTemplate.query("select * from rents where r_m_id= :movieId;",namedParameters, new RentRowMapper());
    }

}
