package org.bishwa.spring.autowire;

public class Rectangle {

	private Coordinate coordinate;

 
	public void draw(){
		System.out.println("Rectangle:"+coordinate.getA()+","+coordinate.getB()+","+coordinate.getA()+","+coordinate.getB());
	}


	public Coordinate getCoordinate() {
		return coordinate;
	}


	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	public void myInit(){
		System.out.println("MyInit method initialization");
	}
	
	public void destroy(){
		System.out.println("Destroy Method");
	}
}
