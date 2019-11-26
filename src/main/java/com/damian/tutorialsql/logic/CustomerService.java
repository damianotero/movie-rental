package com.damian.tutorialsql.logic;


import com.damian.tutorialsql.data.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getCustomers(){
       return customerRepository.getCustomers();
    }

    public List<Customer> searchCustomer(String name){
        return customerRepository.searchCustomer(name);
    }

    public void addCustomer(Customer customer){
        customerRepository.addCustomer(customer);

    }

    public void changeAddress(int id, String newAddress){
        customerRepository.changeAddress(id,newAddress);
    }

    public void deleteCustomer(int id){
        customerRepository.deleteCustomer(id);
    }



}
