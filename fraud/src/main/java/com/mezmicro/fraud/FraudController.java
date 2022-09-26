package com.mezmicro.fraud;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {

    private final FraudCheckService fraudCheckService;

    //TAKEN CARE OF MY ALLARGSCONSTRUCTOR ANNOTATION
//    public FraudController(FraudCheckService fraudCheckService){
//        this.fraudCheckService = fraudCheckService;
//    }

    @GetMapping(path = "customerId")
    public FraudCheckReponse isFraudster(@PathVariable("customerId") Integer customerID){
        boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerID);

        return new FraudCheckReponse(isFraudulentCustomer);
    }

}
