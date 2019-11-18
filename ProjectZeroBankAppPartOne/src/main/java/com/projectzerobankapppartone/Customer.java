package com.projectzerobankapppartone;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.apache.log4j.Logger;




public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5397470189109200519L;
	Random randomGenerator = new Random();
//////////////////////Variables/////////////////////
	private String name;
	private String lName;
	private String username;
	private String password;
	private int custID = randomGenerator.nextInt(1000);
	private String strCustID = Integer.toString(custID);
	private int actID = randomGenerator.nextInt(1000);
	private String acttID = Integer.toString(actID);
	private String stat = "pending";
	private double bal = 0.00;
	static String user;
	static String pass;
	final static Logger log = Logger.getLogger(Customer.class);
//////////////////////noargConstrunctor/////////////////////
	public Customer() {
		super();
	}
	
//////////////////////argConstrunctor/////////////////////
	public Customer(String name, String lName, String username, String password, String strCustID, String acttID,
			String stat, double bal) {
		super();
		this.name = name;
		this.lName = lName;
		this.username = username;
		this.password = password;
		this.strCustID = strCustID;
		this.acttID = acttID;
		this.stat = stat;
		this.bal = bal;
	}
	
	//////////////////////Getters/////////////////////
	//this method retrieves the customers first name
		public String getName() {
			return name;
		}
	//method that retrieves the customers last name
		public String getlName() {
			return lName;
		}
		//this method retrieves the customers username
		public String getUsername() {
			return username;
		}
		public String getPassword() {
			return password;
		}
		public String getCustID() {
			return strCustID;
		}
		public String getActtID() {
			return acttID;
		}
		public String getStat() {
			return stat;
		}
		public double getBal() {
			return bal;
		}
//////////////////////Setters/////////////////////
		public void setActtID(String acttID) {
			this.acttID = acttID;
		}
		
		public void setStat(String stat) {
			this.stat = stat;
		}
		public void setBal(double bal) {
			this.bal = bal;
		}
		//this method sets the customers first name
		public void setName(String name) {
			this.name = name;
		}
		//this method sets the customers last name
		public void setlName(String lName) {
			this.lName = lName;
		}
		//this method sets the customers username
		public void setUsername(String username) {
			this.username = username;
		}
		//this method sets the customers password
		public void setPassword(String password) {
			this.password = password;
		}
		//this method sets the customers ID
		public void setCustID(String strCustID) {
			this.strCustID = strCustID;
		}
//////////////////////toString/////////////////////
		@Override
		public String toString() {
			return "Customer name: " + name + ", Last name: " + lName + ", Username: " + username + ", Password: " + password
					+ ", Customer ID: " + strCustID + ", Account ID: " + acttID + ", Status: " + stat + ", Balance: " + bal;
		}
		public static void customerSignIn() {
			Scanner signin = new Scanner(System.in);

			System.out.print("Enter username: ");
			user = signin.next();
			System.out.print("Enter password: ");
			pass = signin.next();
			System.out.println("_______________________________________________________________________");
			for (int j = 0; j < Account.pendingCustomers.size(); j++) {
				if (Account.pendingCustomers.get(j).getUsername().contains(user)
						&& Account.pendingCustomers.get(j).getPassword().contains(pass)) {
					System.out.println(Account.pendingCustomers.get(j).toString().replaceAll("^.|.$", "").replace(", ", "\n"));
					log.info("You are now signed in");
					Account.CustMenu();
				}
			}
			log.info("Username or password incorrect");
			//System.out.println("username or password incorrect");
			customerSignIn();
		}
//////////////////////write and read objects/////////////////////
		public static void writeObject(String filename, Object obj) {
			try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
				oos.writeObject(obj);
			}catch(IOException io) {
				io.printStackTrace();
			}
		}
		public static void readObject(String filename) {
			try(ObjectInputStream os = new ObjectInputStream(new FileInputStream(filename))){
				Account.pendingCustomers = (ArrayList<Customer>)os.readObject();
			}catch(IOException exception) {
				exception.printStackTrace();
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		public static void writeObject2(String ff, Object ob) {
			try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ff))){
				oos.writeObject(ob);
			}catch(IOException io) {
				io.printStackTrace();
			}
		}
		public static void readObject2(String ff) {
			try(ObjectInputStream os = new ObjectInputStream(new FileInputStream(ff))){
				Account.jointCustomers = (ArrayList<Customer>)os.readObject();
			}catch(IOException exception) {
				exception.printStackTrace();
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
//////////////////////argConstrunctor/////////////////////
}
