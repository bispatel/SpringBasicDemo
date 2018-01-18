package org.bishwa.spring.aopXml;


public class AopXmlMain {

	public static void main(String[] args) {
		/*ApplicationContext ctx = new ClassPathXmlApplicationContext("springAopXML.xml");
		ShapeService sr= ctx.getBean("shapeService",ShapeService.class);*/
		
		FactoryService fs = new FactoryService();
		ShapeService ss = (ShapeService) fs.getBean("shapeService");
		ss.getCircle();
	}
}
  