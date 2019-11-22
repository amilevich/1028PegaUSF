package interview.questions;

public class QEighteen implements QEighteenish {
	
	
	
	public void abstractMethods() {
		containsUpperCase("McDonald's");
		toLowerCase("CZR");
		convertString("999");
		
	}

//	@Override
	public boolean containsUpperCase(String s) {
		char[] charArray = s.toCharArray();
		for (char ch : charArray) {
			if (Character.isUpperCase(ch)) {
				return true;
			}
		}

		return false;
	}

//	@Override
	public String toLowerCase(String s) {

		return s.toUpperCase();
	}

//	@Override
	public void convertString(String s) {
		int convertedString = Integer.parseInt(s) + 10;
		System.out.println(convertedString);

	}

}