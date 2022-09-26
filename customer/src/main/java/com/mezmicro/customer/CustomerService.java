package com.mezmicro.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {
//public record CustomerService(CustomerRepository customerRepository) {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

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
//        customerRepository.save(customer);

        //save and flush give us access to customer info like id
        customerRepository.saveAndFlush(customer);
        //todo: check if fraudster
        FraudCheckReponse fraudCheckReponse = restTemplate.getForObject("http://localhost:8081/api/v1/fraud-check/{customerId}", FraudCheckReponse.class, customer.getId());
        if(fraudCheckReponse.isFraudster()){
            throw new IllegalStateException("fraudster");
        }

        //todo: send notification
    }
}
