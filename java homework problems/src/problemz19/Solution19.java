package problemz19;

import java.util.ArrayList;

public class Solution19 {
	
	
	public static void main(String[] args) {
		int even=0;
		int odd=0;
		//creating an array
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i=0;i<=10;i++) {
			arr.add(i);
		}
		//adding up evens and odds
		for(int a: arr) {
			if(a%2==0) {
				even += a;
			}else {
				odd += a;
			}
		}
		//removing prime numbers
		for(int i=0; i<arr.size();i++ ) {
			if(checkPrime(arr.get(i))) {
				arr.remove(i);
			}
		}
		for(int a:arr) {
			System.out.println(a);
		}
	}
	
	static boolean checkPrime(int n) { 
		for (int i=2; i<n; i++) {
			if (n%i==0) {
				return false;
			}
		}
		return true; 
	}

}
