package com.onlineShopping.EprojectService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.onlineShopping.EprojectModel.Order;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    public ResponseEntity<?> setOrder(Order order){
        return orderService.SetOrder(order);
    }

    public ResponseEntity<List<Order>> getOrderByuserId(String userId){
        System.out.println("bvfbvu  "+orderService.getOrderByuserId(userId));
        return orderService.getOrderByuserId(userId);
    }
}
