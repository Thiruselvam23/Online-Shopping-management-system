package com.onlineShopping.EprojectRepo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineShopping.EprojectModel.Product;

@Repository
public interface productrepo extends JpaRepository<Product, Long>{
}
