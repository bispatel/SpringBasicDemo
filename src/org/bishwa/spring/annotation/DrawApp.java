package org.bishwa.spring.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawApp {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("springAutoWire.xml");
		Shape s=(Shape) context.getBean("circle");
		s.draw();
	}

}
