package com.chaintrack.modal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DataType()
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Property()
    private Long productId;

    @Column(name = "title")
	@Property()
    private String title;

    @Column(name = "description")
	@Property()
    private String description;

    @Column(name = "price")
	@Property()
    private int price;

    @Column(name = "discounted_price")
	@Property()
    private int discountedPrice;
    
    @Column(name="discount_persent")
	@Property()
    private int discountPersent;

    @Column(name = "quantity")
	@Property()
    private int quantity;

    @Column(name = "brand")
	@Property()
    private String brand;

    @Column(name = "color")
	@Property()
    private String color;

    @Embedded
    @ElementCollection
    @Column(name = "sizes")
	@Property()
    private Set<Size> sizes=new HashSet<>();

    @Column(name = "image_url")
	@Property()
    private String imageUrl;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,orphanRemoval = true)
	@Property()
    private List<Rating>ratings=new ArrayList<>();
    
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,orphanRemoval = true)
	@Property()
    private List<Review>reviews=new ArrayList<>();

    @Column(name = "num_ratings")
	@Property()
    private int numRatings;
    

    @ManyToOne()
    @JoinColumn(name="category_id")
	@Property()
    private Category category;
    
	@Property()
    private LocalDateTime createdAt;
	

   
}
