package com.projectzero.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project0PartOne.Account;

public class AccountDaoImpl implements AccountDao {
	
	private static String url = "";
	private static String username = "";
	private static String password = "";
	@Override
	public List<Account> getAllAccounts() {
		List<Account> accounts = new ArrayList<Account>();
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Accountt");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				accounts.add(new Account(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public Account getAccountById(int accountID) {
		Account account = null;
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Accountt WHERE accountID=?");
			ps.setInt(1, accountID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				 account = new Account(rs.getInt("accountID"),rs.getInt("balance"),rs.getString("accountType"),rs.getInt("isJoint"),rs.getInt("customerID"),rs.getString("status"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public int createAccount(Account account) {
		int createdAccounts = 0;
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Accountt(accountID, balance, accountType, isJoint, customerID, status) VALUES (?,?,?,?,?,?)");
			ps.setInt(1, account.getAccountID());
			ps.setDouble(2, account.getBalance());
			ps.setString(3, account.getType());
			ps.setInt(4, account.isJoint());
			ps.setInt(5, account.getCustomerID());
			ps.setString(6, account.getStatus());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return createdAccounts;
	}

	@Override
	public int updateAccount(Account account) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("UPDATE Accountt SET accountID=?, balance=?, accountType=?, isJoint=?, status=? WHERE customerID=?");
			ps.setInt(1, account.getAccountID());
			ps.setDouble(2, account.getBalance());
			ps.setString(3, account.getType());
			ps.setInt(4, account.isJoint());
			ps.setInt(6, account.getCustomerID());
			ps.setString(5, account.getStatus());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Account getAccountByCustomerId(int customerID) {
		Account account = new Account();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Accountt WHERE customerID=?");
			ps.setInt(1, customerID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				account = new Account(rs.getInt("accountID"),rs.getInt("balance"),rs.getString("accountType"),rs.getInt("isJoint"),rs.getInt("customerID"),rs.getString("status"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return account;
	}
	@Override
	public int insert(Account account) {
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Accountt VALUES(?,?,?,?,?,?)");
			ps.setInt(1, account.getAccountID());
			ps.setDouble(2, account.getBalance());
			ps.setString(3, account.getType());
			ps.setInt(4, account.isJoint());
			ps.setInt(5, account.getCustomerID());
			ps.setString(6, account.getStatus());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteAccount(Account account) {
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Accountt WHERE accountID=?");
			ps.setInt(1, account.getAccountID());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateAccount(Account account, String sql) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, account.getAccountID());
			ps.setDouble(2, account.getBalance());
			ps.setString(3, account.getType());
			ps.setInt(4, account.isJoint());
			ps.setInt(5, account.getCustomerID());
			ps.setString(6, account.getStatus());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Account getAccountID() {
		return null;
	}

	@Override
	public Account getAccountBalance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccountType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccountJoint() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getCustomerID() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Account getAccountByAccountById(int accountID) {
		Account account = new Account();
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Accountt WHERE customerID=?");
			ps.setInt(1, accountID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				account.setStatus(rs.getString("status"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public int updateAccountAcount(int accountID) {
		Account account = new Account();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("UPDATE Accountt SET accountID=?, balance=?, accountType=?, isJoint=?, status=? WHERE customerID=?");
			ps.setInt(1, account.getAccountID());
			ps.setDouble(2, account.getBalance());
			ps.setString(3, account.getType());
			ps.setInt(4, account.isJoint());
			ps.setInt(6, account.getCustomerID());
			ps.setString(5, account.getStatus());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
