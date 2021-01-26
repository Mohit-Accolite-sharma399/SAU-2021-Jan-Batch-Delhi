package payroll;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Software_eng implements Employee{
	 private int id;
     private String name; 
	 private String Email;
     private long PhoneNumber;
     private double salary; 
     public String notifyMode;
     String designation;
     public Software_eng(int id,String name,String Email,long PhoneNumber,double salary,String notifyMode,String designation) {  
      this.id=id;      
      this.name = name;  
      this.Email=Email;
      this.PhoneNumber=PhoneNumber;
      this.salary = salary; 
      this.notifyMode=notifyMode;
      this.designation=designation;
     }   
     @Override  
     public void add(Employee employee) {  
    	 
     }  
        @Override  
     public Employee getChild(int i) {  
      return null;  
     }  
     @Override  
     public void remove(Employee employee) {  
        
     } 
     @Override  
     public int getId()  {  
      return id;  
     }  
     @Override  
     public String getName() {  
      return name;  
     }  
     @Override  
     public String getEmail() {  
      return Email;  
     }  
     @Override  
     public long getPhoneNumber() {  
      return PhoneNumber;  
     }  
    @Override  
     public double getSalary() {  
      return salary;  
     } 
    @Override
    public String getnotifyMode()
    {
    	return notifyMode;
    }
    @Override
    public String getdesignation()
    {
    	return designation;
    }
    @Override
    public void Notify()
    {
		if(getnotifyMode()=="SMS")
			System.out.println("SMS sent: Dear employee your Salary is updated");
		else
			System.out.println("Email sent: Dear employee your Salary is updated"); 
    }
     @Override  
     public void print() {  
      System.out.println("==========================");
      System.out.println("Designation: "+getdesignation());
      System.out.println("Id: "+getId());  
      System.out.println("Name: "+getName());  
      System.out.println("Email: "+getEmail());  
      System.out.println("Phone Number: "+getPhoneNumber());  
      System.out.println("Salary: "+getSalary()+"\n");        
      }
}