package homework1;

import java.util.ArrayList;

public class QuestitionNineteen {
	
		public void nineteen() {
			Integer even = 0, odd=0; //declaring my variables
			ArrayList<Integer>intArr = new ArrayList<Integer>();//declaring a list
			for(int m = 1; m <= 10; m++) { //iterating the list 
				intArr.add(m);
			}
			//displaying the arraylist
			System.out.println("Regular array list: ");
			for(Integer m : intArr) {
				System.out.print(m + " ");
			}
			for(int c = 0; c < intArr.size(); c++) { 
				//looping the list again
				if(intArr.get(c)%2==0) {
					even += intArr.get(c);
					intArr.remove(c);
				}else {
					odd += intArr.get(c);
				}
				
			}
			System.out.println("\n");
			System.out.println("the sum of even is: " + even);
			System.out.println("the sum of odd is: " + odd);
			System.out.println("thats the arralist without prime: ");
			for(Integer bb : intArr) {
				System.out.print(bb + " ");
			}
		}
	

}
