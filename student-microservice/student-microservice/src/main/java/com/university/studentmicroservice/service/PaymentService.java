package com.university.studentmicroservice.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.studentmicroservice.model.Payment;
import com.university.studentmicroservice.repository.PaymentRepository;


@Service
public class PaymentService {

    @Autowired
    public PaymentRepository paymentRepository;

    public Payment addCreditCard(Payment Card){
        return paymentRepository.save(Card);
    }

//    public CreditCard getCreditCard(Long creditCardId){
//        return creditCardRepository.findById(creditCardId);
//    }

}
