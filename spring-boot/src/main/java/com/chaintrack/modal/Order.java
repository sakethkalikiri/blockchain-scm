package com.chaintrack.modal;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.chaintrack.user.domain.OrderStatus;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

@Entity
@Table(name = "orders")
@DataType()
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Property()
    private Long orderId;

    @Column(name="order_id_data")
	@Property()
    private String orderIdData;
  
    @ManyToOne
	@Property()
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	@Property()
    private List<OrderItem> orderItems = new ArrayList<>();

	@Property()
    private LocalDateTime orderDate;

	@Property()
    private LocalDateTime deliveryDate;

    @OneToOne
	@Property()
    private Address shippingAddress;

    @Embedded
	@Property()
    private PaymentDetails paymentDetails=new PaymentDetails();

	@Property()
    private double totalPrice;
    
	@Property()
    private Integer totalDiscountedPrice;
    
	@Property()
    private Integer discount;

	@Property()
    private OrderStatus orderStatus;
    
	@Property()
    private int totalItem;
    
	@Property()
    private LocalDateTime createdAt;
    
    
}
