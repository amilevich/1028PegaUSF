package revarure.proj.assignment;

import java.util.*;

import java.text.*;

import java.io.*;

interface  BankOfAtlanta         //   SavingsAccount Checking Account

{

  

   void deposit(double n,Date d);

   void withdraw(double n,Date d);

}

class Customer implements  BankOfAtlanta         // SavingsAccount checking Account

{

   String accType,username,password,name,address,phone ;

   double balance ;
   int accNum;

   ArrayList<String> transactions;

   Customer(String accType,String username,String password,String name,String address,String phone, int accNum,double balance,Date date)
   
   {
      this .accType =accType;
      this.username = username;
   
      this.password = password;
   
      this.name = name;
   
      this.address = address;
   
      this.phone = phone;
      
      this.accNum =accNum;
   
      this.balance = balance;
   
      transactions = new ArrayList<String>(5);
   
      addTransaction(String.format("Initial deposit - " +NumberFormat.getCurrencyInstance().format(balance)+" as on " + "%1$tD"+" at "+"%1$tT.",date));
   
   }

  

   public String getAccType() {
	return accType;
}



public void setAccType(String accType) {
	this.accType = accType;
}



public String getUsername() {
	return username;
}



public void setUsername(String username) {
	this.username = username;
}



public String getPassword() {
	return password;
}



public void setPassword(String password) {
	this.password = password;
}



public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



public String getAddress() {
	return address;
}



public void setAddress(String address) {
	this.address = address;
}



public String getPhone() {
	return phone;
}



public void setPhone(String phone) {
	this.phone = phone;
}



public double getAccNum() {
	return accNum;
}



public void setAccNum(int accNum) {
	this.accNum = accNum;
}



public double getBalance() {
	return balance;
}



public void setBalance(double balance) {
	this.balance = balance;
}



public ArrayList<String> getTransactions() {
	return transactions;
}



public void setTransactions(ArrayList<String> transactions) {
	this.transactions = transactions;
}



@Override
public String toString() {
	return "Customer [accType = " +accType+ " username= "+ username + ", password=" + password + ", name=" + name + ", address=" + address
			+ ", phone=" + phone + " , accNum ="+ accNum +", balance=" + balance + ", transactions=" + transactions + "]";
}



@Override
   
   public void deposit(double amount,Date date)
   
   {
   
      balance += amount;
   
      addTransaction(String.format(NumberFormat.getCurrencyInstance().format(amount)+" credited to your account. Balance - " +NumberFormat.getCurrencyInstance().format(balance)+" as on " + "%1$tD"+" at "+"%1$tT.",date));
   
   }

   @Override
   
   public void withdraw(double amount,Date date)
   
   {
   
      if(amount>(balance-200))
      
      {
      
         System.out.println("Insufficient balance.");
      
         return;
      
      }
   
      balance -= amount;
   
      addTransaction(String.format(NumberFormat.getCurrencyInstance().format(amount)+" debited from your account. Balance - " +NumberFormat.getCurrencyInstance().format(balance)+" as on " + "%1$tD"+" at "+"%1$tT.",date));
   
   }

   private void addTransaction(String message)
   
   {
   
      transactions.add(0,message);
   
      if(transactions.size()>5)
      
      {
      
         transactions.remove(5);
      
         transactions.trimToSize();
      
      }
   
   }

}
