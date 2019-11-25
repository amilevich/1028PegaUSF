package com.bank.simulation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import org.apache.log4j.Logger;


public class Bank {
	
	private static Logger loggy=Logger.getLogger(Bank.class);

	private ArrayList<Account> accounts;
	private String prompt;
	private String user;
	private String password;
	private int authority;
	
	public Bank() {
		this.accounts = new ArrayList<Account>();
		this.prompt="bank>";
		this.user="";
		this.password="";
		this.authority=0;
	}
	//testing method unused
	public int sum(int x, int y) {
		int sum = x+y;
		System.out.println(sum);
		return sum;
	}
	
	//Getters and Setters
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
	public String getPrompt() {
		return prompt;
	}
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	
	// Get account object from user name 
	public Account GetAccount(String name) {
		for(Account account : accounts){
			if(account.getName().equals(name)){
				return account;
			}
		}
		return null;
	}
	
	//Check the existing of the given user name
	public boolean Exists(String name){
		for(Account account : accounts){
			if(account.getName().equals(name)){
				return true;
			}
		}
		return false;
	}
	
	//Register account from the line data of store file
	public boolean Register(String account_info) {
		String[] items=account_info.split(" ");
		Register(Integer.parseInt(items[2]),items[0],items[1]);
		Deposit(items[0],Double.parseDouble(items[3]));
		for(Account account : accounts){
			if(account.getName().equals(items[0])){
				account.setJoinName(items[4]);
			}
		}
		return true;
	}
	
	//Register account from auth, name, password
	public boolean Register(int auth, String name, String password){
		if(Exists(name)) return false;
		accounts.add(new Account(auth, name, password));
		return true;
	}
	
	//Deposit by name, qty
	public Double Deposit(String name, Double qty) {
		for(Account account : accounts){
			if(account.getName().equals(name)){
				return account.Deposit(qty);
			}
		}
		return 0.0;
	}
	
	//Withdraw by name, qty
	public Double Withdraw(String name, Double qty) {
		for(Account account : accounts){
			if(account.getName().equals(name)){
				return account.Withdraw(qty);
			}
		}
		return 0.0;
	}
	
	//Deny the giver account
	public boolean Deny(String name) {
		for(Account account : accounts){
			if(account.getName().equals(name)&&account.getAuthority()==1) {//customer:1
				account.setState(0);
				return true;
			}
		}
		return false;
	}
	
	//Allow the given account
	public boolean Allow(String name) {
		for(Account account : accounts){
			if(account.getName().equals(name)&&account.getAuthority()==1) {
				account.setState(1);
				return true;
			}
		}
		return false;
	} 
	
	//Remove the given account
	public boolean Cancel(String name) {
		for(Account account : accounts){
			if(account.getName().equals(name)&&account.getAuthority()==1) {
				accounts.remove(account);
				return true;
			}
		}
		return false;
	}
	
	//Join joiner to customer
	public boolean Join(String name, String join_name) {
		if(!Exists(join_name)) {
			return false;
		}
		for(Account account : accounts){
			if(account.getName().equals(name)&&account.getAuthority()==2) {//joiner:2
				account.setJoinName(join_name);
				//account.setName(join_name);
				return true;
			}
		}
		return false;
	}
	//write 
	public void writeAccounts(String filename)  {
		String content="";
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
			for (Account  a : accounts)	{
				content+=a.getName()+" "+a.getPassword()+" "+Integer.toString(a.getAuthority())+" "+a.getBalance().toString()+" "+a.getJoinName()+ "\r\n";
			}
			oos.writeObject(content);
		}catch(IOException io) {
			io.printStackTrace();
		}
	}
	//read 
	public void readAccounts(String filename) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
			Object object = ois.readObject();
			System.out.println(object);
		}catch(IOException exception) {
			exception.printStackTrace();
		}catch(ClassNotFoundException anything) {
			anything.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {

		
		String AUTH[]= {"NONE","CUSTOMER","JOINER","EMPLOYEE","ADMIN"};
		
		System.out.println("Bank simulation started!");
		Bank bank=new Bank();
		Scanner in = new Scanner(System.in);
		while(true){
			System.out.print(bank.getPrompt());//Write prompt
			String[] cmd = in.nextLine().split("\\s+");//Read user input
			String cmd_line="";
			for(String str:cmd) {//Convert String[] to String
				cmd_line+=str+" ";
			}
			loggy.info(cmd_line);//Write logo
			switch(cmd[0]) {
				case "register":
					if(cmd.length!=4) {// create auth name password
						System.out.println("Invalid command! Please enter command 'help'!");
						break;
					}
					if(cmd[1].equals("customer")) {
						if(!bank.Register(1,cmd[2],cmd[3])) {
							System.out.println("'"+cmd[2]+"' existing! Register failed!");
							break;
						};
						System.out.println("Customer '"+cmd[2]+"' registered!");
					}
					else if(cmd[1].equals("joiner")) {
						if(!bank.Register(2,cmd[2],cmd[3])) {
							System.out.println("'"+cmd[2]+"' existing! Register failed!");
							break;
						};
						System.out.println("Joiner '"+cmd[2]+"' registered!");
					}
					else if(cmd[1].equals("employee")) {
						if(!bank.Register(3,cmd[2],cmd[3])) {
							System.out.println("'"+cmd[2]+"' existing! Register failed!");
							break;
						};
						System.out.println("Employee '"+cmd[2]+"' registered!");
					}
					else if(cmd[1].equals("admin")) {
						if(!bank.Register(4,cmd[2],cmd[3])) {
							System.out.println("'"+cmd[2]+"' existing! Register failed!");
							break;
						};
						System.out.println("Admin '"+cmd[2]+"' registered!");
					}
					else {
						System.out.println("Invalid register command!");
						break;
					}
					break;
				case "join":
					if(cmd.length!=2) {//join join_name
						System.out.println("Invalid command! Please enter command 'help'!");
						break;
					}
					if(bank.getAuthority()!=2) {
						System.out.println("Invalid authority!");
						break;
					}
					if(bank.Join(bank.getUser(), cmd[1])) {
						System.out.println("Join successed!");
					}
					else {
						System.out.println("Join failed!");
					}
					break;
				case "open":
					if(cmd.length!=3) {//login name password
						System.out.println("Invalid command! Please enter command 'help'!");
						break;
					}
					if(cmd[1].equals("super") && cmd[2].equals("super")) {
						bank.setUser("super");
						bank.setPassword("super");
						bank.setAuthority(4);
						bank.setPrompt("bank>SUPER ADMIN super>");
						break;
					}
					if(!bank.Exists(cmd[1])) {
						System.out.println("Invalid account!");
						break;
					}
					Account account=bank.GetAccount(cmd[1]);
					if(account.getPassword().equals(cmd[2])) {
						if(account.getState()==0) {
							System.out.println(account.getName()+" account denied!");
						}
						else {
							bank.setUser(cmd[1]);
							bank.setPassword(cmd[2]);
							bank.setAuthority(account.getAuthority());
							bank.setPrompt("bank>"+AUTH[account.getAuthority()]+" "+cmd[1]+">");
						}
					}
					else {
						System.out.println("Invalid account!");
					}
					break;
				case "close":
					bank.setUser("");
					bank.setPassword("");
					bank.setAuthority(0);
					bank.setPrompt("bank>");
					break;
				case "deposit":
					if(cmd.length!=2) {//deposit qty
						System.out.println("Invalid command! Please enter command 'help'!");
						break;
					}
					Double qty=Double.parseDouble(cmd[1]);
					if(bank.getAuthority()==1) {
						Double new_qty=bank.Deposit(bank.getUser(), qty);
						System.out.println(qty.toString()+" deposited. Current balance is "+new_qty.toString());
						break;
					}
					else if(bank.getAuthority()==2) {
						if(bank.GetAccount(bank.getUser()).getJoinName().equals("nobody")) {
							System.out.println("Joiner must join to other customer!");
							break;
						}
						Double new_qty=bank.Deposit(bank.GetAccount(bank.getUser()).getJoinName(), qty);
						System.out.println(qty.toString()+" deposited. Current balance is "+new_qty.toString());
						break;
					}
					else {
						System.out.println("Invalid authority!");
						break;
					}
						
				case "withdraw":
					if(cmd.length!=2) {//withdraw qty
						System.out.println("Invalid command! Please enter command 'help'!");
						break;
					}
	
					Double qty1=Double.parseDouble(cmd[1]);
					Account account2=bank.GetAccount(bank.getUser());
					if(bank.getAuthority()==1) {
						if(qty1>account2.getBalance()) {
							System.out.println("Balance "+account2.getBalance().toString()+ ", can't withdraw "+qty1.toString());
							break;
						}
						//calling Withdraw method
						Double new_qty1=bank.Withdraw(bank.getUser(), qty1);
						System.out.println(qty1.toString()+" withdrawed. Current balance is "+new_qty1.toString());
					}
					else if(bank.getAuthority()==2) {
						if(account2.getJoinName().equals("nobody")) {
							System.out.println("Joiner must join to other customer!");
							break;
						}
						if(qty1>bank.GetAccount(account2.getJoinName()).getBalance()) {
							System.out.println("Balance "+bank.GetAccount(account2.getJoinName()).getBalance().toString()+ ", can't withdraw "+qty1.toString());
							break;
						}
						Double new_qty1=bank.Withdraw(bank.GetAccount(account2.getJoinName()).getName(), qty1);
						System.out.println(qty1.toString()+" withdrawed. Current balance is "+new_qty1.toString());
					}
					else {
						System.out.println("Invalid authority!");
						break;
					}
					break;
				case "transfer":
					if(cmd.length!=3) {//transfer qty target_account_name
						System.out.println("Invalid command! Please enter command 'help'!");
						break;
					}
					if(bank.getAuthority()!=1) {
						System.out.println("Invalid authority!");
						break;
					}
					Double qty2=Double.parseDouble(cmd[1]);
					Account account3=bank.GetAccount(bank.getUser());
					if(qty2>account3.getBalance()) {
						System.out.println("Balance "+account3.getBalance().toString()+ ", can't transfer "+qty2.toString());
						break;
					}
					if(!bank.Exists(cmd[2])) {
						System.out.println(cmd[2]+" account not exists!");
						break;
					}
					Double new_qty2=bank.Withdraw(bank.getUser(), qty2);
					Double qty3=Double.parseDouble(cmd[1]);
					Double new_qty3=bank.Deposit(cmd[2], qty3);
					System.out.println(qty2.toString()+" transfered to "+cmd[2]);
					System.out.println(bank.getUser()+" balance : "+new_qty2.toString());
					System.out.println(cmd[2]+" balance : "+new_qty3.toString());
					break;
				case "view":
					if(cmd.length!=1) {
						System.out.println("Invalid command! Please enter command 'help'!");
						break;
					}
					if(bank.getAuthority()==0) {
						System.out.println("Invalid authority!");
						break;
					}
					//view under certain authority
					Account account1=bank.GetAccount(bank.getUser());
					System.out.println("authority : "+ AUTH[account1.getAuthority()]);
					System.out.println("name : "+ account1.getName());
					System.out.println("password : "+ account1.getPassword());
					if(account1.getAuthority()==1) {
						System.out.println("balance : "+ account1.getBalance().toString());
					}
					if(account1.getAuthority()==2) {
						System.out.println("join_name : "+ account1.getJoinName());
					}
					break;
				case "view_all":
					if(cmd.length!=1) {//view_all except customers can view it
						System.out.println("Invalid command! Please enter command 'help'!");
						break;
					}
					if(bank.getAuthority()==0 || bank.getAuthority()==1) {
						System.out.println("Invalid authority!");
						break;
					}
					for(Account account4 : bank.getAccounts())
					{
						if(account4.getAuthority()==1){
							String stat="";
							if(account4.getState()==0)
								stat="DENY";
							else 
								stat="ALLOW";
							System.out.println("authority:"+AUTH[account4.getAuthority()]+",name:"+account4.getName()+", password:"+account4.getPassword()+", balance:"+account4.getBalance().toString()+", state:"+stat);
						}
					}
					break;
				case "deny":
					if(cmd.length!=2) {//deny account_name
						System.out.println("Invalid command! Please enter command 'help'!");
						break;
					}
					if(bank.getAuthority()==0 || bank.getAuthority()==1) {
						System.out.println("Invalid authority!");
						break;
					}
					if(bank.Deny(cmd[1])) {
						System.out.println(cmd[1]+" denied!");
					}
					else {
						System.out.println("Invalid account name!");
					}
					break;
					// both admin and employee can allow custormer accounts 
				case "allow":
					if(cmd.length!=2) {//deny account_name
						System.out.println("Invalid command! Please enter command 'help'!");
						break;
					}
					if(bank.getAuthority()==0 || bank.getAuthority()==1) {
						System.out.println("Invalid authority!");
						break;
					}
					if(bank.Allow(cmd[1])) {
						System.out.println(cmd[1]+" allowed!");
					}
					else {
						System.out.println("Invalid account name!");
					}
					break;
					// only admin can authorize cancellation of account 
				case "cancel":
					if(bank.getAuthority()!=4) {
						System.out.println("Invalid authority!");
						break;
					}
					if(cmd.length!=2) {
						System.out.println("Invalid command! Please enter command 'help'!");
						break;
					}
					if(!bank.Cancel(cmd[1])) {
						System.out.println("Invalid account name!");
					}
					break;
					// admin and employee accounts can only use this option to deposit customer accounts
				case "depositx":
					if(bank.getAuthority()!=4) {
						System.out.println("Invalid authority!");
						break;
					}
					if(cmd.length!=3) {//depositx account qty
						System.out.println("Invalid command! Please enter command 'help'!");
						break;
					}
					if(!bank.Exists(cmd[1])) {
						System.out.println(cmd[1]+" account not exists!");
						break;
					}
					Account account4=bank.GetAccount(cmd[1]);
					if(account4.getAuthority()!=1) {
						System.out.println("Invalid account!");
						break;
					}
					Double qty4=Double.parseDouble(cmd[2]);
					Double new_qty4=bank.Deposit(cmd[1], qty4);
					System.out.println(cmd[1]+" account "+qty4.toString()+" deposited. Current balance is "+new_qty4.toString());
					break;
					// admin and employee accounts can only use this option to withdraw from customer accounts
				case "withdrawx":
					if(bank.getAuthority()!=4) {
						System.out.println("Invalid authority!");
						break;
					}
					if(cmd.length!=3) {//withdrawx account qty
						System.out.println("Invalid command! Please enter command 'help'!");
						break;
					}
					if(!bank.Exists(cmd[1])) {
						System.out.println(cmd[1]+" account not exists!");
						break;
					}
					Double qty5=Double.parseDouble(cmd[2]);
					Account account5=bank.GetAccount(cmd[1]);
					if(qty5>account5.getBalance()) {
						System.out.println("Balance "+account5.getBalance().toString()+ ", can't withdraw "+qty5.toString());
						break;
					}
					Double new_qty5=bank.Withdraw(cmd[1], qty5);
					System.out.println(cmd[1]+" account "+qty5.toString()+" withdrawed. Current balance is "+new_qty5.toString());
					break;
					//writes through the file
				case "write":
					if(cmd.length!=1) {//write in the file
						System.out.println("Invalid command! Please enter command 'help'!");
						break;
					}
					if(bank.getAuthority()!=0) {
						System.out.println("Invalid authority!");
						break;
					}
					bank.writeAccounts("store1.txt");
					System.out.println("Successfully saved!");
					break;
					//read through the file
				case "read": 
					if(cmd.length!=1) {
						System.out.println("Invalid command! Please enter command 'help'!");
						break;
					}
					if(bank.getAuthority()!=0) {
						System.out.println("Invalid authority!");
						break;
					}
					bank.readAccounts("store1.txt");
					break;
					// terminates the program
				case "exit":
					in.close();
					System.out.println("Bye, bye! Bank man!");
					System.exit(0);
					break;
					// display the general command menu
				case "help":
					System.out.println("Commands of Bank Simulation:");
					System.out.println("Super admin name:'super' password:'super'");
					System.out.println("help");
					System.out.println("exit");
					System.out.println("register authority(customer|joiner|employee|admin) name password");
					System.out.println("open name password");
					System.out.println("deposit qty");
					System.out.println("withdraw qty");
					System.out.println("transfer qty target_account_name");
					System.out.println("view");
					System.out.println("view_all : View all accounts info.");
					System.out.println("deny account_name");
					System.out.println("allow account_name");
					System.out.println("cancel account_name");
					System.out.println("depositx account_name qty");
					System.out.println("withdrawx account_name qty");
					System.out.println("write");
					System.out.println("read");
					System.out.println("join join_name :");
					System.out.println("close");
					break;
				default:
					System.out.println("Invalid command! Please enter command 'help'!");
			}
		}
	}
}

