package com.spring.au;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Rectangle {
		
	
	  int height ; 
	  int width ; 
	  @Autowired
	  @Qualifier("PointA")
	  private Point pointA;
	  
	  @Autowired
	  @Qualifier("PointB")
	  private Point pointB;
	  
	  @Autowired
	  @Qualifier("PointC")
	  private Point pointC;
	  
	  @Autowired
	  @Qualifier("PointD")
	  private Point pointD;
	 
	  
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

	public Point getPointD() {
		return pointD;
	}

	public void setPointD(Point pointD) {
		this.pointD = pointD;
	}
	
	@Autowired
	public Rectangle(int height , int width){
		this.height = height ; 
		this.width = width ; 
	}

	public void draw() {
	  System.out.println(" Rectangle Drawn of type with points ");
	  System.out.println("Point A : " + getPointA().getX() + " " + getPointA().getY() ) ;
	  System.out.println("Point B : " + getPointB().getX() + " " + getPointB().getY() ) ; 
	  System.out.println("Point C : " + getPointC().getX() + " " + getPointC().getY() ) ; 
	  System.out.println("Point D : " + getPointD().getX() + " " + getPointD().getY() ) ; 
	  }

	
}
