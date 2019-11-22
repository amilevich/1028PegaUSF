package firsthw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class quest8 {
	
	public static void main(String[] args) {
		 
		ArrayList<String> first = new ArrayList<>(Arrays.asList("karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy", "did"));
		ArrayList<String> sec = new ArrayList<>();
		
		for(int i=0; i<first.size(); i++) {
			String check = reverseInput(first.get(i));
			if(check.contentEquals(first.get(i))) {					
				sec.add(first.get(i));							
			}
		}
		
		ListIterator<String> trippy2 = sec.listIterator();
		System.out.println("New List");
		while(trippy2.hasNext()) {
			System.out.print(trippy2.next() + " ");
		}
	}
	
	private static String reverseInput (String value) {
		String temp = "";
		for(int i = value.length()-1; i>=0;i--) {
			temp+=value.charAt(i);
		}
		return temp;

		
		

	}
}
