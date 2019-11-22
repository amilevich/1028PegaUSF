package firsthw;

public class quest5 {
	void substring (String str , int idx) {
		 char[] stringToCharArray = str.toCharArray();
		 System.out.print("Substring Method: ");
		for (int i=0; i<idx-1; i++) { 
		System.out.print(stringToCharArray[i]);
		 }
		System.out.println();
		 }
	
	

}
