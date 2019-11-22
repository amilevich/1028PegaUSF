package com.project.pt1;




/*
 * This will preload our files with a sample customer,employee, and administrator.
 */

import java.io.FileOutputStream;
import java.util.ArrayList;

import com.project.dao.AdminDAOimp;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class testDriver {
	private static String url 
	= "jdbc:oracle:thin:@db1028.cspirgmhfavi.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "Customers";
	private static String password = "p4ssw0rd";
	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		
		
		AdminDAOimp aDAO = new AdminDAOimp();
		
		ArrayList<Admin> adminList = null;
		adminList = aDAO.selectAllAdmin();
				

		ArrayList<Employee> empList = null;
		empList = aDAO.selectAllEmployees();
		
		
		System.out.println("Contents of Employee List: " + empList.toString());
		System.out.println("Contents of Admin List: " + adminList.get(0).toString());
	
		

		
		
	
		
	}
	public static ArrayList<Employee> selectAllEmployees() {
		ArrayList<Employee> list1 = new ArrayList<Employee>();
		try (Connection conn = DriverManager.getConnection(url,username,password)){
		PreparedStatement ps 
		= conn.prepareStatement("SELECT * FROM employees");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				//list1.add(new Employee(rs.getString("user_name"),rs.getString("pass_word"),rs.getString("f_name"),rs.getDouble("salary")));
				list1.add(new Employee(rs.getString(1),rs.getString(2)));
			}
		}
		catch(SQLException e) {
			System.out.println("Connection Failed!");
			e.printStackTrace();
		}
		return list1;
	}
	
	
	
	public static void updateCustomer(Customer x) { //For now it updates funds, app status, and j app status by username.
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps 
			= conn.prepareStatement("UPDATE customers SET "
					+ "funds=?"
					+",app_status=?"
					+ ",j_app_status=?"
					+ ",jBankID=?"
					+ " WHERE bankID=?");
			//USABLE BY DML(CRUD) AND DDL(CREATE ALTER DROP TRUNACTE)
			ps.setDouble(1, x.getFunds());
			ps.setString(2, x.getStatus().toString());
			ps.setString(3, x.getJStatus().toString());
			ps.setInt(4, x.getjBankID());
			ps.setInt(5, x.getBankID());
			ps.executeUpdate();
	
			
			
			System.out.println("Customers Updated.");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

public static void writeAdmin(ArrayList<Admin> x){
	String z = "/Users/Caio/Documents/workspace-sts-3.9.4.RELEASE/ProjectZeroPart1/src/main/java/com/project/pt1/employees/admin/admin.ser";
		try {
			FileOutputStream fop=new FileOutputStream(z);
			ObjectOutputStream oos = new ObjectOutputStream(fop);
			oos.writeObject(x);
			
			oos.close();
			fop.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
public static void writeCustomer(ArrayList<Customer> x){
	String z = "/Users/Caio/Documents/workspace-sts-3.9.4.RELEASE/ProjectZeroPart1/src/main/java/com/project/pt1/applications/customers.ser";
		try {
			FileOutputStream fop=new FileOutputStream(z);
			ObjectOutputStream oos = new ObjectOutputStream(fop);
			oos.writeObject(x);
			
			oos.close();
			fop.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
public static void writeEmployee(ArrayList<Employee> x){
	String z = "/Users/Caio/Documents/workspace-sts-3.9.4.RELEASE/ProjectZeroPart1/src/main/java/com/project/pt1/employees/employees.ser";
		try {
			FileOutputStream fop=new FileOutputStream(z);
			ObjectOutputStream oos = new ObjectOutputStream(fop);
			oos.writeObject(x);
			
			oos.close();
			fop.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}


}

