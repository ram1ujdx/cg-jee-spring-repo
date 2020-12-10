package com.cg.spring.mobileapp;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
//		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		
		Mobile m=(Mobile)context.getBean("mobile");
		
		m.browse();
		m.makeCall();
		m.showSupportedNetworks();

		Mobile m1=(Mobile)context.getBean("mobile");
		Mobile m2=(Mobile)context.getBean("mobile");
		
	}

}
