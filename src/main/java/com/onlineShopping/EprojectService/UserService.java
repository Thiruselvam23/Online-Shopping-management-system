package com.onlineShopping.EprojectService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineShopping.EprojectModel.User;
import com.onlineShopping.EprojectRepo.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userepo ;

	public void setUser(User user2) {
		userepo.save(user2);
		
	}
	
	public Optional<User> verifyUser(String userID, String password) {
        Optional<User> user= userepo.findById(userID);
        
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user;
        }
        return Optional.empty();
    }

    public Optional<User> verifyUserid(String userID) {
        Optional<User> user= userepo.findById(userID);
        System.out.println(" from userService"+userID);
        if (user.isPresent()) {
            return user;
        }
        return Optional.empty();
    }

    public User GetUserDetials(String userId){

        Optional<User> user = userepo.findById(userId);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

}
