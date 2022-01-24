package com.example.spring_exceptionhandling.repository;

import com.example.spring_exceptionhandling.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
