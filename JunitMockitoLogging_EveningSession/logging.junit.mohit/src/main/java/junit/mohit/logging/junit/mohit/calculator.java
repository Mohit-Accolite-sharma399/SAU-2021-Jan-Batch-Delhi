package junit.mohit.logging.junit.mohit;

import Mohit.services;

public class calculator {
	private services service;

	   public void setCalculatorService(services service){
	      this.service = service;
	   }
	   
	   public double add(double input1, double input2){
	      return service.add(input1, input2);
	   }
	   
	   public double subtract(double input1, double input2){
	      return service.subtract(input1, input2);
	   }
	   
	   public double multiply(double input1, double input2){
	      return service.multiply(input1, input2);
	   }
	   
	   public double divide(double input1, double input2){
	      return service.divide(input1, input2);
	   }

}
