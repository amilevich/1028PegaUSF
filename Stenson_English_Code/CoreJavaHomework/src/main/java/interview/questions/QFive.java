package interview.questions;

public class QFive {
	public static void main(String[] args) {
		subString("cheese",4);
	}

	public static String subString(String str,int idx) {
		
		for( idx = 1; idx < str.length()-1;idx++) {
			System.out.print(str.charAt(idx));
		}
		return str;
	}
}
