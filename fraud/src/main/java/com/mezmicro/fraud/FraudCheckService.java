package com.mezmicro.fraud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {

    private  final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    //TAKEN CARE OF MY ALLARGSCONSTRUCTOR ANNOTATION
//    public FraudCheckService(FraudCheckHistoryRepository fraudCheckHistoryRepository){
//        this.fraudCheckHistoryRepository = fraudCheckHistoryRepository;
//    }

    public boolean isFraudulentCustomer(Integer customerId){
        //todo fraud check system

        //log a fraud check
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
