package com.project;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project0.Account;
import com.project0.Customer;


public class AccounDaoImpl implements AccountDao {
	
		
	
	private static String 
	URL = "jdbc:oracle:thin:@dbleroy.cybartdmnjjf.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "thor";
	private static String password = "Thor";
	@Override
	public int insertAccount(Account u)  {
		try 
		(Connection con = DriverManager.getConnection(URL, username, password)){
				
			PreparedStatement ps = con.prepareStatement("INSERT INTO bankAccount VALUES (?,?,?)");
		
			ps.setInt(1, u.getAcctId());
			
			ps.setDouble(2, u.getBalance());
			
			ps.setString(3, u.getStatus());
			
			ps.executeUpdate();
				
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	
		return 0;
	
}
	
	@Override
	public Account getAccount(int acctId){
		
			Account p=null;
//			Customer u=new Customer();
			
		
			 
			try (Connection con = DriverManager.getConnection(URL, username, password)){
			

			PreparedStatement ps = con.prepareStatement("SELECT * FROM bankAccount WHERE userName=?");

			ps.setInt(1, acctId);

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				 p= new Account(rs.getInt("acctId"), rs.getDouble("balance"), rs.getString("status"));
						
			}
			
			System.out.println();
			
		//return p;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return p;
		}
		
	public List<Account> getAllAccounts()  {
		List<Account>accounts=new ArrayList<Account> ();
		Connection con;
		try {
			con = DriverManager.getConnection(URL, username, password);
			PreparedStatement ps = con.prepareStatement("SELECT * FROM bankAccount");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				accounts.add(new Account(rs.getInt(1), rs.getDouble(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
					
		
		return accounts;
		
		
	}
	
	@Override
	public int deleteAccount(Account u)  {
		try 
		(Connection con = DriverManager.getConnection(URL, username, password)){
		PreparedStatement ps = con.prepareStatement("DELETE FROM Account WHERE acctId=?");
		
		ps.setInt(1, u.getAcctId());
		
		ps.executeUpdate();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return 0;
}

	public int updateAccount(Account u)  {
		try (Connection con = DriverManager.getConnection(URL, username, password)){
			PreparedStatement ps = con.prepareStatement("Update bankAccount Set acctId=? WHERE acctId=?");
			ps.setInt(1, u.getAcctId());
			ps.setDouble(2, u.getBalance());
			ps.setString(3, u.getStatus());
			ps.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				
			
				return 0;
		}

	@Override
	public int insertAccount(Customer u) {
		// TODO Auto-generated method stub
		return 0;
	}	
		}
		
		
		
	

	