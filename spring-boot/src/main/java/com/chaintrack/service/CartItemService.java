package com.chaintrack.service;

import org.hyperledger.fabric.gateway.ContractException;

import com.chaintrack.exception.CartItemException;
import com.chaintrack.exception.UserException;
import com.chaintrack.modal.Cart;
import com.chaintrack.modal.CartItem;
import com.chaintrack.modal.Product;

public interface CartItemService {
	
	public CartItem createCartItem(CartItem cartItem) throws ContractException;
	
	public CartItem updateCartItem(Long userId, Long id,CartItem cartItem) throws CartItemException, UserException;
	
	public CartItem isCartItemExist(Cart cart,Product product,String size, Long userId);
	
	public void removeCartItem(Long userId,Long cartItemId) throws CartItemException, UserException;
	
	public CartItem findCartItemById(Long cartItemId) throws CartItemException;
	
}
