package com.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.model.Account;

public class AccountDaoImp implements AccountDao {
	
	private static String url
	= "jdbc:oracle:thin:@db1028.crsokuwxumhe.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "BankApplication";
	private static String password = "p4ssw0rd";
	
	
	@Override
	public int insertAccount(Account a) {
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("INSERT INTO BankApplication VALUES(?,?,?,?,?,?,?)");
			ps.setString(1, a.getAccountNumber());
			ps.setDouble(2, a.getAccountBalance());
			ps.setString(3, a.getFirstName());
			ps.setString(4, a.getLastName());
			ps.setString(5, a.getAddress());
			ps.setString(6, a.getUsername());
			ps.setString(7, a.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Account selectAccountByName(String name) {
		Account account = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Pets WHERE name=?");
			//putting in a native SQL query utilizing a prepared statement
			ps.setString(1, name);
			//we are setting the question mark to be the name that is passed as 
			//a parameter to this method
			//number 1 corresponds to the first question mark in the query
			ResultSet rs = ps.executeQuery();
			//we are executing the query and storing the result set in 
			//a ResultSet type (object)
			while(rs.next()) {
				account = new Account(rs.getString("name"), rs.getString("type"), name, name, name, name, name, name, name, name, name);
			}
			//we are iterating through our result set and populating
			//our pet object with the values that are coming from the
			//table's columns
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public List<Account> selectAllAccounts() {
		List<Account> pets = new ArrayList<Account>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM Pets");
		//SQL query goes into our prepared statement
		//we have no question marks, so no setting the values
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			pets.add(new Account(rs.getString(1), rs.getString(2), null, null, null, null, null, null, null, null, null));
		}
		//iterating through the result set, while we still have the next value
		//we populate the new Pet object and add it to the ArrayList
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return pets;
	}

	@Override
	public int updateAccount(Account a) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE BankAccount SET type=? WHERE name=?");
			ps.setString(1, a.getAccountNumber());
			ps.setDouble(2, a.getAccountBalance());
			ps.setString(3, a.getFirstName());
			ps.setString(4, a.getLastName());
			ps.setString(5, a.getAddress());
			ps.setString(6, a.getUsername());
			ps.setString(7, a.getPassword());
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteAccount(Account a) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM BankAccount WHERE name=?");
			ps.setString(1, a.getAccountNumber());
			ps.setDouble(2, a.getAccountBalance());
			ps.setString(3, a.getFirstName());
			ps.setString(4, a.getLastName());
			ps.setString(5, a.getAddress());
			ps.setString(6, a.getUsername());
			ps.setString(7, a.getPassword());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
