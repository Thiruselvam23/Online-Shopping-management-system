package com.onlineShopping.EprojectController;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.onlineShopping.EprojectModel.Vendor;
import com.onlineShopping.EprojectService.VendorService;

@Controller
public class VendorController {
    @Autowired
    private VendorService vendorService;


    public ResponseEntity<?> setVendor(Vendor vendor) {
		if (vendor.getPassword() == null || ((String) vendor.getPassword()).isEmpty()) {
	        return ResponseEntity.badRequest().body("Password is required!");
	    }
	    System.out.println("Received User: " + vendor);
	    if (vendor.getEmail() == null || ((String) vendor.getEmail()).isEmpty()) {
	        return ResponseEntity.badRequest().body("Email is required!");
	    }
	    if (vendor.getPhoneNumber() == null || vendor.getPhoneNumber().isEmpty()) {
	        return ResponseEntity.badRequest().body("Phone number is required!");
	    }
		if (vendor.getVendorid() == null || vendor.getVendorid().isEmpty()) {
	        return ResponseEntity.badRequest().body("vendor id is required!");
	    }
		vendorService.addVendor(vendor);
		return ResponseEntity.ok(vendor);
	}

    public ResponseEntity<?> verifyVendor(String vendorname, String password){
		System.out.println(password+"  "+vendorname);
         Optional<Vendor> vendor = vendorService.verifyVendor(vendorname, password);

        return vendor.isPresent() ? 
                ResponseEntity.ok("Vendor verified") : 
                ResponseEntity.status(401).body("Invalid vendor name or password");
    }

	public ResponseEntity<?> verifyVerdorId( String userId) {
        Optional<Vendor> Vendor = vendorService.verifyvendorID(userId);
        if (Vendor.isPresent()) {
            return ResponseEntity.ok().body("{\"exists\": true}");
        }
        return ResponseEntity.ok().body("{\"exists\": false}");
    }
}
