package org.bishwa.spring.springData;

import org.bishwa.spring.springData.dao.DbcpConnPoolingv3;
import org.bishwa.spring.springData.dao.JdbcDaoImplSpringv1;
import org.bishwa.spring.springData.dao.JdbcDaoImplSpringv2;
import org.bishwa.spring.springData.dao.JdbcNamedParamTemplateImplv5;
import org.bishwa.spring.springData.dao.JdbcTemplateImplv4;
import org.bishwa.spring.springData.dao.SimpleJdbcDaoImpl;
import org.bishwa.spring.springData.model.Circle;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcDemoSpring {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("springDatabase.xml");
		context.registerShutdownHook();
		//Using Version1
		JdbcDaoImplSpringv1 dao1 = (JdbcDaoImplSpringv1) context.getBean("jdbcDaoImplSpringv1", JdbcDaoImplSpringv1.class);
		Circle circle1= dao1.getCircle(1);
		//System.out.println("Using Version1:"+circle1.getName());
		//Using Version2
		JdbcDaoImplSpringv2 dao2 = (JdbcDaoImplSpringv2) context.getBean("jdbcDaoImplSpringv2", JdbcDaoImplSpringv2.class);
		Circle circle2= dao2.getCircle(1);
		//System.out.println("Using Spring Datasource:"+circle2.getName());
		
		//Using Version2
		DbcpConnPoolingv3 dao3 = (DbcpConnPoolingv3) context.getBean("dbcpConnPoolingv3", DbcpConnPoolingv3.class);
		Circle circle3= dao3.getCircle(1);
		//System.out.println("Using Spring DBCP Connection Pooling:"+circle3.getName());
		
		//JDBC Template
		JdbcTemplateImplv4 temp4 = (JdbcTemplateImplv4) context.getBean("jdbcTemplateImplv4", JdbcTemplateImplv4.class);
		/*System.out.println("Inserting a new circle with Id: 3 and Name: circletest3");
		temp4.insertCircle(new Circle(3,"circletest3"));
		System.out.println("Circle Name Using JDBC Template:-"+temp4.getCircleName(1));
		System.out.println("Circle Object:"+temp4.getCircleForId(1).getName());
		System.out.println("List of Circle Name:");
		for(Circle c:temp4.getAllCircle()) {
			System.out.println(c.getName());
		}
		System.out.println("Total Circle Records:"+temp4.getCircleCount());*/
		/*System.out.println("Creating Triangle:");
		temp4.createtriangleTable();*/
		
		//Named Parameters Jdbc Template
		/*System.out.println("Named Parameter Example:");
		JdbcNamedParamTemplateImplv5 namedParam = (JdbcNamedParamTemplateImplv5) context.getBean("jdbcNamedParamTemplateImplv5", JdbcNamedParamTemplateImplv5.class);
		namedParam.insertCircleUsingNamedParamTemplete(new Circle(5,"CircleTest5"));*/
		
		//Simple Jdbc Template
		System.out.println("Using Simple Jdbc Template");
		SimpleJdbcDaoImpl simpleJdbcTemplate = (SimpleJdbcDaoImpl) context.getBean("simpleJdbcDaoImpl", SimpleJdbcDaoImpl.class);
		System.out.println(simpleJdbcTemplate.getCircleCount());
		context.close();
	}
}
