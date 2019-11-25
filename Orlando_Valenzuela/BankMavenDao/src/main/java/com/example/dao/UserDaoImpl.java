package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.classes.Account;
import com.example.classes.Admin;
import com.example.classes.Customer;
import com.example.classes.Employee;
import com.example.classes.User;


public class UserDaoImpl implements Dao<User>{
	
	private String url;
	private String user;
	private String pass;	

	public UserDaoImpl(String url, String user, String pass) {
		super();
		this.url = url;
		this.user = user;
		this.pass = pass;
	}

	@Override
	public boolean exist(String id) {
		
		boolean exist = false;
		
		try(Connection conn = DriverManager.getConnection(url, user, pass)){
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM BANKUSER WHERE username=?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			
			exist = rs.next();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return exist;
	}

	@Override
	public boolean insert(User u) {
		
		try (Connection conn = DriverManager.getConnection(url, user, pass)){
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO BANKUSER VALUES(?,?,?)");
			ps.setString(1, u.getUserName());
			ps.setString(2, u.getPassword());
			ps.setInt(3, u.getTypeUser());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean delete(User u) {
		
		try(Connection conn = DriverManager.getConnection(url, user, pass)){
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM BANKUSER WHERE username=?");
			ps.setString(1, u.getUserName());
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean update(User u) {
		
		try(Connection conn = DriverManager.getConnection(url, user, pass)){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE BANKUSER SET usertype=?, userpass=?  WHERE username=?");
			ps.setInt(1, u.getTypeUser());
			ps.setString(2, u.getPassword());
			ps.setString(2, u.getUserName());
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	
	
	@Override
	public ArrayList<User> findAll() {

		Customer customer = null;
		Account account = null;
		ArrayList<User> users = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(url, user, pass)){
			
		PreparedStatement ps = conn.prepareStatement("SELECT B.username, B.userpass, B.usertype, A.accountid, A.balance, A.joint, A.pending " + 
				                                     " FROM BANKUSER B INNER JOIN USERACCOUNT U ON B.username = U.username " + 
			                                                          " INNER JOIN ACCOUNTBANK A ON U.accountid = A.accountid " + 
			                                        	" WHERE B.usertype =?");
		ps.setInt(1, 1);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			customer = new Customer(rs.getString(1), rs.getString(2), rs.getInt(3));
			account = new Account(rs.getString(4), rs.getDouble(5), (rs.getInt(6) == 0)?false:true, (rs.getInt(7) == 0)?false:true);
			customer.setAccount(account);
			users.add(customer);
		}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return users;
		
	}
	
	public User findUser(String username, String password) {
		
		User userfind = null;
		
		try(Connection conn = DriverManager.getConnection(url, user, pass)){
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM BANKUSER WHERE username=? and userpass=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				
				switch (rs.getInt(3)) {
				
				case 1:{
					
					Account account = null; 
					
					userfind = new Customer(rs.getString(1), rs.getString(2), rs.getInt(3));
					rs.close();
					
					ps = conn.prepareStatement("SELECT A.accountid, A.balance, A.joint, A.pending " + 
							                     " FROM USERACCOUNT U JOIN ACCOUNTBANK A ON U.accountid = A.accountid " + 
							                     " WHERE U.username=? ");
					ps.setString(1, userfind.getUserName());
					rs = ps.executeQuery();
					
					while(rs.next()) {
						account = new Account(rs.getString(1), rs.getDouble(2), (rs.getInt(3)== 0)?false:true, (rs.getInt(4)== 0)?false:true );
					}
					((Customer)userfind).setAccount(account);				
					
					break;
				}
				case 2:{
					userfind = new Employee(rs.getString(1), rs.getString(2), rs.getInt(3));
					break;
				}
				case 3:{
					userfind = new Admin(rs.getString(1), rs.getString(2), rs.getInt(3));
					break;
				}	
				}
				
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return userfind;
	}

	@Override
	public User find(String id) {
		Customer customer = null;
		
		try(Connection conn = DriverManager.getConnection(url, user, pass)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM BANKUSER WHERE username=?");
			ps.setString(1, id);                            
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				customer = new Customer(rs.getString(1), rs.getString(2), rs.getInt(3));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return customer;	
	}	

}
