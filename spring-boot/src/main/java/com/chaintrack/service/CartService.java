package com.chaintrack.service;

import org.hyperledger.fabric.gateway.ContractException;

import com.chaintrack.exception.ProductException;
import com.chaintrack.modal.Cart;
import com.chaintrack.modal.User;
import com.chaintrack.request.AddItemRequest;

public interface CartService {
	
	public Cart createCart(User user);
	
	public String addCartItem(Long userId,AddItemRequest req) throws ProductException, ContractException;
	
	public Cart findUserCart(Long userId);

}
