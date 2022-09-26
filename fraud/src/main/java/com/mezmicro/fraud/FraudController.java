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

    @GetMapping(path = "{customerId}")
    public FraudCheckReponse isFraudster(@PathVariable("customerId") Integer customerId){
        boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);
            log.info("fraud check request for customer {}", customerId);
        return new FraudCheckReponse(isFraudulentCustomer);
    }

}
