package Q16StringInputLength;

public class StringInputLength {

	public static void main(String[] args) {
		//System.out.println("The string has "+args[0].length()+" characters.");
		
		//String test[] = {"testing", "the", "logic"};
		//System.out.println("The string has "+test[0].length()+" characters.");
		
		try {
			System.out.println("\nThe string has "+args[0].length()+" characters.");
		}
		catch(Exception e)
		{
			System.out.println("\nThere was no string provided to display the length of.");
		}
			
	}

}
