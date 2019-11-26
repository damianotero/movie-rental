package com.damian.tutorialsql.data;


import com.damian.tutorialsql.logic.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    public List<Customer> getCustomers(){
        return jdbcTemplate.query("select * from customers;", new CustomerRowMapper());
    }

    public List<Customer> searchCustomer(String name){
        String finalName = "%"+ name.trim() + "%";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("name", finalName);
        return  jdbcTemplate.query("select * from customers where c_name like :name;", namedParameters, new CustomerRowMapper());
    }

    public void addCustomer(Customer customer){
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("name", customer.getName())
                .addValue("address", customer.getAddress());
        jdbcTemplate.update("insert into customers (c_name, c_address) values (:name, :address);", namedParameters);
    }

    public void changeAddress (int id, String newAddress){
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", id)
                .addValue("newAddress", newAddress);

        jdbcTemplate.update("update customers set c_address= :newAddress where c_id=:id", namedParameters);
    }

    public void deleteCustomer (int id){
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", id);
        jdbcTemplate.update("delete from customers where c_id= :id", namedParameters);
    }


}
