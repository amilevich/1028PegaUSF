package yeah.me;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
	
	static final String filename = "./AdminaccObjectFile.txt";
	static ArrayList<account> bank = new ArrayList<account>();

	public static void test() {

		readObject(filename);

		System.out.println("hello how can i help you?\n" + "press 1 to create an account");
		Scanner status = new Scanner(System.in);
		int s = status.nextInt();

		switch (s) {
		case 1:
			makeacc();
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

			account checking = new account(balance, id, username, password, cusna);
			bank.add(checking);
			System.out.println(checking.toString());

			writeObject(filename, bank);
		} else {
			System.out.println("user denied!");
		}
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
			ArrayList<account> object = (ArrayList<account>) ois.readObject();
			
			
			for (account i : object) {
				account blah = new account();
				blah = i;
				bank.add(blah);

				
			}

			for (account i : bank) {
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
