package com.damian.tutorialsql.data;

import com.damian.tutorialsql.logic.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CustomerRowMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();

        customer.setId(rs.getInt("c_id"));
        customer.setName(rs.getString("c_name"));
        customer.setAddress(rs.getString("c_address"));
        return customer;
    }
}
