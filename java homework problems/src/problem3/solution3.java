package problem3;

public class solution3 {

	
	public static StringBuffer reverseString(String s) {
		StringBuffer str = new StringBuffer(s); 
		int strLength = str.length();
		for (int i=strLength-1; i>=0; i--) {
			str.append(str.charAt(i));
		}
		str.delete(0, strLength);
		return (str);
	}
	
	public static void main(String[] args) {
		String s = "string";
		System.out.println(reverseString(s));
	}
	
}
