package com.learn.SpringBoot.Annotations;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonComponent
@Component
public class Payment {
	
	int paymentId;
	int paymentMoney;
	
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public int getPaymentMoney() {
		return paymentMoney;
	}
	public void setPaymentMoney(int paymentMoney) {
		this.paymentMoney = paymentMoney;
	}

}
