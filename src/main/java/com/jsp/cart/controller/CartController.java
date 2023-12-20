package com.jsp.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.cart.entity.Cart;
import com.jsp.cart.service.CartService;
import com.jsp.cart.util.ResponseStructure;

@RestController
public class CartController {
	@Autowired
	private CartService cartService;

	@GetMapping("/cart")
	public List<Cart> getAllCart() {
		return cartService.getAllCart();
	}

//	@GetMapping("/cart/{cartId}")
//	public Cart getCart(@PathVariable("cartId") int cartId) {
//		return cartService.getCartById(cartId);
//	}

	@PostMapping("/cart/{cartId}")
	public void deleteCart(@PathVariable("cartId") int cartId) {
		cartService.deleteCart(cartId);
	}

	@PostMapping("/cart")
	public ResponseEntity<Cart> saveCart(@RequestBody Cart cart) {
		Cart carts=cartService.saveOrUpdate(cart);
		return new ResponseEntity<>(carts,HttpStatus.CREATED);
	}

//	@PutMapping("/cart")
//	public Cart update(@RequestBody Cart cart) {
//		cartService.saveOrUpdate(cart);
//		return cart;
//	}
	
	@GetMapping("/cart/{cartId}")
	public ResponseEntity<ResponseStructure<Cart>> getCartById(@PathVariable int cartId){
				return cartService.getCartbyId(cartId);
	}
	
	   @PutMapping("/cart/{id}")
	    // http://localhost:8080/api/users/1
	    public ResponseEntity<Cart> updateCart(@PathVariable("id") int  userId,                                         @RequestBody Cart cart){
	        cart.setCartId(userId);
	        Cart updatedCart = cartService.updateCart(cart);
	        return new ResponseEntity<>(updatedCart, HttpStatus.OK);
	    }
	
}
