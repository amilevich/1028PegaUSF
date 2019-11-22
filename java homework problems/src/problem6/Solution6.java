package problem6;

public class Solution6 {
	
	public static String evenOrOdd(double num) {
		double r = num/2;
		int x = (int)r;
		double dif = x-r;
		if(dif == 0) {
			return "even";
		}else {
			return "odd";
		}
	}
	public static void main(String[] args) {
		System.out.println(evenOrOdd(5));
		System.out.println(evenOrOdd(6));
		System.out.println(evenOrOdd(7));
		System.out.println(evenOrOdd(8));
	}
}
