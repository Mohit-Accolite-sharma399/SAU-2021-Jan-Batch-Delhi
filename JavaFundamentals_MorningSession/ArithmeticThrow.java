import java.util.*;
public class ArithmeticThrow
{  
   static void validate(int x,int y)throws ArithmeticException
   {  
      if(y==0)  
        throw new ArithmeticException("Error! Denominator can not be zero");  
     else  
      System.out.println(x/y); 
   }   
   public static void main(String args[])
   {  
      int m,n;
      Scanner sc=new Scanner(System.in);
      n=sc.nextInt();
      m=sc.nextInt();
      try
      {
         validate(m,n);
      }
      catch(ArithmeticException e)
      {
         System.out.println(e.getMessage());
      }  
   } 
}