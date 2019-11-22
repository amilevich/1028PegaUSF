package firsthw;

public class quest18p2 extends quest18p3{

	@Override
	public boolean checkCaps(String string) {
		if(string == string.toLowerCase()) {
			return false;
		}
		return true;
	}

	@Override
	public String convertUpperCase(String string) {
		return string.toUpperCase();
	}

	@Override
	public int toInteger(String string) {
		return Integer.parseInt(string);
	}
	
	
	
}
