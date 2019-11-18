package yeah.me;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class employee {
	static Scanner cusnam = new Scanner(System.in);
	static final String filename = "./EmpaccObjectFile.txt";
	static ArrayList<account> bank = new ArrayList<account>();
	static ArrayList<customer> cust = new ArrayList<customer>();

	public static void test() {

		readObject(filename);

		System.out.println("hello how can i help you?\n" + "press 1 to create an account\n press 2 to log in.");
		Scanner status = new Scanner(System.in);
		int s = status.nextInt();

		switch (s) {
		case 1:
			makeacc();
			break;
		case 2:
			login();
			break;

		default:
			System.out.println("try again");
			break;
		}
	}

	static void makeacc() {

		Scanner cusnam = new Scanner(System.in);

		System.out.println("what is your name?");
		String cusna = cusnam.nextLine();
		System.out.println(cusna);

		System.out.println("what is your income");
		int inc = cusnam.nextInt();

		if (inc > 1000) {
			boolean approve;

			System.out.println("would u like like to add to ur balance?");
			double balance = cusnam.nextInt();
			System.out.println("ok u deposited $" + balance);
			cusnam.nextLine();
			System.out.println("set id");
			String id = cusnam.nextLine();
			System.out.println(id);

			System.out.println("create ur username");
			String username = cusnam.next();
			System.out.println(username);

			System.out.println("create a password");
			String password = cusnam.next();
			System.out.println(password);

			customer one = new customer(0, id, username, password, cusna);
			one.setBalance(balance);
			one.setId(id);
			one.setPassword(password);
			one.setPassword(password);
			one.setCusna(cusna);
			// account checking = new account(balance, id, username, password, cusna);
			// bank.add(checking);
			cust.add(one);
			System.out.println(one);

			writeObject(filename, cust);
		} else {
			System.out.println("user denied!");
		}
	}

	static void login() {
		String temp = "";

		System.out.println("1single or 2joint");
		int j = cusnam.nextInt();
		cusnam.nextLine();
		while (true) {
			int flag = 0;
			int sj = 0;

			System.out.println("please enter username.");
			String usern = cusnam.nextLine();
			System.out.println("please enter password.");
			String pass = cusnam.nextLine();
			if (j == 1) {
				for (customer i : cust) {
					if (i.getUsername().equals(usern) && i.getPassword().equals(pass)) {
						temp = i.getCusna();
						flag++; // flag is 1 meaning username is correct
						sj = i.customerOptions(i);
						System.out.println("bfb" + sj);
						writeObject(filename, cust);
						break;
					}
				}
			} else {

				for (customer i : cust) {
					if ((i.getUsern1().equals(usern) && i.getPass1().equals(pass))
							|| (i.getUsern2().equals(usern) && i.getPass2().equals(pass))) {
						temp = i.getCusna();
						flag++; // flag is 1 meaning username is correct
						sj = i.customerOptions(i);
						writeObject(filename, cust);
						System.out.println("bfb" + sj);
						break;
					}
				}
			}
			System.out.println(sj);
			if (sj == 2) {
				cusnam.nextLine();
				System.out.println("set id");
				String id = cusnam.nextLine();
				System.out.println(id);
				while (true) {
					System.out.println("please enter username.");
					String usern2 = cusnam.nextLine();
					System.out.println("please enter password.");
					String pass2 = cusnam.nextLine();
					for (customer z : cust) {
						if (z.getUsername().equals(usern2) && z.getPassword().equals(pass2) && usern != usern2) {
							customer jane = new customer(0, id, usern, pass, temp, usern2, pass2);
							cust.add(jane);
							flag++;
							writeObject(filename, cust);
							System.out.println(jane);
							break;
						}
					}
					if (flag == 2) {
						break;
					}
				}
			} else if (sj == 3) {
				while (true) {
					int flag3 = 0;
					System.out.println("who do you want to send money to?");
					String who = cusnam.nextLine();
					for (customer w : cust) {
						if (w.getId().equals(who)) {
							System.out.println("who much you want to send?");
							while (true) {
								int cash = cusnam.nextInt();
								for (customer c : cust) {
									if (c.getUsername().equals(usern)) {
										if (cash > c.getBalance()) {
											System.out.println("funds dont add up!!!");
										} else {
											w.setBalance(cash + w.getBalance());
											c.setBalance(c.getBalance() - cash);
											flag3++;
											writeObject(filename, cust);
											System.out.println(cust);
											break;
										}
									}
								}
								if (flag3 > 0) {
									break;
								}
							}
						}
					}
					if (flag3 > 0) {
						break;
					}
				}
				System.out.println("flag" + flag);
				
			}
			System.out.println("flag" + flag);
			
			if (flag > 0) {
				break;
			}
			
		}
		test();
	}

	static void writeObject(String filename, Object obj) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(obj);
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	static void readObject(String filename) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			ArrayList<customer> object = (ArrayList<customer>) ois.readObject();
			for (customer i : object) {
				customer blah = new customer();
				blah = i;
				cust.add(blah);
			}
			for (account i : cust) {
				System.out.println(i);
			}
		} catch (FileNotFoundException we) {
			System.out.println("you dont need his identification");

		} catch (IOException exception) {
			exception.printStackTrace();

		} catch (ClassNotFoundException anything) {
			anything.printStackTrace();
		}

	}

}
