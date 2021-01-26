package payroll;
import java.time.LocalDate;
import java.time.Month;
public class observable{
	public static void main(String args[]){
	      Employee emp1=new senior_soft_eng(103,"Seema","vbnm@gmail.com",78955, 60000.0,"SMS","Senior Software Engineer"); 
	      Employee emp2=new CEO(100,"Ashwani","fghj@gmail.com",1123545,50000.0,"EMAIL","HR");
	      Employee emp3=new Software_eng(102,"Mohan","zxc@gmail.com",12655, 35000.0,"MAIL","Software Engineer");  
	      Employee emp4=new intern(101,"Sohan","abc@gmail.com",147852, 20000.0,"SMS","Intern");
	      Employee ceo=new CEO(100,"Sahil","fghj@gmail.com",1123545,100000.0,"EMAIL","CEO");  
	     
	          ceo.add(emp1);  
	          ceo.add(emp2);  
	          ceo.add(emp3);
	          ceo.add(emp4);
	          ceo.print();
	          System.out.println("");
	          System.out.println("*************");
	          System.out.println("");
	          System.out.println("Sending notifications for the salary updation: ");
	          LocalDate currentdate = LocalDate.now();
	          Month month = currentdate.getMonth();
	          int year = currentdate.getYear();
	          System.out.println("Date: 15 "+month + " "+year+" 3:00 PM\n");

	          ceo.Notify();
	        }  
}
