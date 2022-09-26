package com.mezmicro.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {

    private final FraudCheckService fraudCheckService;

    //TAKEN CARE OF MY ALLARGSCONSTRUCTOR ANNOTATION
//    public FraudController(FraudCheckService fraudCheckService){
//        this.fraudCheckService = fraudCheckService;
//    }

    @GetMapping(path = "customerId")
    public FraudCheckReponse isFraudster(@PathVariable("customerId") Integer customerID){
        boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerID);
            log.info("fraud check request for customer {}", customerID);
        return new FraudCheckReponse(isFraudulentCustomer);
    }

}
