package com.learn.SpringBoot.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectHandler {

	@Before("execution(public void com.learn.SpringBoot.AOP.AOPController.healthCheck())")
	public void beforeHealthCheck() {
		System.out.println("AOP before invoked for healthCheck");
	}

	@Before("execution(public * com.learn.SpringBoot.AOP.*.*(..))")
	  void before() { 
		  System.out.print("AOP before invoked");
		  }


    @After("execution(public void com.learn.SpringBoot.AOP.AOPController.healthCheck())")
    public void afterHealthCheck() {
        System.out.println("AOP after invoked for healthCheck");
    }

    @Around("execution(public void com.learn.SpringBoot.AOP.AOPController.healthCheck())")
    public Object aroundHealthCheck(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("AOP around before proceeding healthCheck");
        Object result = joinPoint.proceed();
        System.out.println("AOP around after proceeding healthCheck");
        return result;
    }

    @AfterReturning("execution(public void com.learn.SpringBoot.AOP.AOPController.healthCheck())")
    public void afterReturningHealthCheck() {
        System.out.println("AOP after returning invoked for healthCheck");
    }

    @AfterThrowing("execution(public void com.learn.SpringBoot.AOP.AOPController.healthCheck())")
    public void afterThrowingHealthCheck() {
        System.out.println("AOP after throwing invoked for healthCheck");
    }
    
    
    /////////////////////////////// Types ///////////////////////////////////
	
    @Before("within(com.learn.SpringBoot.AOP.*)")
    public void beforeMethodWithinPackage() {
        System.out.println("AOP before invoked for any method within the package com.learn.SpringBoot.AOP");
    }

    @Before("this(org.springframework.web.bind.annotation.RestController)")
    public void beforeMethodWithThis() {
        System.out.println("AOP before invoked for methods where the proxy is a RestController");
    }

    @Before("target(org.springframework.web.bind.annotation.RestController)")
    public void beforeMethodWithTarget() {
        System.out.println("AOP before invoked for methods where the target object is a RestController");
    }

	/*
	 * @Before("args(java.lang.String,..)") public void beforeMethodWithArgs() {
	 * System.out.println("AOP before invoked for methods with a String argument");
	 * }
	 */

    @Before("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void beforeMethodWithAnnotation() {
        System.out.println("AOP before invoked for methods with @GetMapping annotation");
    }
    
    
    @Pointcut("execution(* com.learn.SpringBoot.AOP.AOPController.*(..)) && @annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void controllerGetPointcut() {}

    @Before("controllerGetPointcut()")
    public void beforeControllerMethodWithGetMappingAnnotation() {
        System.out.println("AOP before invoked for methods in AOPController with @GetMapping annotation");
    }
	
}
