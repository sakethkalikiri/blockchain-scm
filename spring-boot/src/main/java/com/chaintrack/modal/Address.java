package com.chaintrack.modal;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Property()
	private Long addressId;

	@Column(name="first_name")
	@Property()
	private String firstName;
	
	@Column(name="last_name")
	@Property()
	private String lastName;
	
    @Column(name = "street_address")
	@Property()
    private String streetAddress;

    @Column(name = "city")
	@Property()
    private String city;

    @Column(name = "state")
	@Property()
    private String state;

    @Column(name = "zip_code")
	@Property()
    private String zipCode;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
	@Property()
    private User user;
    
	@Property()
    private String mobile;

}
