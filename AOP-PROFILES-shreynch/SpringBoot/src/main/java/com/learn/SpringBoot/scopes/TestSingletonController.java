package com.learn.SpringBoot.scopes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

/* Default scope is singleton
 * Object will  be created at once during IOC setup, and shared among all the dependencies 
 * - Car object is created once
 *  */

@RestController
@Component
public class TestSingletonController {
	
	
	
	TestSingletonController(){
		System.out.println("In Constructor TestSingletonController ");
	}
	
	@Autowired
	Car car;
	
	/*
	 * @PostConstruct void predestory() {
	 * System.out.println("--------------END SINGLETON SCOPE-----------------------"
	 * ); }
	 */


}
