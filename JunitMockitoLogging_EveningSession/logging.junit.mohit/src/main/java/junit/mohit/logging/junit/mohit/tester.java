package junit.mohit.logging.junit.mohit;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class tester {
	   @InjectMocks 
	   calculator calc= new calculator();
	   @Mock
	   services service;
	   @Test
	   public void testAdd(){
		      when(service.add(10.0,20.0)).thenReturn(30.00);
		      Assert.assertEquals(calc.add(10.0, 20.0),30.0,0);
	   }
	   @Test
	   public void testSubtract() {
		      when(service.subtract(30.0,20.0)).thenReturn(10.00);
		      Assert.assertEquals(calc.subtract(30.0, 20.0),10.0,0);
	   }
	   @Test
	   public void testMultiply() {
		      when(service.multiply(10.0,20.0)).thenReturn(200.00);
		      Assert.assertEquals(calc.multiply(10.0, 20.0),200.00,0);
	   }
	   @Test
	   public void testDivide() {
		      when(service.divide(20.0,10.0)).thenReturn(30.00);
		      Assert.assertEquals(calc.divide(20.0, 10.0),2.0,0);
	   }
}
