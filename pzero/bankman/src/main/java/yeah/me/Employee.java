package yeah.me;

import java.util.ArrayList;

public class Employee {
	public String empnam = "shaq";
	public String emppass = "shaq";

	public static void empmenu(ArrayList<account> r) {
		System.out.println("hi would you want to 1view/ 2potentialcus /0 exit?");
		int choice = Bank.cusnam.nextInt();
		switch (choice) {
		case 1:
			view(r);
			break;

		case 2:
			getbusy(r);

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

	public static void getbusy(ArrayList<account> x) {
		int temp = 0;
		while (temp ==0) {
			System.out.println("what account?");
			String vw = Bank.cusnam.nextLine();
			for (account c : x) {
				System.out.println(c.toString() + "test");
				if (vw.equals(c.getId())) {
					c.setStatus(1);
					Bank.DAO.updateacc(c);
					System.out.println("Account Approved");
					temp = 1;
					return;

				}
			}
			if (temp == 1) {
				break;
			}

		}
	}

		
	

	public static void view(ArrayList<account> r) {
		int temp = 0;
		while (true) {
			System.out.println("what account?");
			String vw = Bank.cusnam.nextLine();
			for (account c : r) {
				if (vw.equals(c.getId())) {
					System.out.println(c.getId()+ " $"+ c.getBalance()+" "+c.getStatus());
					System.out.println(temp);
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
