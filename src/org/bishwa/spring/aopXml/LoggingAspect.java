package org.bishwa.spring.aopXml;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
	
 	 
	
	public Object myAroundAdvice(ProceedingJoinPoint pjp){	
		Object ret=null;
		try {
			System.out.println("Before Advice");
			ret=pjp.proceed();
			System.out.println("After Advice");
		} catch (Throwable e) {
			System.out.println("After Throwing"+e);
		}
		System.out.println("After finally");
		return ret;
	}
	
	public void loggingAdvice(){
		System.out.println("Loging from advice..");
	}
}
