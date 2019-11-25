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
		
		ArrayList<Customer> custList = null;
		custList = MainDriver.cDAO.selectAllCustomers();
	
		String user = "TONY".toLowerCase();
		String pw = "1234".toLowerCase();
		System.out.println("TEST name = " + user + "TEST pw = " + pw);
		
		Customer temp = custList.get(0);
		temp.setJointStatus(jStatus.NOT_JOINT);
		temp.setjBankID(0);
		temp.JointAppDetails[0] = null;
		temp.JointAppDetails[1] = null;
		MainDriver.cDAO.updateCustomer(temp);
		
		
	}
	
	public static ArrayList<Customer> selectAllCustomers() { //DONE
		ArrayList<Customer> customerList = new ArrayList<Customer>();
	
		try (Connection conn = DriverManager.getConnection(url,username,password)){
		
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM customers");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				customerList.add(new Customer(rs.getInt("bankID"),rs.getString("user_name"),rs.getString("pass_word"),rs.getInt("funds"),rs.getString("app_status"),rs.getString("j_app_status"),rs.getInt("jbankID")));	
			}
		}
		catch(SQLException e) {
			System.out.println("Connection Failed!");
			e.printStackTrace();
		}
		return customerList;
	}
	
	public static Customer selectByID(int x) { 
		Customer cust = null;
		try (Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps 
			= conn.prepareStatement("SELECT * FROM customers WHERE bankID=?");
			//Putting in native SQL query
			ps.setInt(1, x);
			
			ResultSet rs = ps.executeQuery();
			//Converts from an SQL result, to usable results.
			//Returns result in type (OBJECT)
			
			while(rs.next()){
				cust = new Customer(rs.getInt(1),rs.getString("user_name"),rs.getString("pass_word"),rs.getDouble(4),rs.getString("app_status"),rs.getString("j_app_status"),rs.getInt("jbankID"));
				return cust;
			}
				
		}
		catch(SQLException e) {
			System.out.println("Connection Failed!");
			e.printStackTrace();
		}
		return cust;
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
public static String low(String x) {
	x = x.toLowerCase();
	return x;
}

}

