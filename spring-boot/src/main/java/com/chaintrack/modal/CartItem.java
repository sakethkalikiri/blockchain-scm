package com.chaintrack.modal;

import java.util.Objects;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@DataType()
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Property()
	private Long cartItemId;
	
	@JsonIgnore
	@ManyToOne
	@Property()
	private Cart cart;
	
	@ManyToOne
	@Property()
	private Product product;
	
	@Property()
	private String size;
	
	@Property()
	private int quantity;
	
	@Property()
	private Integer price;
	
	@Property()
	private Integer discountedPrice;
	
	@Property()
	private Long userId;

	public CartItem(Long cartItemId, Cart cart, Product product, String size, int quantity, Integer price, Long userId) {
		super();
		this.cartItemId = cartItemId;
		this.cart = cart;
		this.product = product;
		this.size = size;
		this.quantity = quantity;
		this.price = price;
		this.userId = userId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItem other = (CartItem) obj;
		return Objects.equals(cartItemId, other.cartItemId) && Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(product, other.product) && Objects.equals(size, other.size);
	}
	
	
}
