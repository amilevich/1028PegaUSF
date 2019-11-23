package Banking;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.TreeMap;

public class Bank {
	private TreeMap<Integer, Account> accounts;
	private TreeMap<String, User> users;
	private int nextID;
	String file;
	
	//old constructor for reading in user and account objects from a file
	public Bank(String inFileName) throws IOException, InstantiationException{
		accounts = new TreeMap<Integer, Account>(); accounts.clear();
		users = new TreeMap<String, User>(); users.clear();
		nextID = 0;
		file = inFileName;
		FileInputStream inFile = new FileInputStream(inFileName);
		ObjectInputStream inObjects = new ObjectInputStream(inFile);
		Account a;
		User u;

		while (inFile.available() > 1) {
			int i;
			try {
				i = inFile.read();
				
				//First byte before each object determines if object is user ('u') or account ('a').
				if (i == (int)'u') {
					u = (User)inObjects.readObject();
					users.put(u.getUsername(), u);
					
					//u.print();
				} else if (i == (int)'a') {
					a = (Account)inObjects.readObject();
					accounts.put(a.getID(), a);
					if(a.getID() >= nextID) nextID = a.getID() + 1;
					
					//a.print();
				} else System.out.printf("Unexpected byte in file.\n");
			}
			catch(ClassNotFoundException e) {
				System.out.printf("Object read error.\n");
				e.printStackTrace();
			}
		}
		
		//Check that all accounts' and user's links to one another match. Remove non-matching links.
		try {
			for (String us = users.firstKey(); us != null; us = users.higherKey(us)) {
				u = users.get(us);
				Integer[] aa = (Integer[]) u.getAccounts().toArray(new Integer[0]);

				
				for (int i = 0; i < aa.length; i++) {
					a = accounts.get(aa[i]);
					if (a == null || !a.getUsers().contains(us)) {
						u.removeAccount(aa[i]);
						System.out.printf("Found and removed improper link from User %s to account %d.\n", us, aa[i]);
					}
				}
			}
			
			for (Integer ai = accounts.firstKey(); ai != null; ai = accounts.higherKey(ai)) {
				a = accounts.get(ai);
				String[] ua = (String[]) a.getUsers().toArray(new String[0]);

				for (int i = 0; i < ua.length; i++) {
					u = users.get(ua[i]);
					
					if (u == null || !u.getAccounts().contains(ai)) {
						a.removeUser(ua[i]);
						System.out.printf("Found and removed improper link from Account %d to User %s.\n", ai, ua[i]);
					}
				}
			}
		} catch (NoSuchElementException e) {
			System.out.printf("Accounts or Users is empty.\n");
		}

		inFile.close();
	}
	
	//constructor for loading from database
	public Bank() {
		accounts = new TreeMap<Integer, Account>();
		users = new TreeMap<String, User>();
		file = "";
		
		try { nextID = DBAO.get(accounts, users); }
		catch (InstantiationException e) {
			System.out.printf("Database retrieval failure.\n");
			e.printStackTrace();
			System.exit(1);
		}
		
		if(nextID == -1 || accounts.isEmpty() || users.isEmpty()) {
			System.out.printf("Database retrieval falure.\n");
			System.exit(1);
		}
		
	}

	public boolean addAccount(Account a) {
		if(accounts.get(a.getID()) == null) {
			accounts.put(a.getID(), a); 
			return true;
		}
	
		System.out.printf("Account with ID %d already exists.\n", a.getID());
		return false;
	}
	
	public Account getAccount(int id) { return accounts.get(id); }
	
	public boolean removeAccount(int id) {
		Account a;
		
		a = accounts.get(id);
		if(a == null) {
			System.out.printf("Account %d does not exist.\n", id);
			return false;
		}
		
		for(String u : a.getUsers()) users.get(u).removeAccount(a.getID());
		
		System.out.printf("Account %d has been deleted.\n", a.getID());
		return (accounts.remove(id) != null);
	}
	
	public boolean addUser(User u){
		if(users.containsKey(u.getUsername())) {
			System.out.printf("User with username \"%s\" already exists.\n", u.getUsername());
			return false;
		}
		
		users.put(u.getUsername(), u);
		return true;
	}
	
	public User getUser(String u) { return users.get(u); }
	
	public ArrayList<String> getUsers(){
		ArrayList<String> names = new ArrayList<String>(); names.clear();
		
		for(String u = users.firstKey(); u != null; u = users.higherKey(u)) names.add(u);
	
		return names;
	}
	
	public ArrayList<Integer> getAccounts(){
		ArrayList<Integer> ids = new ArrayList<Integer>(); ids.clear();
		
		for(Integer a = accounts.firstKey(); a != null; a = accounts.higherKey(a)) ids.add(a);
	
		return ids;
	}
	
	//Links a user and account to each other.
	public boolean link(User u, Account a) {
		if(a == null || u == null) return false;
		
		if(!u.addAccount(a.getID())) return false;
		if(!a.addUser(u.getUsername())) {
			u.removeAccount(a.getID());
			return false;
		}
		
		return true;
	}
	
	public int useNextID() { return nextID++; }
	
	//Save all bank info to database and exit process
	public void saveAndQuit() throws IOException , FileNotFoundException{
		
		//Old code for loading from file
		if (!file.equals("")) {
			FileOutputStream outFile = new FileOutputStream(file);
			ObjectOutputStream outS = new ObjectOutputStream(outFile);

			for (User u = users.isEmpty() ? null : users.get(users.firstKey()); u != null; u = (users.higherKey(u.getUsername()) != null ? users.get(users.higherKey(u.getUsername())) : null)) {
				outFile.write((int) 'u');
				outS.writeObject(u);
			}

			for (Account a = accounts.isEmpty() ? null : accounts.get(accounts.firstKey()); a != null; a = (accounts.higherKey(a.getID()) != null ? accounts.get(accounts.higherKey(a.getID())) : null)) {
				outFile.write((int) 'a');
				outS.writeObject(a);
			}

			outFile.close();
		}
		
		//save to database
		if(!DBAO.save(users, accounts)) System.out.printf("Save Failure\n");
		
		System.exit(0);
	}
}
