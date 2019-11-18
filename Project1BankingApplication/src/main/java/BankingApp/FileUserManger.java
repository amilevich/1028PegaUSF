package BankingApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.HashMap;

/*
 * I made this file to move all the date i orignally coded in the Users.java.
 * this made my code much simpler to use and call in the main
 */

public class FileUserManger implements UserManager {
	
	private PrintWriter userWriter;
	private BufferedReader userReader;
	

	public FileUserManger(PrintWriter userWriter, BufferedReader userReader) {

		this.userWriter = userWriter;
		this.userReader = userReader;
	}

	public boolean signUp(Users user) {

		String role = user.getRole();
		if (!role.equals("0") && !role.equals("1") && !role.equals("2")) {
			return false;
		}
		userWriter.println(user.getUsername() + "," + user.getPassword() + "," + role);
		userWriter.flush();
		
		return true;
	}
	
	public boolean login(String username, String password) {
		String line = "";
		String[] details;
		try {
			line = userReader.readLine();
			int count = 0;
			while (line != null) {
				if (count > 0) {
					details = line.trim().split(",");
					if (details[0].trim().equals(username)) {
						if (details[1].equals(password)) {
							return true;
						} else {
							break;
						}
					}
				}
				line = userReader.readLine();		
				count+=1;
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public boolean isValidateCredentials(String username, String password) {
		
		return !username.trim().contentEquals("") && !password.trim().contentEquals("");
	}
	
	public void cleanup() throws IOException {
		userReader.close();
		userWriter.close();
	}

}
