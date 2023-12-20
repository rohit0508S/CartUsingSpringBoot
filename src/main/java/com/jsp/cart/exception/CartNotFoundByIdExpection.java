package com.jsp.cart.exception;

public class CartNotFoundByIdExpection extends RuntimeException{
	private String message;
	public CartNotFoundByIdExpection(String message){
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
		
}
