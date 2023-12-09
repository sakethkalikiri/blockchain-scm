package com.chaintrack.modal;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

import com.chaintrack.user.domain.PaymentMethod;
import com.chaintrack.user.domain.PaymentStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DataType()
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDetails {
	
	@Property()
	private PaymentMethod paymentMethod;

	@Property()
	private PaymentStatus status;

	@Property()
	private String paymentId;

	@Property()
	private String razorpayPaymentLinkId;

	@Property()
	private String razorpayPaymentLinkReferenceId;

	@Property()
	private String razorpayPaymentLinkStatus;

	@Property()
	private String razorpayPaymentId​;
	

}
