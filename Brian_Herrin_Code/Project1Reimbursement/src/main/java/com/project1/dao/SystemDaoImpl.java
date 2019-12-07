package com.project1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project1.model.Employee;
import com.project1.model.Manager;
import com.project1.model.Reimbursement;

public class SystemDaoImpl implements EmployeeDao, ManagerDao, ReimbursementDao  {
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private static String url = "jdbc:oracle:thin:@revaturepega1028.c6hcjsxpeox2.us-east-1.rds.amazonaws.com:1521:ORCL";
	//private static String url = "jdbc:oracle:thin:@revaturepega1028.c6hcjsxpeox2.us-east-1.rds.amazonaws.com:1521:orcl";
	private static String username = "Project1";
	private static String password = "p4ssw0rd";
	
	@Override
	public int insertReimbursement(Reimbursement r) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Reimbursements VALUES(?,?,?,?,?,?,?)");
			// the reimbursement id is assumed to be prepared server-side
			ps.setDouble(1, r.getAmount());
			// Submission Date is assumed to be prepared server-side
			// Resolved Date is assumed to be prepared server-side
			ps.setString(2, r.getDescription());
			ps.setBlob(3, r.getReceipt());
			ps.setInt(4, r.getEmployeeId());
			ps.setInt(5, r.getManagerId());
			ps.setInt(6, r.getStatusId());
			ps.setInt(7, r.getTypeId());
			System.out.println(r);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public List<Reimbursement> selectEmployeeReimbursementsById(int id) {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR=?");
			//putting in a native SQL query utilizing a prepared statement
			ps.setInt(1, id);
			//we are setting the question mark to be the name that is passed as 
			//a parameter to this method
			//number 1 corresponds to the first question mark in the query
			ResultSet rs = ps.executeQuery();
			//we are executing the query and storing the result set in 
			//a ResultSet type (object)
			while(rs.next()) {
				reimbursements.add(new Reimbursement(rs.getInt("REIMB_ID"), rs.getDouble("REIMB_AMOUNT"), rs.getString("REIMB_SUBMITTED"), rs.getString("REIMB_RESOLVED"), rs.getString("REIMB_DESCRIPTION"), rs.getBlob("REIMB_RECIEPT"), rs.getInt("REIMB_AUTHOR"), rs.getInt("REIMB_RESOLVER"), rs.getInt("REIMB_STATUS_ID"), rs.getInt("REIMB_TYPE_ID")));
			}
			//we are iterating through our result set and populating
			//our Employee object with the values that are coming from the
			//table's columns
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}
	
	@Override
	public void updateReimbursement(Reimbursement r) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int insertManager(Manager m) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Manager selectManagerByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateManager(Manager m) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int insertEmployee(Employee e) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Employee selectEmployeeByName(String name) {
		Employee employee = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			// working here Try to make a nested SQL statement to restrict USERS to just employees, so we don't have managers changing their roles to employees
			// PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_USERS WHERE ERS_USERNAME=? AND ERS_ROLE.");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_USERS WHERE ERS_USERNAME=?");
			
			//putting in a native SQL query utilizing a prepared statement
			ps.setString(1, name);
			//we are setting the question mark to be the name that is passed as 
			//a parameter to this method
			//number 1 corresponds to the first question mark in the query
			ResultSet rs = ps.executeQuery();
			//we are executing the query and storing the result set in 
			//a ResultSet type (object)
			while(rs.next()) {
				employee = new Employee(rs.getInt("ERS_USERS_ID"), rs.getString("ERS_USERNAME"), rs.getString("ERS_PASSWORD"), rs.getString("USER_FIRST_NAME"), rs.getString("USER_LAST_NAME"), rs.getString("USER_EMAIL"), rs.getInt("USER_ROLE_ID"));
			}
			//we are iterating through our result set and populating
			//our Employee object with the values that are coming from the
			//table's columns
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}
	@Override
	public void updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateReimbursementResolved(Reimbursement r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateReimbursementReceipt(Reimbursement r) {
		// TODO Auto-generated method stub
		
	}
}
/*
Defining the Table: Oracle and MySql

create table MyPictures (
   id INT PRIMARY KEY,
   name VARCHAR(0),
   photo BLOB
);
*/
/*    
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JPanel;

public class BlobSelect extends JPanel {
  public static void main(String args[]) throws Exception {
    Connection conn = null;
    byte[] data = getBLOB(01, conn);
  }

  public static byte[] getBLOB(int id, Connection conn) throws Exception {
    ResultSet rs = null;
    PreparedStatement pstmt = null;
    String query = "SELECT photo FROM MyPictures WHERE id = ?";
    try {
      pstmt = conn.prepareStatement(query);
      pstmt.setInt(1, id);
      rs = pstmt.executeQuery();
      rs.next();
      Blob blob = rs.getBlob("photo");
      // materialize BLOB onto client
      return blob.getBytes(1, (int) blob.length());
    } finally {
      rs.close();
      pstmt.close();
      conn.close();
    }
  }

}
*/