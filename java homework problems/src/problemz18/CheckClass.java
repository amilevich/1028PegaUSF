package problemz18;

public class CheckClass {
	
	public static void main(String[] args) {
		ChildClass ob = new ChildClass();
		boolean b = ob.checkUppercase("asDFadsf");
		System.out.println("checkIpper: " + b);
		String s = ob.convertLower("adfasdf");
		System.out.println("ConverLower: " + s);
		ob.convertInteger("10");
	}

}
