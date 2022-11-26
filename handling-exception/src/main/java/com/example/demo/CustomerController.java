package com.example.demo;

import com.example.demo.exception.CustomerAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/getCustomer/{id}")
    public Customer getCustomer(@PathVariable("id") long id){
        return customerService.getCustomer(id);
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @PutMapping("/updateCustomer")
    public String updateCustomer(@RequestBody  Customer customer){
        return customerService.updateCustomers(customer);
    }


}
