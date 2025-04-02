package com.onlineShopping.EprojectService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.onlineShopping.EprojectModel.Vendor;
import com.onlineShopping.EprojectRepo.VendorRepo;

@Service
public class VendorService {

    @Autowired
    Optional<Vendor> vendor;

    @Autowired
    VendorRepo vendorRepo;

    public void addVendor(Vendor vendor){
        vendorRepo.save(vendor);
    }

    public Optional<Vendor> verifyVendor(String vendorName, String password) {
        Optional<Vendor> vendor = vendorRepo.findById(vendorName);
        
        if (vendor.isPresent() && vendor.get().getPassword().equals(password)) {
            return vendor;
        }
        return Optional.empty();
    }

    public Optional<Vendor> verifyvendorID(String VendorID) {
        Optional<Vendor> vendor= vendorRepo.findById(VendorID);
        System.out.println(" from userService"+VendorID);
        if (vendor.isPresent()) {
            return vendor;
        }
        return Optional.empty();
    }
}
