package com.onlineShopping.EprojectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.onlineShopping.EprojectModel.Payment;
import com.onlineShopping.EprojectRepo.PaymentRepo;

@Service
public class PaymentService {
    
    @Autowired
    private PaymentRepo paymentRepo;

    public ResponseEntity<?> setPayment(Payment payment){
        paymentRepo.save(payment);
        return ResponseEntity.ok(payment);
    }
}
