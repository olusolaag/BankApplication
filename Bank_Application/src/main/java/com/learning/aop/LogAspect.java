/**
 * 
 */
package com.learning.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author "Olusola Agboola"
 * @date Feb 17, 2022
 * @time 10:28:49 AM
 */
@Component
@Aspect
public class LogAspect {
	private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);
	//@Pointcut("within(com.boot.demo.controller..*)")
//	@After("execution(* com.learning.controller.CustomerController.*(..))")//everything in the controller package
//	public void logRestController() {
//		LOGGER.info("after advice called");
//		
//	}
//	
//	@Before("execution(* com.boot.demo.controller.PersonController.*(..))")//everything in the controller package
//	public void logRestController2() {
//		LOGGER.info("before advice called");
//		
//	}
//	
//	@Pointcut("within(org.springframework.sterotype.Repository *)"+
//	"||within(org.springframework.sterotype.Service *)"+"||within(org.springframework.web.bind.sterotype.RestController *)")
//	public void springPointCutExp() {
//		
//	}
//	
//	@Pointcut("within(com.boot.demo.controller..*) "+"|| within(com.boot.demo.service..*)")
//	public void springPointCutExp2() {
//		
//	}
//	
//	@AfterThrowing(pointcut = "springPointCutExp() && springPointCutExp2()", throwing = "e")
//	public void logAfterThrowingException(JoinPoint joinPoint, Throwable e) {
//		//Joinpoint heps us to retrieve the triggering event details
//		System.out.println(joinPoint);
//		System.out.println(e);
//		
//	}

}
