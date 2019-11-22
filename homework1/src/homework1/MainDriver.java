package homework1;

public class MainDriver {

	public static void main(String[] args) {
		System.out.println("Question # 1 This is the bublesort answer");
		System.out.println("****************************************************");
		
		 BubbleSort leroy = new BubbleSort();
		    int arr[] = {1,0,5,6,3,2,3,7,9,8,4};
		    leroy.bubbleSort(arr);
		    System.out.println("--- Bubble Sort Answer---");
		    leroy.printArray(arr);
		    System.out.println();
		    System.out.println("Question # 2 This is the Fibonacci answer");
		    System.out.println("----fibonacci Answer----");
		    System.out.println("****************************************************");
		    Fibonaci f=new Fibonaci();
		    f.printFibonacciNumbers(25);
		    System.out.println("---Question # 3 this is the the factorial ---");
		    
		    Factorial obj = new Factorial();
		    int num = 5;
		    System.out.println("Factorial of " + num + 
		                      " is " + obj.factorial(num));
		    System.out.println("------------------------------------");
		    
		    
		    
		    System.out.println("---Question # 6 this is the Even or odd ---");
		   homework1.EvenOdd.evenodd();
		   
		   
		   
		   System.out.println("------------------------------------");
		   System.out.println();
		    
		   
		   
		   
		   
		   System.out.println();
		   	Factorial fa = new Factorial();
		   	fa.factorial(6);
		   	System.out.println();
		   	//EvenOdd.evenodd();
		   	System.out.println();
		   	System.out.println("Question # 8 This is the palindrom answer");
			System.out.println("****************************************************");
			
		   	Palindrom.palindrom();
		   	System.out.println();
		   	
		   	System.out.println("Question # 9 This is the Prime number answer");
			System.out.println("****************************************************");
			PrimeNumber d= new PrimeNumber();
		   	d.primeNumber();
			System.out.println("Question # 10 This is the tenary answer");
			System.out.println("****************************************************");
			Tenary.tenary();
		   	System.out.println();
		   	
		   	System.out.println();
		   	System.out.println("******question #11 These are the float numbers");
		   	TwoFloat.float1();
		   	System.out.println("******question #12 This is the even****");
		   	Even n = new Even();
		   	n.even();
		   	System.out.println();
		   	System.out.println("****Question # 13 *my triangle******");
		   	Triangle t = new Triangle();
		   	t.triangle();
		   	System.out.println();
		   	System.out.println("****question 18 the interest rate*********");
		   	SwitchStatemen z = new SwitchStatemen();
		   	z.switchStatement();
		   	Operations k = new Operations();
		   	k.add(7, 8);
		   	k.div(10, 2);
		   	k.mult(6, 3);
		   	k.sub(9, 8);
		   	
		   	Interest i = new Interest();
		   	i.interest();
		   	System.out.println();
		   	System.out.println("****question 20 the interest rate*********");
		   	
		   	
		   	System.out.println("****question 19 the interest rate*********");
		   	QuestitionNineteen que = new QuestitionNineteen();
		   	que.nineteen();
		   	System.out.println();
		   	System.out.println("**********question #5*************");
		    Substring sub = new Substring();
		    sub.substring1();
		   	System.out.println("****question 20 the interest rate*********");

		    System.out.println();
		    CreateFile fi = new CreateFile();
		   	fi.readc();
//		   	
		   	
		   	
		    
		    
		    
		    

	}

}
