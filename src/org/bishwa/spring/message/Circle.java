package org.bishwa.spring.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public class Circle {
	@Autowired
	private Point center;
	@Autowired
	private MessageSource messageSource;

	public void draw() {
		System.out.println(this.messageSource.getMessage("drawing.circle",null, "Default Drawing Message", null));
		System.out.println(this.messageSource.getMessage("drawing.point",new Object[] { center.getX(), center.getY() },
				"Default Points (0,0) Message", null));
		System.out.println("Inside Circle:"+ this.messageSource.getMessage("greeting", null,"Default Message", null));
	}

}
