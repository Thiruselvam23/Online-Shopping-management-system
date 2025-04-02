package com.onlineShopping.EprojectRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineShopping.EprojectModel.Order;

public interface OrderRepo extends JpaRepository<Order,Long>{
}
