package com.project0.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.project0.model.Account;
import com.project0.model.Customer;
import com.project0.model.DataBaseAccounts;
import com.project0.model.Employee;

/*
 * JDBC
 * Java Database Connectivity
 * 
 * Important Interfaces:
 * - Connection -> allows us to connect to our DB
 * - Statement -> raw SQL query
 * - PreparedStatement -> precompiles the SQL string without parameters, once
 * parameters are added, they are only treated as values, never keywords
 * - CallableStatement -> same idea as PreparedStatement but is used
 * for stored procedures
 * 
 * Both PreparedStatement and CallableStatement prevent SQL injections
 * 
 * To connect to our database, we need 4 things:
 * 1) URL (endpoint + port number + database name)
 * 2) Username
 * 3) Password
 * 4) Driver (jar that implements JDBC)
 */

public class BankDaoImpl implements AccountDao, ApplicationDao, CustomerDao, EmployeeDao {
	public static BankDaoImpl dBDao = new BankDaoImpl();
	private static String url
	= "jdbc:oracle:thin:@revaturepega1028.c6hcjsxpeox2.us-east-1.rds.amazonaws.com:1521:orcl";
	
	private static String username = "bankAdmin";
	private static String password = "p4ssw0rd";
	
	@Override
	public int insertEmployee(Employee e) {
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			// Integer id, Set<Integer>customerId, double funds, boolean isApproved
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Employees VALUES(?,?,?)");
			ps.setInt(1, e.getId());
			ps.setString(2, e.getUserName() );
			ps.setString(3, e.getPassword() );
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public Employee selectEmployeeByName(String name) {
		Employee employee = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Employees WHERE userName=?");
			//putting in a native SQL query utilizing a prepared statement
			ps.setString(1, name);
			//we are setting the question mark to be the name that is passed as 
			//a parameter to this method
			//number 1 corresponds to the first question mark in the query
			ResultSet rs = ps.executeQuery();
			//we are executing the query and storing the result set in 
			//a ResultSet type (object)
			while(rs.next()) {
				employee = new Employee(rs.getInt("employee_id"), rs.getString("userName"), rs.getString("password"));
			}
			//we are iterating through our result set and populating
			//our Employee object with the values that are coming from the
			//table's columns
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public List<Employee> selectAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM Employees");
		//SQL query goes into our prepared statement
		//we have no question marks, so no setting the values
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			employees.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3)));
		}
		//iterating through the result set, while we still have the next value
		//we populate the new Employee object and add it to the ArrayList
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public int updateEmployee(Employee e) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("UPDATE Employees SET password=? WHERE userName=?");
			ps.setString(1, e.getPassword());
			ps.setString(2, e.getUserName());
			ps.executeUpdate();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteEmployee(Employee e) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Employees WHERE userName=?");
			ps.setString(1, e.getUserName());
			ps.executeUpdate();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int insertCustomer(Customer c) {
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Customers(userName, password, firstName, lastName, account_id) VALUES(?,?,?,?,?)");
			ps.setString(1, c.getUserName() );
			ps.setString(2, c.getPassword() );
			ps.setString(3, c.getFirstName() );
			ps.setString(4, c.getLastName() );
			Iterator<Integer> setIterator = c.getIdAccount().iterator();
			ps.setInt(5, setIterator.next());
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public Customer selectCustomerById(int id) {
		Customer customer = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customers WHERE customer_id=?");
			//putting in a native SQL query utilizing a prepared statement
			ps.setInt(1, id);
			//we are setting the question mark to be the name that is passed as 
			//a parameter to this method
			//number 1 corresponds to the first question mark in the query
			ResultSet rs = ps.executeQuery();
			//we are executing the query and storing the result set in 
			//a ResultSet type (object)
			while(rs.next()) {
				customer = new Customer(rs.getInt("customer_id"), rs.getInt("account_id"), rs.getString("userName"), rs.getString("password"), rs.getString("firstName"), rs.getString("lastName"));
			}
			//we are iterating through our result set and populating
			//our account object with the values that are coming from the
			//table's columns
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}
	@Override
	public Customer selectCustomerByName(String name) {
		Customer customer = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customers WHERE userName=?");
			//putting in a native SQL query utilizing a prepared statement
			ps.setString(1, name);
			//we are setting the question mark to be the name that is passed as 
			//a parameter to this method
			//number 1 corresponds to the first question mark in the query
			ResultSet rs = ps.executeQuery();
			//we are executing the query and storing the result set in 
			//a ResultSet type (object)
			while(rs.next()) {
				customer = new Customer(rs.getInt("customer_id"), rs.getInt("account_id"), rs.getString("userName"), rs.getString("password"), rs.getString("firstName"), rs.getString("lastName"));
			}
			//we are iterating through our result set and populating
			//our account object with the values that are coming from the
			//table's columns
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public List<Customer> selectAllCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customers");
		//SQL query goes into our prepared statement
		//we have no question marks, so no setting the values
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			customers.add(new Customer(rs.getInt("customer_id"), rs.getInt("account_id"), rs.getString("userName"), rs.getString("password"), rs.getString("firstName"), rs.getString("lastName")));
		}
		//iterating through the result set, while we still have the next value
		//we populate the new Pet object and add it to the ArrayList
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

	@Override
	public int updateCustomer(Customer c) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("UPDATE Customers SET account_id=?, userName=?, password=?, firstName=?, lastName=? WHERE customer_id=?");
			Iterator<Integer> setIterator = c.getIdAccount().iterator();
			ps.setInt(1, setIterator.next());
			ps.setString(2, c.getUserName());
			ps.setString(3, c.getPassword());
			ps.setString(4, c.getFirstName());
			ps.setString(5, c.getLastName());
			ps.setInt(6, c.getId());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteCustomer(Customer c) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Customers WHERE customer_id=?");
			ps.setInt(1, c.getId());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int insertApplication(Account a) {
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			// Integer id, Set<Integer>customerId, double funds, boolean isApproved
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Applications(application_id, balance, customer_id) VALUES(?,?,?)");
			ps.setInt(1, a.getAccountId());
			ps.setDouble(2, a.getBalance());
			Iterator<Integer> setIterator = a.getCustomerId().iterator();
			ps.setInt(3, setIterator.next());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public Account selectApplicationById(int id) {
		Account account = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Applications WHERE application_id=?");
			//putting in a native SQL query utilizing a prepared statement
			ps.setInt(1, id);
			//we are setting the question mark to be the name that is passed as 
			//a parameter to this method
			//number 1 corresponds to the first question mark in the query
			ResultSet rs = ps.executeQuery();
			//we are executing the query and storing the result set in 
			//a ResultSet type (object)
			while(rs.next()) {
				account = new Account(rs.getInt("application_id"), rs.getInt("customer_id"), rs.getDouble("balance"), false);
			}
			//we are iterating through our result set and populating
			//our account object with the values that are coming from the
			//table's columns
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public List<Account> selectAllApplications() {
		List<Account> accounts = new ArrayList<Account>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM Applications");
		//SQL query goes into our prepared statement
		//we have no question marks, so no setting the values
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			accounts.add(new Account(rs.getInt("application_id"), rs.getInt("customer_id"), rs.getDouble("balance"), false));
		}
		//iterating through the result set, while we still have the next value
		//we populate the new Pet object and add it to the ArrayList
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public int updateApplication(Account a) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("UPDATE Applications SET balance=? WHERE application_id=?");
			ps.setDouble(1, a.getBalance());
			ps.setInt(2, a.getAccountId());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteApplication(Account a) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Applications WHERE application_id=?");
			ps.setInt(1, a.getAccountId());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int insertAccount(Account a) {
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			// Integer id, Set<Integer>customerId, double funds, boolean isApproved
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Accounts VALUES(?,?,?)");
			ps.setInt(1, a.getAccountId());
			ps.setDouble(2, a.getBalance());
			Iterator<Integer> setIterator = a.getCustomerId().iterator();
			ps.setInt(3, setIterator.next());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Account selectAccountById(int id) {
		Account account = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Accounts WHERE active_account_id=?");
			//putting in a native SQL query utilizing a prepared statement
			ps.setInt(1, id);
			//we are setting the question mark to be the name that is passed as 
			//a parameter to this method
			//number 1 corresponds to the first question mark in the query
			ResultSet rs = ps.executeQuery();
			//we are executing the query and storing the result set in 
			//a ResultSet type (object)
			while(rs.next()) {
				account = new Account(rs.getInt("active_account_id"), rs.getInt("customer_id"), rs.getDouble("balance"), true);
			}
			//we are iterating through our result set and populating
			//our account object with the values that are coming from the
			//table's columns
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public List<Account> selectAllAccounts() {
		List<Account> accounts = new ArrayList<Account>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM Accounts");
		//SQL query goes into our prepared statement
		//we have no question marks, so no setting the values
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			accounts.add(new Account(rs.getInt("active_account_id"), rs.getInt("customer_id"), rs.getDouble("balance"), true));
		}
		//iterating through the result set, while we still have the next value
		//we populate the new Pet object and add it to the ArrayList
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public int updateAccount(Account a) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE Accounts SET balance=? WHERE active_account_id=?");
			ps.setDouble(1, a.getBalance());
			ps.setInt(2, a.getAccountId());
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteAccount(Account a) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Accounts WHERE active_account_id=?");
			ps.setInt(1, a.getAccountId());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
