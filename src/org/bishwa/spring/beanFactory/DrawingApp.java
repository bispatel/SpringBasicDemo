package org.bishwa.spring.beanFactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	public static void main(String[] args) {
		//Bean Factory
		/*BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		Triangle triangle1 = (Triangle) factory.getBean("triangle");
		System.out.println("Using Bean Factory..");
		triangle1.methodDraw();*/
		
		//System.out.println("Using Application Context");
		//Application context. The xml will be fetched from classpath. So move it to src folder
		ApplicationContext context = new ClassPathXmlApplicationContext("springClassPath.xml");
		System.out.println("Setter Injection:");
		Triangle triangle2 = (Triangle) context.getBean("setterInject");		
		triangle2.methodDraw();
		
		System.out.println("Constructor Injection Only Type:");
		triangle2 = (Triangle) context.getBean("typeOnly");		
		triangle2.methodDraw();
		
		System.out.println("Constructor Injection Both Type and Height:");
		triangle2 = (Triangle) context.getBean("typeAndHeight");		
		triangle2.methodDraw();
		
		System.out.println("Constructor Injection Only Height:");
		triangle2 = (Triangle) context.getBean("heightOnly");		
		triangle2.methodDraw();
		
		System.out.println("Drawing a Triangle");
		triangle2 = (Triangle) context.getBean("triangle");		
		triangle2.drawTriangle();
		
		System.out.println("List Example:");
		triangle2 = (Triangle) context.getBean("collection");		
		triangle2.drawListOfTriangle();
	}
}
