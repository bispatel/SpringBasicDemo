package org.bishwa.spring.aopXml;

public class ShapeServiceProxy extends ShapeService {
	public Circle getCircle() {
		new LoggingAspect().loggingAdvice();
		return super.getCircle();
	}
}
