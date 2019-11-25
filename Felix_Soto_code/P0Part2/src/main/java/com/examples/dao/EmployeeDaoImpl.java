package com.examples.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.examples.accounts.AccountMenu;
import com.examples.employeesandadmins.Employees;
public class EmployeeDaoImpl implements  EmployeeDao{

	private static String url= "jdbc:oracle:thin:@db1028.c6ogbmwpzun0.us-east-1.rds.amazonaws.com:1521:orcl";
	private static String username = "Felixsoto1";
	private static String password = "p4ssw0rd";
	
	@Override
	public int insertEmployee(Employees e) {
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Employee VALUES(?,?,?,?,?)");
			ps.setString(1, e.getEmpFirstName());
			ps.setString(2, e.getEmpLastName());
			ps.setNString(3, e.getEmpUsername());
			ps.setNString(4, e.getEmpPassword());
			ps.setInt(5, e.getEmpID());
			ps.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return 0;
	}

	@Override
	public Employees selectEmployeeByEmpID(int empID) {
		Employees emp = null;
		
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Employee WHERE empID=?");
			ps.setInt(1, empID);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				emp = new Employees(rs.getNString("empFirstName"), rs.getNString("empLastName"), rs.getNString("empUsername"),rs.getNString("empPassword"),rs.getInt("empID"));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} 
		return emp;

	}

	@Override
	public List<Employees> selectAllEmployees() {
		List<Employees> empl = new ArrayList<Employees>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Employee");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				empl.add(new Employees(rs.getNString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return empl;
	}

	@Override
	public int updateEmployee(Employees e) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE Employee SET empFirstName=?, empLastName=? , empUserName=?, empPassword=? WHERE empID=?");
			ps.setString(1, e.getEmpFirstName());
			ps.setString(2, e.getEmpLastName());
			ps.setString(3, e.getEmpUsername());
			ps.setString(4, e.getEmpPassword());
			ps.setInt(5, e.getEmpID());
			ps.executeUpdate();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return 0;
		
	}

	@Override
	public int deleteEmployee(Employees e) {
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Employee WHERE empID=?");
			ps.setInt(5, e.getEmpID());
			ps.executeUpdate();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
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


