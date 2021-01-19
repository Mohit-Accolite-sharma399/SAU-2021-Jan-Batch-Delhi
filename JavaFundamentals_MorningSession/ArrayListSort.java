import java.io.*; 
import java.util.*; 
  
class ArrayListSort { 
    public static void main(String[] args) 
    { 

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the List: ");
        int n=sc.nextInt();         //Size of the ArrayList 
        ArrayList<Integer> arr= new ArrayList<Integer>(n);
        System.out.println("Enter "+n+" elements in the list: "); 
        for (int i=0;i<n; i++) 
        {
            int j=sc.nextInt(); 
            arr.add(j); 
        }
        // Printing unsorted elements   
        System.out.println("Input List is given below:");
        for (int i = 0; i < arr.size(); i++) 
            System.out.print(arr.get(i) + " ");
        Collections.sort(arr); 
       System.out.println("");
        // Printing sorted elements  
        System.out.println("Sorted List is given below:");
        for (int i = 0; i < arr.size(); i++) 
            System.out.print(arr.get(i) + " ");     
    } 
} 