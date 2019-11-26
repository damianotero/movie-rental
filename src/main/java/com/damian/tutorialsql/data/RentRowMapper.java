package com.damian.tutorialsql.data;

import com.damian.tutorialsql.logic.Rent;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class RentRowMapper implements RowMapper<Rent> {
    @Override
    public Rent mapRow(ResultSet rs, int rowNum) throws SQLException {
        Rent rent = new Rent();

        rent.setId(rs.getInt("r_id"));
        rent.setDate(rs.getDate("r_date"));
        rent.setCustomer_id(rs.getInt("r_c_id"));
        rent.setMovie_id(rs.getInt("r_m_id"));
        rent.setRentDays(rs.getInt("r_days"));
        rent.setPrice(rs.getDouble("r_price"));
        return rent;
    }
}
