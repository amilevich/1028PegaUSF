package problemz18;

public class ChildClass extends SuperClass{
	
	public boolean checkUppercase(String s) {
		String s2 = s.toLowerCase();
		int x = s.compareTo(s2);
		if (x==0) {
			return true;
		} else {
			return false;
		}
	}
	public String convertLower(String s) {
		s.toUpperCase();
		return s;
	}
	public void convertInteger(String s) {
		int i = Integer.parseInt(s);
		i += 10;
		System.out.println(i);
	}

}
