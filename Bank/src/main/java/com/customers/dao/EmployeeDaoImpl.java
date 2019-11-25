package com.customers.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accounts.AccountMenu;
import com.employee.Employee;
public class EmployeeDaoImpl implements  EmployeeDao{

	private static String url ="jdbc:oracle:thin:@db1028.ckr66dqj6oqb.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "project0";
	private static String password = "passw0rd";
	
	@Override
	public int insertEmployee(Employee e) {
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Employee VALUES(?,?,?,?,?)");
			ps.setString(1, e.getEmplFname());
			ps.setString(2, e.getEmplLname());
			ps.setNString(3, e.getEmplUserName());
			ps.setNString(4, e.getEmplPassword());
			ps.setInt(5, e.getEmplID());
			ps.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return 0;
	}

	@Override
	public Employee selectEmployeeByEmplID(int emplID) {
		Employee empl = null;
		
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Employee WHERE emplID=?");
			ps.setInt(1, emplID);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				empl = new Employee(rs.getNString("emplFname"), rs.getNString("emplLname"), rs.getNString("emplUserName"),rs.getNString("emplPassword"),rs.getInt("emplID"));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} 
		return empl;

	}

	@Override
	public List<Employee> selectAllEmployee() {
		List<Employee> empl = new ArrayList<Employee>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Employee");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				empl.add(new Employee(rs.getNString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return empl;
	}

	@Override
	public int update(Employee e) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE Employee SET emplFname=?,emplLname=?,emplUserName=?,emplPassword=? WHERE emplID=?");
			ps.setString(1, e.getEmplFname());
			ps.setString(2, e.getEmplLname());
			ps.setString(3, e.getEmplUserName());
			ps.setString(4, e.getEmplPassword());
			ps.setInt(5, e.getEmplID());
			ps.executeUpdate();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return 0;
		
	}

	@Override
	public int deleteEmployee(Employee e) {
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Employee WHERE emplID=?");
			ps.setInt(5, e.getEmplID());
			ps.executeUpdate();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return 0;
	}
	

	public static boolean emplExist(String emplUserName ) {
		boolean emplUsernameTaken = false;
		try(Connection conn = DriverManager.getConnection(url,username,password)){
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM Employee WHERE emplUserName=?");
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


