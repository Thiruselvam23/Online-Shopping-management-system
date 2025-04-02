package com.onlineShopping.EprojectController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.onlineShopping.EprojectModel.User;
import com.onlineShopping.EprojectService.UserService;

@Service
public class UserController {
	@Autowired
	private UserService user;
	private String u;
	
	public ResponseEntity<?> setUser(User user2) {
		
		if (user2.getPassword() == null || ((String) user2.getPassword()).isEmpty()) {
	        return ResponseEntity.badRequest().body("Password is required!");
	    }
	    System.out.println("Received User: " + user2);
	    if (user2.getEmail() == null || ((String) user2.getEmail()).isEmpty()) {
	        return ResponseEntity.badRequest().body("Email is required!");
	    }
	    if (user2.getPhoneNumber() == null || user2.getPhoneNumber().isEmpty()) {
	        return ResponseEntity.badRequest().body("Phone number is required!");
	    }
		user.setUser(user2);
		return ResponseEntity.ok(user2);
	}

	public ResponseEntity<?> verifyUser(String vendorname, String password){
		System.out.println(password+"  "+vendorname);
         Optional<User> User =user.verifyUser(vendorname, password);

        if(User.isPresent()){
		   u= User.get().getId();
           return ResponseEntity.ok("user verified");
		} 
                 
        return ResponseEntity.status(401).body("Invalid vendor name or password");
    }
    
    public ResponseEntity<?> verifyUserId( String userId) {
        Optional<User> User = user.verifyUserid(userId);
        if (User.isPresent()) {
            return ResponseEntity.ok().body("{\"exists\": true}");
        }
        return ResponseEntity.ok().body("{\"exists\": false}");
    }

	public ResponseEntity<?> getUserId() {
		System.err.println("user cont :"+u);
    	if (u == null || u.isEmpty()) {
        	return ResponseEntity.badRequest().body("No user is logged in.");
    	}
    	return ResponseEntity.ok(u);
	}

	public User GetUserDetials(String userId){
		return user.GetUserDetials(userId);
	}
	
}
