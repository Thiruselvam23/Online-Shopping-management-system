package com.onlineShopping.EprojectController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineShopping.EprojectModel.Address;
import com.onlineShopping.EprojectModel.Cart;
import com.onlineShopping.EprojectModel.Order;
import com.onlineShopping.EprojectModel.Payment;
import com.onlineShopping.EprojectModel.Product;
import com.onlineShopping.EprojectModel.User;
import com.onlineShopping.EprojectModel.Vendor;
import com.onlineShopping.EprojectService.OrderController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/")
@CrossOrigin
public class HomeController {
	@Autowired
	private UserController user;
	
	@Autowired
	private ProductController productcont;

	@Autowired
	private VendorController vendorcont;

	@Autowired
	private CartController cartcont;

	@Autowired
	private OrderController ordercont;

	@Autowired
	private PaymentController paymentcont;

	@Autowired
	private AddressController addresscont;
		
	@GetMapping("/Home")
	public String index() {
		return "Login and start parchasing the products";
	}
	
	@PostMapping("/user")
	public ResponseEntity<?> setUser(@RequestBody User User) {
	    return user.setUser(User);
	}


	@PostMapping("/userlogin")
	public ResponseEntity<?> verifyUser(@RequestBody Map<String, String> request) {
    	String UserId = request.get("userId");
    	String password = request.get("password");

    	System.out.println(UserId + "   " + password);
    	return user.verifyUser(UserId, password);
	}

	@GetMapping("/user/{UserId}")
	public ResponseEntity<?> verifyUserid(@PathVariable String UserId) {
    	System.out.println(UserId );
    	return user.verifyUserId(UserId);
	}


	@GetMapping("/getUserId")
	public ResponseEntity<?> getUserId() {
		return user.getUserId();
	}

	// getting the user Detials .... 
	@GetMapping("/userDetials/{UserId}")
	public User GetUserDetials(@RequestParam String UserId) {
		return user.GetUserDetials(UserId);
	}
	
	@PostMapping("/vendor")
	public ResponseEntity<?> addVendor(@RequestBody Vendor vendor) {
		return vendorcont.setVendor(vendor);
	}

	@PostMapping("/vendorlogin")
	public ResponseEntity<?> verifyVendor(@RequestBody Map<String, String> request) {

    	String vendorId = request.get("vendorId");
    	String password = request.get("password");

    	System.out.println(vendorId + "   " + password);
    	return vendorcont.verifyVendor(vendorId, password);
	}

	@GetMapping("/vendor/{VendorId}")
	public ResponseEntity<?> verifyVendorid(@PathVariable String VendorId) {
    	System.out.println(VendorId );
    	return vendorcont.verifyVerdorId(VendorId);
	}

	@PostMapping("/products")
	public ResponseEntity<?> addProduct(@RequestBody Product product){
		return productcont.addProduct(product);
	}
	
	@GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        	return productcont.getAllProducts();
    }

	//get by product ID ....
	@GetMapping("/{id}")
	public ResponseEntity<?> getProductByID(@PathVariable Long id) {
		System.out.println("get by product Id : "+id );
		return productcont.getProductById(id);
	}

	@PostMapping("/cart")
	public ResponseEntity<?> addCart(@RequestBody Cart cart) {
		return cartcont.addcart(cart);
	}

	@GetMapping("/cart")
    public ResponseEntity<?> getAllCarts() {
        return cartcont.getAllCarts();
    }

	@PostMapping("/order")
	public ResponseEntity<?> postMethodName(@RequestBody Order order) {
		return ordercont.setOrder(order);
	}


	@GetMapping("/orders/{userId}")
	public ResponseEntity<List<Order>> getOrderByUserId(@PathVariable String userId){
		return ordercont.getOrderByuserId(userId);
	}
	
	
	@PostMapping("/payment")
	public ResponseEntity<?> SetPayment(@RequestBody Payment payment) {
		return paymentcont.setPayment(payment);
	}

	@PostMapping("/address")
	public ResponseEntity<?> setAddress(@RequestBody Address address) {
         
		System.out.println("home :"+address.getUserId());

		return addresscont.setAddress(address);
	}
	
	
}
