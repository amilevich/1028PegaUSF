package firsthw;

public class Quest2 {
	
	
    static void printFibonacciNumbers() 
    { 
        int f1 = 01;
        int f2 = 0;
        int i; 
      
       
      
        for (i = 1; i <= 25; i++) 
        { 
            System.out.print(f2+" "); 
            int next = f1 + f2; 
            f1 = f2; 
            f2 = next; 
        } 
    }  
      
    
    public static void main(String[] args)  
    { 
        printFibonacciNumbers(); 
    }

}
