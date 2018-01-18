package org.bishwa.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Circle implements Shape {
	private Point center;

	public Point getCenter() {
		return center;
	}

	@Autowired
	@Qualifier("circleRelated")
	public void setCenter(Point center) {
		this.center = center;
	}

	public void draw() {
		System.out.println("Point:(" + center.getX() + "," + center.getY()
				+ ")");
	}
}
