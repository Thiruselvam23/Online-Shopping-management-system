package com.onlineShopping.EprojectController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.onlineShopping.EprojectModel.Cart;
import com.onlineShopping.EprojectService.CartService;


@Controller
public class CartController {
    @Autowired
    private CartService cartService;

	public ResponseEntity<?> addcart(Cart cart) {
        return cartService.addCart(cart);
	}

    public ResponseEntity<List<Cart>> getAllCarts(){
        return ResponseEntity.ok(cartService.getAllCarts());
    }

    public ResponseEntity<?> DeleteCart(Long cartId){
        return cartService.DeleteCart(cartId);
    }
    
}
