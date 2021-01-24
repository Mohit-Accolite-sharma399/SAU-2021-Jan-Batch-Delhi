package com.spring.au;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean(name="rectangleObj")
	public Rectangle Rectangle(){
		return new Rectangle(30 , 10);
	}
	
	@Bean(name="PointA")
	public Point getPointA() {
		return new Point(10,20);
	}
	
	@Bean(name="PointB")
	public Point getPointB() {
		return new Point(10,40);
	}
	
	@Bean(name="PointC")
	public Point getPointC() {
		return new Point(30,20);
	}
	
	@Bean(name="PointD")
	public Point getPointD() {
		return new Point(30,40);
	}
	
	

}
