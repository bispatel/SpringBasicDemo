package org.bishwa.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springAop.xml");
		ShapeService sr= ctx.getBean("shapeService",ShapeService.class);
		//sr.getCircle().setName("Aspect Exception" );
		//sr.getCircle().setNameAndReturn("Dummy Name" );
		//System.out.println(sr.getCircle().getName());
		//sr.getCircle().setName("aa");
		sr.getCircle();
	}
}
  