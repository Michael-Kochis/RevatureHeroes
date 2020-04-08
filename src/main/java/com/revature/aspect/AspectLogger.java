package com.revature.aspect;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class AspectLogger {
	private static Logger log = LogManager.getLogger(AspectLogger.class);
	
	@Before("within(com.revature.controller.*)")
	public void logRepositoryMethods(JoinPoint jp) {
		log.info(jp.getTarget() + " invoked " + jp.getSignature());
	}
	
	@AfterReturning(pointcut="execution(* regis*(..)) && within(com.revature.service.*)", returning = "returnedObject")
	public void logFind(JoinPoint jp, Object returnedObject) {
		log.info(jp.getTarget() + " invoked "+jp.getSignature()+"\n  returning " + returnedObject.toString() );
	}
	
	/*
	 * @SuppressWarnings("unchecked")
	 * @Around("execution(* findAll(..)) && within(com.revature.service.*)") public
	 * List<Trainer> logLoadTime(ProceedingJoinPoint pjp) throws Throwable {
	 * MethodSignature methodSign = (MethodSignature) pjp.getSignature(); String
	 * methodName = methodSign.getName();
	 * 
	 * final StopWatch stopWatch = new StopWatch();
	 * 
	 * stopWatch.start(); List<Trainer> result = (List<Trainer>) pjp.proceed();
	 * stopWatch.stop();
	 * 
	 * log.info(methodName + " took " + stopWatch.getTotalTimeMillis() +
	 * " miliseconds to complete."); return result; }
	 */
	
}
