package org.bishwa.spring.aopXml;

public class ShapeService {

	private Circle circle;
	private Triangle triangle;
	public Circle getCircle() {
		System.out.println("Circle Getter Called.");
		return circle;
	}
	
	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	public Triangle getTriangle() {
		return triangle;
	}

	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}

}
