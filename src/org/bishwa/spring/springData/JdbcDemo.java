package org.bishwa.spring.springData;

import org.bishwa.spring.springData.dao.JDBCDaoImpl;
import org.bishwa.spring.springData.model.Circle;

public class JdbcDemo {
	public static void main(String[] args) {
		Circle circle = new JDBCDaoImpl().getCircle(1);
		System.out.println(circle.getName());
	}
}
