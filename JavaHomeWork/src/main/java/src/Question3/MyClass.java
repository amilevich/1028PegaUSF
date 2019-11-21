package src.Question3;
/*
 * Reverse a string without using a temporary variable.  
 * Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
 */

public class MyClass {

	public static void main(String[] args) {
		String input = "ButtersStotch";
		
		byte[] ByteArray = input.getBytes();
		byte[] result = new byte [ByteArray.length];
		//reversing the string
		for(int i = 0; i<ByteArray.length; i++)
			result[i] = ByteArray[ByteArray.length-i-1];
		
		System.out.println(new String(result));

	}

}
