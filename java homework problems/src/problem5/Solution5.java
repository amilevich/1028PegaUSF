package problem5;

import java.util.Arrays;

public class Solution5 {

	public static void main(String[] args) {	
		String strg = substring("daniel kim", 4);
		System.out.println(strg);
	}
	
	public static String substring(String str, int idx) {
		char[] ch = str.toCharArray();
		int i = idx;
		char[] newch = Arrays.copyOfRange(ch, 0, i);
		System.out.println(newch);
		String s = Arrays.toString(newch);
		return s;
	}
}



