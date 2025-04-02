package com.onlineShopping.EprojectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.onlineShopping.EprojectModel.Address;
import com.onlineShopping.EprojectRepo.AddressRepo;

@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;

    public ResponseEntity<?> setAddress(Address address){
        addressRepo.save(address);
        return ResponseEntity.ok(address);
    }
}
