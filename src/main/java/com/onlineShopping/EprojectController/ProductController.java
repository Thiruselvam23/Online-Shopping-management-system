package com.onlineShopping.EprojectController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.onlineShopping.EprojectModel.Product;
import com.onlineShopping.EprojectService.ProductService;

@Controller
@CrossOrigin(origins = "*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<?> addProduct(Product product) {
        return productService.addproducts(product);
	}
	
	@GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    public ResponseEntity<?> getProductById(Long id) {
        Optional<Product> product = productService.getProductById(id);
		if(product.isPresent()){
			return ResponseEntity.ok(product.get());
		}
		return ResponseEntity.ok(null);
    }
	
}
