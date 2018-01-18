package org.bishwa.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.bishwa.spring.aop.Circle;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    
	@Before("allGetters() && allCircleMethods()")	
	public void loggingAdvice(JoinPoint jp) {
		System.out.println(jp.toString());
		Circle cr = (Circle) jp.getTarget();
	}
	
 	@Pointcut("execution(* get*(..))")
	public void allGetters(){}
	
	@Pointcut("within(org.bishwa.spring.aop.Circle)")
	public void allCircleMethods(){}
	
	@AfterReturning(pointcut="args(name)",returning="returnString")
	public void stringArgumentMethods(String name,String returnString){
		System.out.println("Input is:"+name+", output is:"+returnString);
	}
	
	@AfterThrowing(pointcut="args(name)",throwing="ex")
	public void exceptionHandle(String name,RuntimeException ex){
		System.out.println("Input is:"+name+", output is:"+ex);
	}
	
	
	@Before("args(name)")
	public void useMethodArgument(String name){
		System.out.println("Parameter Name is:"+name);
	}
	
	//@Around("allGetters()")
	@Around("@annotation(org.bishwa.spring.aop.Loggable)")
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
}
