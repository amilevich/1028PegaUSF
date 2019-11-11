package cafeBae;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Food {
	
	

public static void menu() {


boolean ordering = true;{

BigAle sprite = new BigAle("Sprite", 2 ,"lg",true);
BigAle Donuts = new BigAle("Donuts", 3 ,"sm",false);
BigAle Fruit = new BigAle("Fruit", 5 ,"med",false);
	
System.out.println("hello what would u like to eat?");

Queue<BigAle> m = new LinkedList<BigAle>();
do {
	System.out.println("enter 1 for Sprite ");
	System.out.println("enter 2 for Donuts ");
	System.out.println("enter 3 for Fruit");
	System.out.println("enter 0 when Done");
	

	Scanner Fd =new Scanner(System.in);
	String cus = Fd.nextLine();
	switch (cus)  {
	case "1":
		
		System.out.println("added sprite");
		m.add(sprite);
		System.out.println("Queue: " + m);
		break;
		
	case"2":
		int donutPrice = Donuts.price;
		System.out.println(donutPrice);

		m.add(Donuts);
		System.out.println("added donut");
		System.out.println("Queue: " + m);
		break;
		
	case"3":
		m.add(Fruit);
		System.out.println("added fruit");
		System.out.println("Queue: " + m);
		break;
		
	case"0":
		System.out.println("your order is " +m);
		int size = m.size();
		System.out.println("size of queue is " + size);

		ordering = false;
		
		break;
		
		

	default:
		System.out.println("order not found");
		break;
	}
}
	while(ordering);{
		
	}
	
	

}
}
}

