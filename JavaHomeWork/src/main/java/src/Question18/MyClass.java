package src.Question18;

public class MyClass extends AbstractString {

	public MyClass(String myString) {
		this.myString = myString;
	}

	@Override
	public boolean isUpperCase() {
		String lowerString = myString.toLowerCase();
		boolean equal = lowerString.equals(myString);
		if(equal) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public String convertToUpper() {
		return myString.toUpperCase();
	}

	@Override
	public int convertToInt() {
		int num = 24;
		for(int i = 0; i<myString.length();i++){
            num = num + (int)myString.charAt(i);
        }
        return num;
	}
}
