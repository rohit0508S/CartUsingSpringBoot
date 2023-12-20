  package com.jsp.cart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.cart.entity.Cart;
import com.jsp.cart.exception.CartNotFoundByIdExpection;
import com.jsp.cart.repository.CartRepo;
import com.jsp.cart.util.ResponseStructure;
@Service
public class CartService {
@Autowired
private CartRepo cartRepo;
@Autowired
private ResponseStructure<Cart>  structure;



public List<Cart> getAllCart()   
{  
	List<Cart> cart = new ArrayList<Cart>();
	cartRepo.findAll().forEach(cart1 -> cart.add(cart1));
	return cart;
}  
	

//get Cart by Id:

//public Cart getCartById(int cartId) {		
//    Optional<Cart> s=cartRepo.findById(cartId);
//  return s.get();
//}
	
	public Cart getCartById(int cartId) {		
		return cartRepo.findById(cartId).get();
	}
	
	public Cart saveOrUpdate(Cart cart) {
		  cartRepo.save(cart);  
		return cart;
	}  
	public void deleteCart(int cartId)   
	{  
	       cartRepo.deleteById(cartId);  
	}  
	
	public ResponseEntity<ResponseStructure<Cart>> getCartbyId(int cartId){
//		Optional<Cart> optional=cartRepo.findById(cartId);
//		if(optional.isPresent()) {
//			structure.setStatus(HttpStatus.FOUND.value());
//			structure.setMessage("Cart data found !");
//			structure.setData(optional.get());
//			return new ResponseEntity<ResponseStructure<Cart>>(structure,HttpStatus.FOUND);
//		}
//		else {
//			  throw new CartNotFoundByIdExpection("Cart not found by Id !");
//	}
			
		return cartRepo.findById(cartId)
			    .map(cart -> {
			        structure.setStatus(HttpStatus.FOUND.value());
			        structure.setMessage("Cart data found !");
			        structure.setData(cart);
			        return new ResponseEntity<>(structure, HttpStatus.FOUND);
			    })
			    .orElseThrow(() -> new CartNotFoundByIdExpection("Cart not found by Id !"));
	}


	public Cart updateCart(Cart cart) {
        Cart existingCart = cartRepo.findById(cart.getCartId()).get();
        existingCart.setCartItem(cart.getCartItem());
        existingCart.setCartTotalBill(cart.getCartTotalBill());      
        Cart updatedCart = cartRepo.save(existingCart);
        return updatedCart;
    }
	

}
