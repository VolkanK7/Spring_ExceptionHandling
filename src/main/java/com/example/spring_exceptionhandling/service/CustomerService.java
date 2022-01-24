package com.example.spring_exceptionhandling.service;

import com.example.spring_exceptionhandling.entity.Customer;
import com.example.spring_exceptionhandling.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public List<Customer> findAllCustomer(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long customerId){
        return customerRepository.findById(customerId).get();
    }

    public void deleteCustomer(Long customerId){
        customerRepository.deleteById(customerId);
    }
}
