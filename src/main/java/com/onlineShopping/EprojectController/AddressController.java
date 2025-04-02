package com.onlineShopping.EprojectController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.onlineShopping.EprojectModel.Address;
import com.onlineShopping.EprojectService.AddressService;

@Controller
public class AddressController {
    
    @Autowired
    private AddressService addressService;

    public ResponseEntity<?> setAddress(Address address){
        
        return addressService.setAddress(address);
    }
}
