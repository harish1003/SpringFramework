package com.learn.SpringBoot.AOP;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AOPController {

	@GetMapping("/health")
	public void healthCheck() {
		System.out.println("Health check invoked");
		
	}
	
	 @GetMapping("/greet/{name}")
	    public void greet(@PathVariable String name) {
	        System.out.println("Greeting " + name);
	    }
	
	
	
}
