package com.chaintrack.modal;

import java.time.LocalDateTime;
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
import lombok.NoArgsConstructor;

@Entity
@DataType()
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Property()
	private Long id;
	
	@JsonIgnore
	@ManyToOne
	@Property()
	private Order order;
	
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
	
	@Property()
	private LocalDateTime deliveryDate;

}
