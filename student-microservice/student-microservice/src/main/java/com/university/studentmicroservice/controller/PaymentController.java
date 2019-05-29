package com.university.studentmicroservice.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.university.studentmicroservice.model.Payment;
import com.university.studentmicroservice.service.PaymentService;

@CrossOrigin
@RestController
@RequestMapping("/creditCard")
public class PaymentController {

    @Autowired
    public PaymentService paymentService;

    @PostMapping(value = "/save")
    public Payment createCreditCard(@RequestBody  Payment card){
    return paymentService.addCreditCard(card);
    }

}
