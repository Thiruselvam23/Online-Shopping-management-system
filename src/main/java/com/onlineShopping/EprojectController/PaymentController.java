package com.onlineShopping.EprojectController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.onlineShopping.EprojectModel.Payment;
import com.onlineShopping.EprojectService.PaymentService;

@Controller
public class PaymentController {
    
    @Autowired
    private PaymentService paymentService;

    public ResponseEntity<?> setPayment(Payment payment){
        return paymentService.setPayment(payment);
    }
}
