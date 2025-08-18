package com.onlineShopping.EprojectRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineShopping.EprojectModel.Category;

public interface CategoryRepo extends JpaRepository<Category,String>{
}
