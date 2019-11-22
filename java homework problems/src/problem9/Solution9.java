package problem9;
import java.util.ArrayList;

public class Solution9 {

	public static void main(String[] args) {
		returnPrimes();
	}
	
	public static void returnPrimes() {
		ArrayList<Integer> array_num = new ArrayList<>();
		for (int i=1; i<=100; i++) {
			array_num.add(i);
		}
		for (int j=1; j<100; j++) {
			if (checkPrime(array_num.get(j))){
				System.out.println(array_num.get(j));
			}
		}
	}
	
	public static boolean checkPrime(int n) {
		for (int i=2; i<n; i++) {
			if(n%i == 0) {
				return false; 
			}
		}
		return true;
	}
}
