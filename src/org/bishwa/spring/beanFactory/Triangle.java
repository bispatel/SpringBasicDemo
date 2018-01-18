package org.bishwa.spring.beanFactory;

import java.util.List;

public class Triangle {

	private String type;
	private int height;
	private Point pointA;
	private Point pointB;
	private Point pointC;
	private List<Point> list;
	
	
	public Triangle() {
	}

	public Triangle(String type) {
		this.type = type;
	}
	
	public Triangle(int height) {
		this.height = height;
	}

	public Triangle(String type, int height) {
		this.type = type;
		this.height = height;
	}

	public String getType() {
		return type;
	}
	
	

	public void setType(String type) {
		this.type = type;
	}

	public void methodDraw(){
		System.out.println(getType()+" Triangle Drawn with height as "+getHeight());
	}

	public int getHeight() {
		return height;
	}

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
 
	public void drawTriangle(){
		System.out.println("PointA ("+getPointA().getX()+","+getPointA().getY()+")");
		System.out.println("PointB ("+getPointB().getX()+","+getPointB().getY()+")");
		System.out.println("PointC ("+getPointC().getX()+","+getPointC().getY()+")");
	}
	
	
	public void drawListOfTriangle(){
		for(Point point:list){
			System.out.println("Points ("+point.getX()+","+point.getY()+")");
		}
	}

	public List<Point> getList() {
		return list;
	}

	public void setList(List<Point> list) {
		this.list = list;
	}
	
}
