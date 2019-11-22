package firsthw;

import java.util.Scanner;

public class Quest3 {
	
		public static void main(String[] args) {
			Reverse();
		}


		public static void Reverse() {
			
			System.out.println("Write a phrase.");
			Scanner sc = new Scanner(System.in);

			String bk = sc.nextLine();

			for (int i = 0; i < bk.length(); i++) {
				bk = bk.substring(1, bk.length() - i) 
						+ bk.substring(0, 1)  
						+ bk.substring(bk.length() - i, bk.length()); 
			}
			System.out.println(bk);
		}
	}




