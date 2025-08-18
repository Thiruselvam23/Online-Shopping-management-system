package com.onlineShopping.EprojectRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineShopping.EprojectModel.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment,Long>{
}
