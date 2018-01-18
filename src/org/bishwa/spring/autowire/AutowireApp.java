package org.bishwa.spring.autowire;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireApp {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"springAutoWire.xml");
		context.registerShutdownHook();
		System.out.println("Autowire By Name:");
		Triangle triangle2 = (Triangle) context.getBean("autowireT");
		triangle2.drawTriangle();
		
		System.out.println("Autowire By Type:");
		Rectangle rectangle = (Rectangle) context.getBean("autowireType");
		rectangle.draw();
	}

}
