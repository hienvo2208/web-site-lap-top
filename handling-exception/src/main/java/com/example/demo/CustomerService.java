package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CustomerService {
    Customer getCustomer(long id);
    String addCustomer(Customer customer);
    String updateCustomers(Customer customer);

}
