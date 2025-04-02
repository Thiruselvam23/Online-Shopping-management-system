package com.onlineShopping.EprojectService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.onlineShopping.EprojectModel.Category;
import com.onlineShopping.EprojectModel.Product;
import com.onlineShopping.EprojectRepo.CategoryRepo;
import com.onlineShopping.EprojectRepo.productrepo;

@Service
public class ProductService {
	@Autowired
	private productrepo Product;
	@Autowired
	private CategoryRepo categoryRepo;
	
	public ResponseEntity<?> addproducts(Product product) {
		Optional<Category> categoryId = categoryRepo.findById(product.getCategaryType());
		
		if(categoryId.isPresent()){
			product.setCategoryID(categoryId.get().getCategoryID());
			Product.save(product);
			return ResponseEntity.ok(product);
		}

		Category category = new Category();
        category.setCategoryName(product.getCategoryType());
        category = categoryRepo.save(category);

		product.setCategoryID(category.getCategoryID());
		Product.save(product);
		return ResponseEntity.ok(product);
	}

	public List<Product> getAllProducts() {
	    return Product.findAll();
	}
	public Optional<Product> getProductById(Long id) {
    	return Product.findById(id);
	}
	
}
