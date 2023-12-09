package com.chaintrack.modal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.chaintrack.user.domain.UserRole;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@DataType()
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Property()
    private Long userId;

    @Column(name = "first_name")
	@Property()
    private String firstName;
    
    @Column(name = "last_name")
	@Property()
    private String lastName;

    @Column(name = "password")
	@Property()
    private String password;

    @Column(name = "email")
	@Property()
    private String email;
    
	@Property()
    private UserRole role;
    
	@Property()
    private String mobile;

    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@Property()
    private List<Address> addresses=new ArrayList<>();

    @Embedded
    @ElementCollection
    @CollectionTable(name="payment_information",joinColumns = @JoinColumn(name="user_id"))
	@Property()
    private List<PaymentInformation> paymentInformation=new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval = true)
	@Property()
    private List<Rating>ratings=new ArrayList<>();
    
    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval = true)
	@Property()
    private List<Review>reviews=new ArrayList<>();
    
	@Property()
    private LocalDateTime createdAt;    
}
