package com.mezmicro.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
//public record CustomerService(CustomerRepository customerRepository) {

    private final CustomerRepository customerRepository;

    //TAKEN CARE OF MY ALLARGSCONSTRUCTOR ANNOTATION
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        //todo: check if email is valid
        //todo: check if email is not taken

        //todo: store customer in db
        customerRepository.save(customer);
    }
}
