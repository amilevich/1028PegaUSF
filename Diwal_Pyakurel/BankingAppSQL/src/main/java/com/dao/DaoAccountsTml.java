package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.accounts.Accounts;
import com.profiles.Profiles;

public class DaoAccountsTml implements DaoAccountsInterface {
	
	private static String url = "jdbc:oracle:thin:@db1028.cnv5m4h5vxru.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String userName = "BankDB";
	private static String password = "password123";
	@Override
	public void insertAccounts(Accounts account) {
		
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);

			PreparedStatement ps = conn.prepareStatement("INSERT INTO accounts VALUES(?,?,?,?)");
			ps.setInt(1, 0);
			ps.setInt(2, account.getAccounNo());
			ps.setFloat(3, account.getBalance());
			ps.setInt(4, account.getSocial());
			ps.executeUpdate();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		
	}

}
	@Override
	public ArrayList<Accounts> getAllAccounts() {
		ArrayList<Accounts> allAccounts = new ArrayList<Accounts>();

		try {
			Connection conn = DriverManager.getConnection(url, userName, password);

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM accounts");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				allAccounts.add(new Accounts(rs.getInt(2), rs.getFloat(3), null, rs.getInt(4)));

			}
			
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return allAccounts;
	}
	
	@Override
	public void addDeposit(int accountNo, float x) {
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);

			PreparedStatement ps = conn.prepareStatement("UPDATE accounts SET balance=balance+? where account_number = ?");
			ps.setFloat(1, x);
			ps.setInt(2, accountNo);
			ps.executeUpdate();
			conn.close();
			System.out.println("$"+x +" has been deposited on "+ accountNo);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			
		
		
	}
		
	}
	@Override
	public void withdraw(int accountNo, float x) {
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);

			PreparedStatement ps = conn.prepareStatement("UPDATE accounts SET balance=balance-? where account_number = ?");
			ps.setFloat(1, x);
			ps.setInt(2, accountNo);
			ps.executeUpdate();
			conn.close();
			System.out.println("$"+x +" has been withdrawn from "+ accountNo);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("The Withdraw was not processed");
		
		
	}
		
	}
	@Override
	public void transfer(int firstAccount, int secondAccount, float x) {
		// TODO Auto-generated method stub
		withdraw(firstAccount, x);
		addDeposit(secondAccount, x);
		
	}
	@Override
	public void view(int accountNo, int social) {
		
		

		try {
			Connection conn = DriverManager.getConnection(url, userName, password);

			PreparedStatement ps = conn.prepareStatement("SELECT account_number, balance, social , users.user_name from accounts LEFT JOIN users on accounts.social=users.user_social where account_number = ? and social =?");
			ps.setInt(1, accountNo);
			ps.setInt(2, social);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("========================================================");
				System.out.println("Account Number " + rs.getInt(1));
				System.out.println("Balance " + rs.getFloat(2));
				System.out.println("User Social " + rs.getInt(3));
				System.out.println("User Id " + rs.getString(4));
				System.out.println("========================================================");
			}
			
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		
		
		
	}
	@Override
	public void viewAll() {
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);

			PreparedStatement ps = conn.prepareStatement("SELECT account_number, balance, social , users.user_name from accounts LEFT JOIN users on accounts.social=users.user_social");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("========================================================");
				System.out.println("Account Number " + rs.getInt(1));
				System.out.println("Balance " + rs.getFloat(2));
				System.out.println("User Social " + rs.getInt(3));
				System.out.println("User Id " + rs.getString(4));
				System.out.println("========================================================");
			}
			
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	//@Override
	public void deleteAccount(int accountNo) {
		// TODO Auto-generated method stub
		
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);

			PreparedStatement ps = conn.prepareStatement("DELETE FROM accounts where account_number=?");
			ps.setInt(1, accountNo);
			
			ps.executeUpdate();
			System.out.println("Account has been deleted");
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		
	}
		
	}
	@Override
	public void deleteUnrequired() {
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);

			PreparedStatement ps = conn.prepareStatement("DELETE FROM accounts where social=?");
			ps.setInt(1, 0);
			
			ps.executeUpdate();
			System.out.println("Account has been deleted");
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		
	}
		
	}
	
	
	
}