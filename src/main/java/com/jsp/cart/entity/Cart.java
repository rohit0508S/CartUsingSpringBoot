package com.jsp.cart.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Component
@Entity
public class Cart {
	@Id
	private int cartId;
	private String cartItem;
	private int cartTotalBill;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public String getCartItem() {
		return cartItem;
	}
	public void setCartItem(String cartItem) {
		this.cartItem = cartItem;
	}
	public int getCartTotalBill() {
		return cartTotalBill;
	}
	public void setCartTotalBill(int cartTotalBill) {
		this.cartTotalBill = cartTotalBill;
	}
	

}
