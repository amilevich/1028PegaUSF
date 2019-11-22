package problemz10;

public class Solution10 {
	
	public static void main(String[] args) {
		System.out.println(min(5,4));
	}
	
	public static int min(int a, int b) {
		int min = a <= b ? a:b;
		return min; 
	}

}
