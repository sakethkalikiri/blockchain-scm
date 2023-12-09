package com.chaintrack.modal;

import java.time.LocalDate;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DataType()
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentInformation { 

	    @Column(name = "cardholder_name")
		@Property()
	    private String cardholderName;

	    @Column(name = "card_number")
		@Property()
	    private String cardNumber;

	    @Column(name = "expiration_date")
		@Property()
	    private LocalDate expirationDate;

	    @Column(name = "cvv")
		@Property()
	    private String cvv;

	}


