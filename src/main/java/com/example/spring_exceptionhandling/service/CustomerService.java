package com.example.spring_exceptionhandling.service;

import com.example.spring_exceptionhandling.entity.Customer;
import com.example.spring_exceptionhandling.exception.CustomerNotFoundException;
import com.example.spring_exceptionhandling.exception.CustomerNotNullException;
import com.example.spring_exceptionhandling.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer){
        if(customer.getName().isBlank() || customer.getName().isEmpty()){
            throw new CustomerNotNullException("Customer must be not null!");
        }
        return customerRepository.save(customer);
    }

    public List<Customer> findAllCustomer(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long customerId){
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        Customer customer = optionalCustomer
                .orElseThrow(() -> new CustomerNotFoundException("Customer id:"+customerId+" not found!"));
        return customer;

    }

    public void deleteCustomer(Long customerId){
        customerRepository.deleteById(customerId);
    }
}
