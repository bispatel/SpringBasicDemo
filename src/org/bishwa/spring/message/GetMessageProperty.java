package org.bishwa.spring.message;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetMessageProperty {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"springMessage.xml");
		context.registerShutdownHook();
		Circle circle = (Circle) context.getBean("circle");
		circle.draw();
		String msg = context.getMessage("greeting", null, "Default Message",
				null);
		System.out.println("Using Application Context:"+msg);
		context.close();
	}
}
 