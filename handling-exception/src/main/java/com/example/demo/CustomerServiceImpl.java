package com.example.demo;

import com.example.demo.exception.CustomerAlreadyExistsException;
import com.example.demo.exception.NoSuchCustomerExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomer(long id) {
        return customerRepository.findById(id).orElseThrow(
                ()-> new NoSuchCustomerExistsException(
                        "NO CUSTOMER PRESENT WITH ID = " + id)
                );

    }

    @Override
    public String addCustomer(Customer customer) {
        Customer exitsCustomer = customerRepository.findById(customer.getId()).orElse(null);
        if(exitsCustomer==null){
            customerRepository.save(customer);
            return "Customer added successfully";
        }else{
            throw new CustomerAlreadyExistsException("Customer already exists!!");
        }

    }

    @Override
    public String updateCustomers(Customer customer) {
        Customer exitsCustomer = customerRepository.findById(customer.getId()).orElse(null);
        if(exitsCustomer==null){
             throw new NoSuchCustomerExistsException( "No Such Customer exists!!");
        }else{
            exitsCustomer.setName(customer.getName());
            exitsCustomer.setAddress(customer.getAddress());
            customerRepository.save(exitsCustomer);
            return "Record updated Successfully";
        }
    }
}
