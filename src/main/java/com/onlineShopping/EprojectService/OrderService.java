package com.onlineShopping.EprojectService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineShopping.EprojectModel.Order;
import com.onlineShopping.EprojectRepo.OrderRepo;


@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;

    public ResponseEntity<?> SetOrder(Order order){
        orderRepo.save(order);
        return ResponseEntity.ok(order);
    }
    
    public ResponseEntity<List<Order>> getOrderByuserId(String userId){
        List<Order> orders = orderRepo.findAll();
        List<Order> userOrders = new ArrayList<Order>();
        String name;
        for (int i=0 ; i<orders.size();i++){
            name=orders.get(i).getUserId();
            System.out.println(name+"user id is"+userId+"order :"+orders.get(i));

            if (name.equals(userId)) {
                userOrders.add(orders.get(i));
                System.out.println("looporder :"+orders.get(i));
            }
        }
        return ResponseEntity.ok(userOrders);
    }
}
