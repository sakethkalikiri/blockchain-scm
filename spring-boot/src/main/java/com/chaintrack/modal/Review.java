package com.chaintrack.modal;

import java.time.LocalDateTime;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DataType()
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Property()
	private Long reviewId;
	
	@Property()
	private String review;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	@JsonIgnore
	@Property()
	private Product product;

	@ManyToOne
	@JoinColumn(name="user_id")
	@Property()
	private User user;
	
	@Property()
	private LocalDateTime createdAt;


}
