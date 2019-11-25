package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.classes.Account;


public class AccountDaoImpl implements Dao<Account>{

	private String url;
	private String user;
	private String pass;	
	
	public AccountDaoImpl(String url, String user, String pass) {
		super();
		this.url = url;
		this.user = user;
		this.pass = pass;
	}	
	
	@Override
	public boolean exist(String id) {
		
		boolean exist = false;
		
		try(Connection conn = DriverManager.getConnection(url, user, pass)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ACCOUNTBANK WHERE accountid=?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			
			exist = rs.next();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return exist;		
	}

	@Override
	public boolean insert(Account a) {
		try (Connection conn = DriverManager.getConnection(url, user, pass)){
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO ACCOUNTBANK VALUES(?,?,?,?)");
			ps.setString(1, a.getAccountNum());
			ps.setDouble(2, a.getBalance());
			ps.setInt(3, a.isJoint()?1:0);
			ps.setInt(4, a.isPending()?1:0);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean delete(Account a) {
		
		try(Connection conn = DriverManager.getConnection(url, user, pass)){
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM ACCOUNTBANK WHERE accountid=?");
			ps.setString(1, a.getAccountNum());
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean update(Account a) {
		try(Connection conn = DriverManager.getConnection(url, user, pass)){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE ACCOUNTBANK SET balance=?, joint=?, pending=?  WHERE accountid=?");
			ps.setDouble(1, a.getBalance());
			ps.setInt(2, a.isJoint()?1:0);
			ps.setInt(3, a.isPending()?1:0);
			ps.setString(4, a.getAccountNum());
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return true;
		
	}

	@Override
	public ArrayList<Account> findAll() {
		
		ArrayList<Account> accounts = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(url, user, pass)){
			
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM ACCOUNTBANK WHERE pending=?");
		ps.setInt(1, 0);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			accounts.add(new Account(rs.getString(1), rs.getDouble(2), (rs.getInt(3)== 0)?false:true, (rs.getInt(4)== 0)?false:true));
		}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return accounts;		
	}

	public ArrayList<Account> findAllPending() {
		
		ArrayList<Account> accounts = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(url, user, pass)){
			
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM ACCOUNTBANK WHERE pending=?");
		ps.setInt(1, 1);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			accounts.add(new Account(rs.getString(1), rs.getDouble(2), (rs.getInt(3)== 0)?false:true, (rs.getInt(4)== 0)?false:true));
		}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return accounts;		
	}	
	
	public boolean insertUserAccount(String username, String account) {
		try (Connection conn = DriverManager.getConnection(url, user, pass)){
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO USERACCOUNT VALUES(?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, username);
			ps.setString(3, account);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}	

	public ArrayList<String> deleteUserAccount(String account) {
		
		ArrayList<String> users = new ArrayList<>(); 
		
		try(Connection conn = DriverManager.getConnection(url, user, pass)){
			
			PreparedStatement ps = conn.prepareStatement("SELECT username FROM USERACCOUNT WHERE accountid=?");
			ps.setString(1, account);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				users.add(rs.getString(1));
			}			
			
			ps = conn.prepareStatement("DELETE FROM USERACCOUNT WHERE  accountid=?");
			ps.setString(1, account);
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public Account find(String id) {
		Account account = null;
		
		try(Connection conn = DriverManager.getConnection(url, user, pass)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ACCOUNTBANK WHERE accountid=?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				account = new Account(rs.getString(1), rs.getDouble(2), (rs.getInt(3)== 0)?false:true, (rs.getInt(4)== 0)?false:true );
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return account;	
	}	
	
}
