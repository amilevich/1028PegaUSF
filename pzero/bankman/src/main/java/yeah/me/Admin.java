package yeah.me;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Employee {
	public String adnam = "kobe";
	public String adpass = "kobe";

	public static void admenu(ArrayList<account> r) {

		System.out.println("hi would you want to 1 view\n2 potentialcus\n3 cancel /0 exit?");
		int choice = Bank.cusnam.nextInt();
		switch (choice) {
		case 1:
			Employee.view(r);
			break;

		case 2:
			Employee.getbusy(r);

			break;
			
		case 3:
			cancel(r);
			break;

		case 0:
			System.out.println("main menu");
			break;

		default:
			System.out.println("try again");
			empmenu(r);
			break;
		}
	}

	public static void cancel(ArrayList<account> r) {
		int temp = 0;
		while (true) {
			System.out.println("what account?");
			String vw = Bank.cusnam.nextLine();
			//Bank.cusnam.nextLine();
			for (account c : r) {
				System.out.println("whdfdfdfdfdfdfdfat account?");
				if (vw.equals(c.getId())) {
					if (c.getStatus()== 1) {
						c.setStatus(0);
						Bank.DAO.updateacc(c);
						System.out.println("Account Closed");
						Bank.DAO.updateacc(c);
						//return; // Doa inserted
					}
					temp = 1;
					break;

				}
			}
			if (temp == 1) {
				break;
			}

		}
	}
}
