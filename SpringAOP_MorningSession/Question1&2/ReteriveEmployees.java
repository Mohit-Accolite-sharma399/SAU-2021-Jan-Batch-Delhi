package Question1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;



public class ReteriveEmployees {

	public static void main(String[] args) {
		
		ApplicationContext factory = new FileSystemXmlApplicationContext("ques1_spring.xml");
		Employee emp = (Employee)factory.getBean("employee");
		
		System.out.println("Set Example");
		emp.printProjects();
		System.out.println("Map Example");
		emp.printProject_with_year();
		System.out.println("This is values from external files ") ;
		emp.showProjectA();

	}

}
