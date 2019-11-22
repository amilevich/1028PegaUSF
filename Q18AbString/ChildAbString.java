package Q18AbString;

public class ChildAbString extends AbString {

	@Override
	boolean checkUpper(String s) {
		for (int i=0; i<s.length();i++){
			if (java.lang.Character.isUpperCase(s.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	@Override
	String convertToUpper(String s) {
		String result = s.toUpperCase();
		return result;
	}

	@Override
	void convertIntPlusTen(String s) {
		int i = 10;
		Integer result = Integer.valueOf(s);
		System.out.print("The converted string plus ten is: ");
		System.out.println(i+result);
		
	}

}
