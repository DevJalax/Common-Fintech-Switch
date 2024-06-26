package com.jalax.payment_gateway.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jalax.payment_gateway.Entity.Customer;
import com.jalax.payment_gateway.Repo.CustomerRepository;

@Service
public class CustomerService {
	
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(Long id) throws Exception {
        return customerRepository.findById(id)
                .orElseThrow(() -> new Exception("Customer not found with id: " + id));
    }

    public Customer getCustomerByEmail(String email) throws Exception {
        return customerRepository.findByEmail(email)
                .orElseThrow(() -> new Exception("Customer not found with email: " + email));
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer) throws Exception {
        Customer customer = getCustomerById(id);
        customer.setName(updatedCustomer.getName());
        customer.setAddress(updatedCustomer.getAddress());
        customer.setPhoneNumber(updatedCustomer.getPhoneNumber());
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) throws Exception {
        Customer customer = getCustomerById(id);
        customerRepository.delete(customer);
    }
}
