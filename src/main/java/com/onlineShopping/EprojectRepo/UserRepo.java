package com.onlineShopping.EprojectRepo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineShopping.EprojectModel.User;


@Repository
public interface UserRepo extends JpaRepository<User, String> {
}

