package bankapp;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.apache.log4j.Logger;

public class MainDriver {//Opening of the main driver class
	final static Logger loggy = Logger.getLogger(MainDriver.class);
	public static Scanner in = new Scanner(System.in); //initializing the scanner variable to listen for and store user input
	private static Object userLogs;
	/*Serializing some of the account information into an object*/
	public static void deserialize() {
     
		
		 try // serialization code for entering into the accounts of the customer
	      {
	         FileInputStream serializeObject = new FileInputStream("hashmap.ser");
	         ObjectInputStream deserializeObject = new ObjectInputStream(serializeObject);
	         AccountManagement.storageAccount = (Map) deserializeObject.readObject();
	         deserializeObject.close();
	         serializeObject.close();
	      }catch(IOException exception1)
	      {
	         exception1.printStackTrace();
	         return;
	      }catch(ClassNotFoundException c)//looking for the exception
	      {
	         System.out.println("Sorry not found");
	         c.printStackTrace();
	         return;
	      }
	      System.out.println("Awsome your hashmap has been deserialized");
	      //content is displaying using an iterator method
	      Set set = AccountManagement.storageAccount.entrySet();
	      Iterator iterator = set.iterator();
	      while(iterator.hasNext()) {
	         Map.Entry entryToMap = (Map.Entry)iterator.next();
	         System.out.print("key: "+ entryToMap.getKey() + " & Value: ");
	         System.out.println(entryToMap.getValue());
	      }

		
	}
	
	public static void serialiseSomeStuff() {
		try
		{
			FileOutputStream serializeObject =
					new FileOutputStream("hashmap.ser");
			ObjectOutputStream objectStream = new ObjectOutputStream(serializeObject);
			objectStream.writeObject(AccountManagement.storageAccount);
			objectStream.close();
			serializeObject.close();
			System.out.println("The hashmap will be saved under the filename hashmap.ser");
		}catch(IOException exception1)
		{
			exception1.printStackTrace();
		}
	}
	public static void main(String[] args) { // the top of the main class in the mainDrive

		boolean activeUser = true; // while the activeUser is set to true within the menu scope the while loop will continue function
		while(activeUser) {//Overall arching while loop containing most of the app within its block statement
			//style variables
			boolean mainMenu = true;//variable allows for the user to maintain their position in the navigation structure of the app
			/* Styling strings for user interface*/
			final String BWHITE = "\033[1;34m";
			final String whitebg = "\u001B[47m";
			final String purp = "\u001B[106m";//actually blue cyan background
			final String green  = "\u001B[94m";//actually blue 
			final String white  = "\u001B[97m";
			final String black  = "\u001B[100m";//gray text background
			final String lightgreen  = "\u001B[92m";//brightgreen color text \u001B[104m
			final String cyan1 = "\u001B[96m";// cyan color text
			final String bgb = "\u001B[104m";// background blue
			final String yellow = "\u001B[93m";// yellow text
			final String bgw = "\u001B[47m"; //text-background white
			
			/*Prints out the main menu*/
			System.out.print(black+yellow+ "\t💰💰💰 W E L C O M E\tT O\tT H E 💰💰💰                       " + BWHITE + ""+yellow+"\n\t\t🤑 🤑 🤑 B  A  N  K 🤑 🤑 🤑  \t\t\t\t  ");
			System.out.print(white+" \n");
			System.out.print(white+"Username is probably username and Password is probably password \n");
			System.out.print(black+"\tPRESS ["+cyan1+"1"+white+"] ➕ ["+cyan1+"ENTER"+white+"] ➡️ IF YOU ARE A "+cyan1+"CUSTOMER\t\t           "+white+"\n");
			System.out.print("\t"+white+"PRESS "+white+"["+cyan1+"2"+white+"] ➕ ["+cyan1+"ENTER"+white+"] ➡️ IF YOU ARE A "+cyan1+"EMPLOYEE\t\t"+white+"           \n");
			System.out.print("\tPRESS ["+cyan1+"3"+white+"] ➕ ["+cyan1+"ENTER"+white+"] ➡️ IF YOU ARE A "+cyan1+"BANK ADMIN  \t\t   \n"+green+bgw+"");
			int navSelection = in.nextInt();//Saves the users input to navSelection variable
			in.nextLine();
			switch(navSelection){ 
			case 1: //if 1 is selected continues to Customer portal
				while(mainMenu) {
				Customer.access(in);
				System.out.print("Continue as an employee anyway? "+black+"\n1 "+green+" for yes "+black+"\n2 "+green+"for no");
				mainMenu = in.nextBoolean();
				}
				System.out.println("Customer interaction complete.");
				break;
			    case 2: //if 2 is selected continues to Employee portal
				while(mainMenu) {
				Employee.logInAsAnEmployee(in);
				System.out.print("Would you like to continue as a guest? "+cyan1+" TRUE"+green+" or"+cyan1+" FALSE"+green);
				mainMenu = in.nextBoolean();
				}
				System.out.println("Employee interaction complete");
				break;
			case 3: //if 3 is selected continues to Bank Admin portal
				while(mainMenu) {
				BankAdmin.loginAsAnEmployee(in);
				System.out.println("Continue as an employee?");
				mainMenu = in.nextBoolean();
				}
				System.out.println("Thanks again and have a lovely day");
				break;
				//checks to see if navSelection is filled (TRUE) then proceeds to cases
			}
			loggy.info("The user has started working on the menu");
		}//bottom of the while loop
		
	}}
	
