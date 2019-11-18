package BankingApp;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class Account {
	public Account() {

	}
	//Creates the account info to be stored in the account.txt file so the app can pull it.
	public boolean create(String owner, String firstName, String lastName) {
		BufferedReader reader = null;
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileWriter("account.txt", true));
			reader = new BufferedReader(new FileReader("account.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		writer.println(owner + "," + firstName + "," + lastName + "," + "0" + "," + "0");
		writer.flush();
		
		return true;
	}
	
	public boolean isValidateCredentials(String firstName, String lastName) {
		if (firstName.trim().contentEquals("")) {
			return false;
		} else if (lastName.trim().contentEquals("")) {
			return false;
		} else {
			return true;
		}
		
	}
	
	//Where all the accounts are stored
	public ArrayList<HashMap<String, String>> getAllAccountDetails() {
		BufferedReader reader = null;
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileWriter("account.txt", true));
			reader = new BufferedReader(new FileReader("account.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ArrayList<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		String line = null;
		String[] details;
		
		try {
			line = reader.readLine();
			details = line.trim().split(",");
			int count = 0;
			while (line != null) {
				if (count > 0) {
					HashMap<String, String> dic = new HashMap<String, String>();
					details = line.trim().split(",");
					dic.put("owner", details[0]);
					dic.put("firstName", details[1]);
					dic.put("lastName", details[2]);
					dic.put("balance", details[3]);
					dic.put("status", details[4]);
					result.add(dic);
				}
				count+=1;
				line = reader.readLine();
			}
			
			return result;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	public HashMap<String, String> getAccountDetails(String owner) {
		BufferedReader reader = null;
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileWriter("account.txt", true));
			reader = new BufferedReader(new FileReader("account.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		HashMap<String, String> result = new HashMap<String, String>();
		String line = null;
		String[] details;
		try {
			line = reader.readLine();
			System.out.println(line);
			
			details = line.trim().split(",");
			while (line != null) {
				details = line.trim().split(",");
				if (details[0].equals(owner)) {
					result.put("owner", owner);
					result.put("firstName", details[1]);
					result.put("lastName", details[2]);
					result.put("balance", details[3]);
					result.put("status", details[4]);
					
				}
				line = reader.readLine();		
			}
			
			return result;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//When a user or admin updates the balance, this method is how it updates in the txt file.
	public void updateBalance(String owner, String balance) {
		BufferedReader reader = null;
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileWriter("account.txt", true));
			reader = new BufferedReader(new FileReader("account.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		StringBuffer inputBuffer = new StringBuffer();
        String line;
        String[] details;
        try {
			line = reader.readLine();
	        while (line != null) {
	        	details = line.trim().split(",");
				if (details[0].equals(owner)) {
					inputBuffer.append(details[0] + "," + details[1]+ "," + details[2] + "," + balance + "," + details[4]);
					
				} else {
					inputBuffer.append(line);
				}
	            inputBuffer.append('\n');
	            line = reader.readLine();
	        }
	        String inputStr = inputBuffer.toString();
	        
	        // write the new string with the replaced line OVER the same file
	        FileOutputStream fileOut = new FileOutputStream("account.txt");
	        fileOut.write(inputStr.getBytes());
	        fileOut.close();
	        
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void updateStatus(String owner, String status) {
		BufferedReader reader = null;
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileWriter("account.txt", true));
			reader = new BufferedReader(new FileReader("account.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		StringBuffer inputBuffer = new StringBuffer();
        String line;
        String[] details;
        try {
			line = reader.readLine();
			System.out.println(line);
	        while (line != null) {
	        	details = line.trim().split(",");
				if (details[0].equals(owner)) {
					inputBuffer.append(details[0] + "," + details[1]+ "," + details[2] + "," + details[3] + "," + status);
					
				} else {
					inputBuffer.append(line);
				}
	            inputBuffer.append('\n');
	            line = reader.readLine();
	        }
	        String inputStr = inputBuffer.toString();
	        
	        // write the new string with the replaced line OVER the same file
	        FileOutputStream fileOut = new FileOutputStream("account.txt");
	        fileOut.write(inputStr.getBytes());
	        fileOut.close();
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void edit(String owner, String firstName, String lastName) {
		BufferedReader reader = null;
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileWriter("account.txt", true));
			reader = new BufferedReader(new FileReader("account.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuffer inputBuffer = new StringBuffer();
        String line;
        String[] details;
        try {
			line = reader.readLine();
			System.out.println(line);
	        while (line != null) {
	        	details = line.trim().split(",");
				if (details[0].equals(owner)) {
					inputBuffer.append(details[0] + "," + firstName+ "," + lastName + "," + details[3] + "," + details[4]);
				} else {
					inputBuffer.append(line);
				}
	            inputBuffer.append('\n');
	            line = reader.readLine();
	        }
	        String inputStr = inputBuffer.toString();
	        
	        // write the new string with the replaced line OVER the same file
	        FileOutputStream fileOut = new FileOutputStream("account.txt");
	        fileOut.write(inputStr.getBytes());
	        fileOut.close();
	        
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void delete(String owner) {
		BufferedReader reader = null;
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileWriter("account.txt", true));
			reader = new BufferedReader(new FileReader("account.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuffer inputBuffer = new StringBuffer();
        String line;
        String[] details;
        try {
			line = reader.readLine();
			System.out.println(line);
	        while (line != null) {
	        	details = line.trim().split(",");
				if (!details[0].equals(owner)) {
					inputBuffer.append(line);
				}
	            inputBuffer.append('\n');
	            line = reader.readLine();
	        }
	        String inputStr = inputBuffer.toString();
	        
	        // write the new string with the replaced line OVER the same file
	        FileOutputStream fileOut = new FileOutputStream("account.txt");
	        fileOut.write(inputStr.getBytes());
	        fileOut.close();
	        
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
