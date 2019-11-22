package problemz13;

public class Solution13 {
	public static void main(String[] args) {
		String s = "0";
		System.out.println(s);
		for (int i=0; i<1; i++) {
			s = "1" + s;
			System.out.println(s);
			for(int j=0; j<1; j++) {
				s = s + "1";
				System.out.println(s);
			}
		}
		System.out.println("0"+s);
	}
}
