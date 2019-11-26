package com.examples.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.examples.accounts.AccountMenu;
import com.examples.accounts.Accounts;

public class EmployeeDaoImpl implements AccountsDao{
	private static String url= "jdbc:oracle:thin:@db1028.c6ogbmwpzun0.us-east-1.rds.amazonaws.com:1521:orcl";
	private static String username = "Felixsoto1";
	private static String password = "p4ssw0rd";
	
	
	@Override
	public int insertAccounts(Accounts a) {
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("INSERT INTO ACCOUNTTABLE VALUES(?,?,?,?,?,?,?)");
			ps.setInt(1, a.getAccID());
			ps.setInt(2, a.getIsJoint());
			ps.setString(3, a.getStatus());
			ps.setDouble(4, a.getBalance());
			ps.setString(5, a.getAccCustFname());
			ps.setString(6, a.getAccCustLname());
			System.out.println(a.getCustID());
			ps.setInt(7, a.getCustID());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}
	
	
	@Override
	public Accounts selectAccountsByAccountID(int accID) {
		
		Accounts acc = null;

		try(Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ACCOUNTTABLE WHERE accID=?");
			ps.setInt(1, accID);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				acc = new Accounts(rs.getInt("accID"), rs.getInt("isJoint"), rs.getString("status"), rs.getDouble("balance"), rs.getString("accCustFname"), rs.getString("accCustLname"), rs.getInt("CustID"));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} 
		return acc;
	}
	@Override
	public List<Accounts> selectAllAccounts() {
	List<Accounts> acc = new ArrayList<Accounts>();
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ACCOUNTTABLE");
		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				acc.add(new Accounts(rs.getInt(1), rs.getInt(2),rs.getNString(3),rs.getDouble(4),rs.getNString(5), rs.getNString(6), rs.getInt(7)));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return acc;
	}
	@Override
	public int updateAccounts(Accounts a) {
try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE ACCOUNTTABLE SET IsJoint=?,Status=?,Balance=?,AccCustFname=?,AccCustLname=?,PreviousTransaction=?,CustID=? WHERE accID=?");
			ps.setInt(1, a.getAccID());
			ps.setInt(2, a.getIsJoint());
			ps.setString(3, a.getStatus());
			ps.setDouble(4, a.getBalance());
			ps.setNString(5, a.getAccCustFname());
			ps.setNString(6, a.getAccCustLname());
			ps.setInt(7, a.getCustID());
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int deleteAccounts(Accounts a) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM ACCOUNTTABLE WHERE custID=?");
			ps.setInt(1, a.getCustID());
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	

	public static boolean emplExist(String emplUserName ) {
		boolean emplUsernameTaken = false;
		try(Connection conn = DriverManager.getConnection(url,username,password)){
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM Employee WHERE empUsername=?");
		ps.setString(1,emplUserName);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			if(rs.getString(3).equals(emplUserName)) {
				emplUsernameTaken = true;
				break;
			}
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return emplUsernameTaken;
	}

	public static boolean emplExist1(String passWord) {
		boolean emplUsernameTaken = false;
		try(Connection conn = DriverManager.getConnection(url,username,password)){
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customers WHERE password=?");
		ps.setString(1, passWord);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			if(rs.getString(4).equals(passWord)) {
				emplUsernameTaken = true;
				AccountMenu.bankingMenu();
				break;
			}
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return emplUsernameTaken;
	}// end cust1
	
	
	
	}// end class


