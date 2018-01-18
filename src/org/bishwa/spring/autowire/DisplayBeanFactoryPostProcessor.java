package org.bishwa.spring.autowire;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class DisplayBeanFactoryPostProcessor implements
		BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory bean)
			throws BeansException {
		System.out.println("Bean Factory Post Processor " + bean);
	}

}
