package com.jsp.cart.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jsp.cart.entity.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer>{

}
