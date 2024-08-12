package com.learn.SpringBoot.scopes.prototype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*  Until request hits the controller, IOC will not create instance for this. by default they are Lazy 
*   each time new object is created
*   
*   
*   @Scope("request") - similar, New Object/ Lazy Initiated -for each request 
*   
*   @Scope("session") - similar, New Object/ Lazy Initiated -for each session 
*   
*/
@RestController
@RequestMapping("/prototype")
@Scope("prototype")
public class TestProtoTypeController {
	
	@Autowired
	Laptop laptop;
	
	@Autowired
	HP hp;
	
	TestProtoTypeController(){
		System.out.println("In TestProtoTypeController constructor");
	}
	
	 @GetMapping("/HealthCheck")
	    public ResponseEntity<String> isConnectionEstablished() {
	        return ResponseEntity.status(HttpStatus.ACCEPTED)
	                             .header("success", "")
	                             .body("Connection is accepted.");
	    }
	 
	 
/* After request hits: o/p
 * 
In TestProtoTypeController constructor
In Laptop prototype Constructor
In HP prototype Constructor
In HP prototype Constructor

*/
	

}
