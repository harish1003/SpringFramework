package com.learn.SpringBoot.Annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // responsible for incoming HTTP request
@Component // Saying spring to manage this bean or object
//@RequestMapping("/") // It is the path for the Http request 
public class PaymentController {
	
	// http://localhost:8080/paymentMoney/12, http://localhost:8080/getPaymentId
	
	@Autowired
	private PaymentInfo paymentInfo;

	@RequestMapping(path = "/getPaymentId", method = RequestMethod.GET)
	String getPaymentId() {
		return paymentInfo.getPaymentsId();
	}
	
	@GetMapping("/getPaymentId1")
	String getPaymentId1() {
		return paymentInfo.getPaymentsId();
	}
	
	@PostMapping("/payment")
	void paymentDetails(@RequestParam(name = "paymentname") String paymentName, 
			            @RequestParam(name = "paymentId") int paymentId) {
		
		System.out.println("PaymentName : "+paymentName+" paymentId : "+ paymentId);
		
	}
	
	@GetMapping("/paymentMoney/{payment_id}")
	int getPaymentMoney(@PathVariable("payment_id") int id ) {
		return id+2;
	}
	
	
	@GetMapping("/createPayment")
	
	int createPayment(@RequestBody Payment payment) {
		
		System.out.println(payment.paymentId +" "+payment.paymentMoney);
		
		return 1;
		
	}
	
	
	
	 @GetMapping("/HealthCheck")
	    public ResponseEntity<String> isConnectionEstablished() {
	        return ResponseEntity.status(HttpStatus.ACCEPTED)
	                             .header("success", "")
	                             .body("Connection is accepted.");
	    }
	
	
	
	
	
}
