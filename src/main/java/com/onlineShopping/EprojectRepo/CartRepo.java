package com.onlineShopping.EprojectRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineShopping.EprojectModel.Cart;

@Repository
public interface CartRepo extends JpaRepository <Cart, Long>{
}
