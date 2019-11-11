package cafeBae;

import java.util.LinkedList;
import java.util.Queue;

public class Customer extends Food{

	public static void custy() {

		Queue<Integer> hd = new LinkedList<Integer>();
		for (int i = 1; i < 4; i++) {
			hd.add(i);
			Food.menu();
			System.out.println("customer number is " +i);

			for(int y = 0; y<-i;y++)
			System.out.println("what do you want?");

		}
		custy();
	}
}
