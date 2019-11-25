package com.project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.project0.Account;
import com.project0.Customer;


public class CustomerDaoImp implements CustomerDao {
	public static void main(String[] args)  {
		
		Customer u=new Customer();
		Scanner scan = new Scanner(System.in);


//		System.out.println(gui.getCustomer(customerCC));
	}
	private static String 
	URL = "jdbc:oracle:thin:@dbleroy.cybartdmnjjf.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "username";
	private static String password = "password";
	
	@Override
	public int insertCustomer(Customer u)  {
		
		
		try 
			(Connection con = DriverManager.getConnection(URL, username, password)){
					
				PreparedStatement ps = con.prepareStatement("INSERT INTO bankCustomer VALUES (?,?,?,?,?,?,?,?)");
				
				System.out.println(u.getActtId());
				ps.setInt(1, u.getActtId());
				
				ps.setString(2, u.getUserName());
				System.out.println(u.getPassword());
				ps.setString(3, u.getPassword());
				System.out.println(u.getfName());
				ps.setString(4, u.getfName());
				System.out.println(u.getlName());
				ps.setString(5, u.getlName());
				System.out.println(u.getCusId());
				ps.setInt(6, u.getCusId());
				System.out.println(u.getStatus());
				ps.setString(7, u.getStatus());
				System.out.println(u.getBalance());
				ps.setDouble(8, u.getBalance());
				ps.executeUpdate();
					
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
		
			return 0;
		
	}
	public boolean customerExit(String userNameCust) {
		boolean customerUserTake=false;
		try (Connection con = DriverManager.getConnection(URL, username, password)){
			

			PreparedStatement ps = con.prepareStatement("SELECT * FROM bankCustomer WHERE userName=?");

			ps.setString(1, userNameCust);
			

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				if(rs.getString(2).equals(userNameCust)){
					Account news = new Account();
					news.customerMenu();
					customerUserTake=true;
					break;
					
				}
			}
			
			System.out.println();
			
		//return p;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return customerUserTake;
		
		
		
		
	}
	public boolean customerExit1(String passCust) {
		boolean customerUserTake1=false;
		try (Connection con = DriverManager.getConnection(URL, username, password)){
			

			PreparedStatement ps = con.prepareStatement("SELECT * FROM bankCustomer WHERE password1=?");

			
			ps.setString(1, passCust );

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				if(rs.getString(3).equals(passCust)){
					Account news = new Account();
					news.customerMenu();
					customerUserTake1=true;
					break;
					
				}
			}
			
			System.out.println();
			
		//return p;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return customerUserTake1;
		
		
		
		
	}
		
		
	
	
	

	@Override
	public Customer getCustomer(String userName){
		Customer p=null;
//		Customer u=new Customer();
		
	
		 
		try (Connection con = DriverManager.getConnection(URL, username, password)){
		

		PreparedStatement ps = con.prepareStatement("SELECT * FROM bankCustomer WHERE userName=?");

		ps.setString(1, userName);

		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			 p= new Customer(rs.getInt("acctId"),rs.getString("userName"),rs.getString("password1"),rs.getString("fName"),rs.getString("lName"),rs.getInt("cusId"), rs.getString("stat"),rs.getDouble("balance"));
					
		}
		
		System.out.println();
		
	//return p;
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return p;
	}
	
	
	public ArrayList<Customer> getAllCustomers(){
		ArrayList<Customer>customers=new ArrayList<Customer>();
		
		try {
			Connection con = DriverManager.getConnection(URL, username, password);
			PreparedStatement ps = con.prepareStatement("SELECT * FROM bankCustomer");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
//				System.out.println(rs.getInt("acctId"));
//				System.out.println(rs.getString("userName"));
//				System.out.println(rs.getString("password"));
//				System.out.println(rs.getString("fName"));
//				System.out.println(rs.getString("lName"));
//				System.out.println(rs.getInt("cusId"));
//				System.out.println(rs.getString("status"));
//				System.out.println(rs.getDouble("balance"));
				customers.add(new Customer(rs.getInt("acctId"), rs.getString("userName"), rs.getString("password1"), rs.getString("fName"),
						rs.getString("lName"), rs.getInt("cusId"), rs.getString("status"), rs.getDouble("balance")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customers;
		}
		
		
		
	
	
	@Override
	public int deleteCustomer(int acctId)  {
		
//		Customer u = new Customer();
		
		try 
			(Connection con = DriverManager.getConnection(URL, username, password)){
			PreparedStatement ps = con.prepareStatement("DELETE FROM bankCustomer WHERE acctId=?");
			
			ps.setInt(1, acctId);
			
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	
	@Override
	public int updateCustomer(Customer u)  {
		
		try (Connection con = DriverManager.getConnection(URL, username, password)){
		PreparedStatement ps = con.prepareStatement("UPDATE bankCustomer SET  balance=(?), status=(?) WHERE acctId=?");
		
		
	
		System.out.println(u.getStatus());
		ps.setString(2, u.getStatus());
		System.out.println(u.getBalance());
		ps.setDouble(1, u.getBalance());
		System.out.println(u.getActtId());
		ps.setInt(3, u.getActtId());
		ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
		
			return 0;
	}
	@Override
	public boolean customerExit(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}	
	}
	
	
	

