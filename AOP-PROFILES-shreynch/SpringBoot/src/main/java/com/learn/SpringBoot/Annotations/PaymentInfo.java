package com.learn.SpringBoot.Annotations;

import org.springframework.stereotype.Component;

@Component
public class PaymentInfo {

	private String paymentIdSupported = "1,2,3,4,5";
	
	private String paymentMode = "Cash/Card";

	public String getPaymentsId() {
		// TODO Auto-generated method stub
		return paymentIdSupported;
	}
	
	
	
}
