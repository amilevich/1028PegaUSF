package revarure.proj.assignment;

import java.util.*;
import java.io.*;

class Bank implements java.io.Serializable

{

   /**
	 * 
	 */
	private static final long serialVersionUID = 4837276997127280766L;
Map<String,Customer> customerMap;

   Bank()
   
   {
   
      customerMap = new HashMap <String,Customer>();
   
   }

   public static void main(String []args)
   
   {
   
      Scanner sc = new Scanner(System.in);
   
      Customer customer;
   
      String username,password;double amount;
   
    
   
      Bank bank = new Bank();
   
      int choice;
   
      outer:  while(true)
   
      {
    	  System.out.println("     W  E  L  C  O   M   E         ");
          
          //System.out.println("--------------------------------\n");
          
         System.out.println("\n----------------------------------");
      
         System.out.println("    B A N K  O F  A T L A N T A        ");
      
         System.out.println("--------------------------------------\n");
      
         System.out.println("1.Open Account C H E C K I N G || S A V I N G :");
      
         System.out.println("2.Login :");
      
         System.out.println("3.Set Account Number :");
      
         System.out.println("4.Employee Login : ");
         System.out.println("5.Admin Login : ");
      
         System.out.println("6. Exit :");
      
         System.out.print("\nEnter your Choice : ");
      
         choice = sc.nextInt();
      
         sc.nextLine();
      
         switch(choice)
         
         {
         
            case 1:
            	
               System.out.print (" Enter the Account type you want to open it ? ");
                 
               String accType = sc.nextLine();

               System.out.print("Enter name : ");
            
               String name = sc.nextLine();
            
               System.out.print("Enter address : ");
            
               String address = sc.nextLine();
            
               System.out.print("Enter contact number : ");
            
               String phone = sc.nextLine();
               System.out.println(" Set Account Number ");
           	     int accNum =sc.nextInt();	   
           		   
            
               System.out.println("Set username : ");
            
               username = sc.next();
              
            		   
            		   bank.customerMap.containsKey(username);
               
               {
               
                  System.out.println("Username already exists. Set again : ");
               
                  username = sc.next();
               
               }
            
               System.out.println("Set a password (minimum 4 chars; minimum 1 digit, 1 lowercase, 1 uppercase, 1 special character[!@#$%^&*_]) :");
            
               password = sc.next();
            
               sc.nextLine();
            
               while(!password.matches((("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_]).{4,}"))))
               
               {
               
                  System.out.println("Invalid password condition. Set again :");
               
                  password=sc.next();
               
               }
            
               System.out.print("Enter initial deposit : ");
            
            
            
               amount=sc.nextDouble();
            
            
            
               customer = new Customer( accType,username,password,name,address,phone,accNum,amount,new Date());

               bank.customerMap.put(username,customer);
            
               break;
         
            case 2:
            
               System.out.println("Enter username : ");
            
               username = sc.next();
            
               sc.nextLine();
            
               System.out.println("Enter password : ");
            
               password = sc.next();
            
               sc.nextLine();
            
               if(bank.customerMap.containsKey(username))
               
               {
               
                  customer = bank.customerMap.get(username);
               
                  if(customer.password.equals(password))
                  
                  {
                  
                     while(true)
                     
                     {
                     
                        System.out.println("\n-------------------");
                     
                        System.out.println(    "   U S E  R   "    );
                     
                        System.out.println("------------------------\n");
                     
                        System.out.println("1. Deposit.");
                     
                        System.out.println("2. Transfer.");
                     
                        System.out.println("3. Last 5 transactions.");
                     
                        System.out.println("4. User information.");
                       
                     
                        System.out.println("5. Log out.");
                     
                        System.out.print("\nEnter your choice : ");
                     
                        choice = sc.nextInt();
                     
                        sc.nextLine();
                     
                        switch(choice)
                        
                        {
                        
                           case 1:
                           
                              System.out.print("Enter amount : ");
                           
                              while(!sc.hasNextDouble())
                              
                              {
                              
                                 System.out.println("Invalid amount. Enter again :");
                              
                                 sc.nextLine();
                              
                              }
                           
                              amount = sc.nextDouble();
                           
                              sc.nextLine();
                           
                              customer.deposit(amount,new Date());
                           
                              break;
                        
                           case 2:
                           
                              System.out.print("Enter payee username : ");
                           
                              username = sc.next();
                           
                              sc.nextLine();
                           
                              System.out.println("Enter amount : ");
                           
                              while(!sc.hasNextDouble())
                              
                              {
                              
                                 System.out.println("Invalid amount. Enter again :");
                              
                                 sc.nextLine();
                              
                              }
                           
                              amount = sc.nextDouble();
                           
                              sc.nextLine();
                           
                              if(amount > 300000)
                              
                              {
                              
                                 System.out.println("Transfer limit exceeded. Contact bank manager.");
                              
                                 break;
                              
                              }
                           
                              if(bank.customerMap.containsKey(username))
                              
                              {
                              
                                 Customer payee = bank.customerMap.get(username);
                              
                                 payee.deposit(amount,new Date());
                              
                                 customer.withdraw(amount,new Date());
                              
                              }
                              
                              else
                              
                              {
                              
                                 System.out.println("Username doesn't exist.");
                              
                              }
                           
                              break;
                        
                           case 3:
                           
                              for(String transactions : customer.transactions)
                              
                              {
                              
                                 System.out.println(transactions);
                              
                              }
                           
                              break;
                        
                           case 4:
                              System.out.println("Account Type  :  " + customer.accType);
                              System.out.println("Accountholder name : "+ customer.name);
                           
                              System.out.println("Accountholder address : "+ customer.address);
                           
                              System.out.println("Accountholder contact : "+ customer.phone);
                              
                              System.out.println("Account Number : " + customer.accNum);
                           
                              break;
                        
                           case 5:
                           
                              continue outer;
                        
                           default:
                           
                              System.out.println("Wrong choice !");
                        
                        }
                     
                     }
                  
                  }
                  
                  else
                  
                  {
                  
                     System.out.println("Wrong username/password.");
                  
                  }
               
               }
               
               else
               
               {
               
                  System.out.println("Wrong username/password.");
               
               }
            
               break;
         
         
         
            case 4 ://Employee Account
            
               System.out.println("Enter username : ");
            
               username = sc.next();
            
               sc.nextLine();
            
               System.out.println("Enter password : ");
            
               password = sc.next();
            
               sc.nextLine();
            
               if(username.equals("Emp") && password.equals("1234")) // sample Employee Login
               
               {
               
                  while(true)
                  
                  {
                  
                     System.out.println("\n----------------------");
                  
                     System.out.println("    E M P L O Y E E    ");
                  
                     System.out.println("--------------------------\n");
                  
                     System.out.println("1. see account information of all the customers.");
                  
                     System.out.println("2. Log out.");
                  
                     System.out.print("\nEnter your choice : ");
                  
                     choice = sc.nextInt();
                  
                     sc.nextLine();
                  
                     switch(choice)
                     
                     {
                     
                        case 1:
                        
                           System.out.println("Customers information");
                        
                           System.out.println(" AccType Username  Name  Address  Phone  AccountNumber  Balance");
                        
                        
                        
                           for (Customer v : bank.customerMap.values()) {
                           
                              System.out.println(v.username + " " + v.name + " " + v.address + " "+ v.phone + " " + v.accNum + " " + v.balance);
                           
                           
                           
                           }
                        
                           break;
                      
                        case 2: 
                           continue outer;
                     
                     }
                  
                  }
               
               }
            
               break;
         
         
            case 5 :  //Administrator Account 
               System.out.println("Enter username : ");
            
               username = sc.next();
            
               sc.nextLine();
            
               System.out.println("Enter password : ");
            
               password = sc.next();
            
               sc.nextLine();
            
               if(username.equals("Admin") && password.equals("5678"))  // Administrator Login
               
               {
               
                  while(true)
                  
                  {
                  
                     System.out.println("\n--------------------------- ");
                  
                     System.out.println("   A D M I N I S T R A T O R    ");
                  
                     System.out.println("-------------------------------\n");
                     System.out.println ("1.view Account Information ");
                        
                     System.out.println("2. Deny Account .");
                        
                     System.out.println("3. Approve Account .");
                        
                     System.out.println("4. Log out.");
                  
                     System.out.print("\nEnter your choice : ");
                  
                     choice = sc.nextInt();
                  
                     sc.nextLine();
                  
                     switch(choice)
                     
                     {
                     
                        case 1:
                        	
                        	System.out.println("Customers information");
                            
                            System.out.println("AccountType Username  Name  Address  Phone  AccountNumber  Balance");
                          
                            System.out.println ("Transaction  ");
           
                        
                           for (Customer v : bank.customerMap.values()) {
                           
                              System.out.println(v.accType + ""+ v.transactions +" "+ v.username + " " + v.name + " " + v.address + " "+ v.phone + " " + v.accNum  + " " + v.balance);
                           
                           
                           
                           }
                        
                           break;
                      
                        case 2: 
                           continue outer;
                     
                     }
                  
                  }
               
               }
            
               break;
          
            
            
            
            
         
         
            case 6:// Serialization of all the Bank details.        
            
               String filename = "information.txt";
            
       
            
               try
               
               {
               
               //Saving of object in a file
               
                  FileOutputStream file = new FileOutputStream(filename);
               
                  ObjectOutputStream out = new ObjectOutputStream(file);
               
                  out.writeObject(bank);
               
                  out.close();
               
                  file.close();
               
                  System.out.println("Object has been serialized");
               
               }
               
               catch (IOException ex) {
               
               }
            
               System.out.println("\nThank you for choosing Bank Of A T L A N T A.");
            
               System.exit(1);
            
               break;
         
            default:
            
               System.out.println("Wrong choice !");
         
         }
      
      }
   
   }

}