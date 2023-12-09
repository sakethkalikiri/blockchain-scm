package com.chaintrack.modal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@DataType()
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Property()
    private Long cartId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
	@Property()
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "cart_items")
	@Property()
    private Set<CartItem> cartItems = new HashSet<>();

    @Column(name = "total_price")
	@Property()
    private double totalPrice;
    
    @Column(name="total_item")
	@Property()
    private int totalItem;
    
	@Property()
    private int totalDiscountedPrice;
    
	@Property()
    private int discount;

	public Cart(Long cartId, User user, Set<CartItem> cartItems, double totalPrice, int totalItem) {
		super();
		this.cartId = cartId;
		this.user = user;
		this.cartItems = cartItems;
		this.totalPrice = totalPrice;
		this.totalItem = totalItem;
	}
}
