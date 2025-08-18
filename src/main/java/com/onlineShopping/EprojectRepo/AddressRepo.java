package com.onlineShopping.EprojectRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineShopping.EprojectModel.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address,String>{
}
