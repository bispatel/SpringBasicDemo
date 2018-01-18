package org.bishwa.spring.aopXml;

public class Circle {
	private String name;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		throw (new RuntimeException());
	}
	
	public String setNameAndReturn(String name){
		this.name=name;
		System.out.println("setNameAndReturn method called");
		return "Hello "+name;
	}
}
