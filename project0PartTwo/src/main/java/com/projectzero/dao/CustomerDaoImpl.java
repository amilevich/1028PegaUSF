package com.projectzero.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.projectzero.menu.AccountMenu;
import com.projectzero.menu.CustomerMenu;

import project0PartOne.Customer;

public class CustomerDaoImpl implements CustomerDao {
	private static String url = "";
	private static String username = "";
	private static String password = "";

	@Override
	public int insert(Customer cust) {
		try (Connection conn = DriverManager.getConnection(url,username,password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Customer VALUES(?,?,?,?,?)");
			ps.setInt(1, cust.getCustomerID());
			ps.setString(2, cust.getCustomerFirstName());
			ps.setString(3, cust.getCustomerLastName());
			ps.setString(4, cust.getCustomerUsername());
			ps.setString(5, cust.getCustomerPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public Customer getCustomerByFirstName(String customerFirstName) {
		Customer cust = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customer WHERE customerFirstName=?");
			ps.setString(1, customerFirstName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cust = new Customer(rs.getInt("customerID"), rs.getString("customerFirstName"),
						rs.getString("customerLastName"), rs.getString("customerUsername"),
						rs.getString("customerPassword"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cust;
	}

	@Override
	public Customer getCustomerByLastName(String customerLastName) {
		Customer cust = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customer WHERE customerLastName=?");
			ps.setString(1, customerLastName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cust = new Customer(rs.getInt("customerID"), rs.getString("customerFirstName"),
						rs.getString("customerLastName"), rs.getString("customerUsername"),
						rs.getString("customerPassword"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cust;
	}

	@Override
	public int createCustomer(Customer cust) {
		int createdCustomers = 0;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO Customer (customerID, customerFirstName, customerLastName, customerUsername, customerPassword) VALUES (?,?,?,?,?)");
			ps.setInt(1, cust.getCustomerID());
			ps.setString(2, cust.getCustomerFirstName());
			ps.setString(3, cust.getCustomerLastName());
			ps.setString(4, cust.getCustomerUsername());
			ps.setString(5, cust.getCustomerPassword());
			createdCustomers = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return createdCustomers;
	}

	@Override
	public int updateCustomer(Customer cust) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE Customer customerFirstName=?, customerLastName=?, customerUsername=?, customerPassword=?, WHERE customerID=? ");
			ps.setInt(1, cust.getCustomerID());
			ps.setString(2, cust.getCustomerFirstName());
			ps.setString(3, cust.getCustomerLastName());
			ps.setString(4, cust.getCustomerUsername());
			ps.setString(5, cust.getCustomerPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
		}
		return 0;
	}

	@Override
	public int deleteCustomer(int customerID) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Customer WHERE customerID=?");
			ps.setInt(1, customerID);
			
			ps.executeUpdate();
			System.out.println("record deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Customer> selectAllCustomers() {
		List<Customer> cust = new ArrayList<Customer>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customer");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cust.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cust;
	}

	@Override
	public boolean customerExists(int customerID) {
		boolean customerExists = false;
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customer WHERE customerID=?");
			ps.setInt(1, customerID);
			ResultSet rs = ps.executeQuery();
			int idCount;
			while(rs.next()) {
				idCount = rs.getInt("customerID");
				if(idCount == customerID) {
					System.out.println("customer exists");
					customerExists = true;
				}else {
					System.out.println("customer does not exist");
					customerExists = false;
				}
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return customerExists;
	}

	@Override
	public boolean isUsernameUnique(Customer cust) {
		boolean isUnique = false;
		String customerUsername = cust.getCustomerUsername();
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customer WHERE customerUsername=?");
			
			ps.setString(1, customerUsername);
			ResultSet rs = ps.executeQuery();
			if(!rs.isBeforeFirst()) {
				isUnique = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return isUnique;
	}

	@Override
	public boolean ispasswordUnique(Customer cust) {
		boolean isUnique = false;
		String customerPassword = cust.getCustomerPassword();
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customer WHERE customerPassword=?");
			
			ps.setString(1, customerPassword);
			ResultSet rs = ps.executeQuery();
			if(!rs.isBeforeFirst()) {
				isUnique = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return isUnique;
	}

	@Override
	public Customer getCustomerByUsername(String customerUsername) {
		Customer cust = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customer WHERE customerUsername=?");
			ps.setString(1, customerUsername);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cust = new Customer(rs.getInt("customerID"), rs.getString("customerFirstName"),
						rs.getString("customerLastName"), rs.getString("customerUsername"),
						rs.getString("customerPassword"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cust;
	}

	@Override
	public boolean customerExists(String customerUsername) {
		boolean customerUsernameTaken = false;
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customer WHERE customerUsername=?");
			ps.setString(1, customerUsername);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString(4).equals(customerUsername)) {
					customerUsernameTaken = true;
					break;
				}
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return customerUsernameTaken;
	}

	@Override
	public boolean customerExists2(String customerPassword) {
		boolean customerPasswordTaken = false;
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customer WHERE customerPassword=?");
			ps.setString(1, customerPassword);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString(5).equals(customerPassword)) {
					customerPasswordTaken = true;
					AccountMenu am = new AccountMenu();
					am.PullCustomerAccountByCustomerID();
					break;
				}
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return customerPasswordTaken;
		
	}

	@Override
	public Customer getCustomerByID(int customerID) {
		Customer cust = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customer WHERE customerID=?");
			ps.setInt(1, customerID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cust = new Customer(rs.getInt("customerID"), rs.getString("customerFirstName"),
						rs.getString("customerLastName"), rs.getString("customerUsername"),
						rs.getString("customerPassword"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cust;
	}

	@Override
	public int deleteCustomer(Customer cust) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Customer WHERE customerFirstName=?");
			ps.setString(1, cust.getCustomerFirstName());
			
			ps.executeUpdate();
			System.out.println("record deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
