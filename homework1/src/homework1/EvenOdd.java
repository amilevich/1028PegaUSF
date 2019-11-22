package homework1;

import java.util.Scanner;
//class
public class EvenOdd {
	//method
	public static void evenodd(){
		 //declare variables and create object for class scanner
	    int number;
	    Scanner in= new Scanner(System.in);
	 
	    System.out.println("Enter a number to check even or odd");
	    number=in.nextInt();
	    //condition execute if even
	    if((number /2)*2==number){
	        System.out.println(+number+" is Even number");
	        //execute if odd
	    }else{
	        System.out.println(+number+" is Odd Number");
	    }
	 
	}

}
