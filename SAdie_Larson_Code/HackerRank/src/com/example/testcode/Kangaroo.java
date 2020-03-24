package com.example.testcode;

public class Kangaroo {

	static String kangaroo(int x1, int v1, int x2, int v2) {
		int maxPos = 0;
		if (x1 > x2) {
			maxPos = x1;
		} else {
			maxPos = x2;
		}
		if ((x2 > x1 && v2 > v1) || (x1 > x2 && v1 > v2)) {
			System.out.println("NO");
			return "NO";
		} else {
			int pos1 = x1 + v1;
			int pos2 = x2 + v2;
			for (int i = 0; i < 10000; i++) {
				if (i != 0) {
					pos1 += v1;
					pos2 += v2;
				}
				if ((pos1 + i) == (pos2 + i)) {
					return "YES";
				}
			}
			System.out.println("NO");
			return "NO";
		}

	}

	public static void main(String[] args) {
		System.out.println(kangaroo(2081, 8403, 9107, 8400));
	}

}
