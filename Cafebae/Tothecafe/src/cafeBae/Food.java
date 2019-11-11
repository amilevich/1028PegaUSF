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
	
	

	Scanner Fd =new Scanner(System.in);
	String cus = Fd.nextLine();
	switch (cus)  {
	case "sprite":
		
		System.out.println("added sprite");
		m.add(sprite);
		System.out.println("Queue: " + m);
		break;
		
	case"donuts":
		int donutPrice = Donuts.price;
		System.out.println(donutPrice);

		m.add(Donuts);
		System.out.println("added donut");
		System.out.println("Queue: " + m);
		break;
		
	case"fruit":
		m.add(Fruit);
		System.out.println("added fruit");
		System.out.println("Queue: " + m);
		break;
		
	case"done":
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

