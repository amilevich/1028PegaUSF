package com.project.saintsdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.saintsbank.Account;
import com.project.saintsbank.Customer;
import com.project.saintsbank.Employee;
import com.project.saintsbank.SaintsBankAdmin;

public class SaintsBankCImp implements SaintsDaoC {

	
	private static String url
    = "jdbc:oracle:thin:@db1028-stlouis.ct9k1ljscnif.us-east-2.rds.amazonaws.com:1521:ORCL";
    private static String username = "saintsbank1";
    private static String password = "p4ssw0rd";
    
	@Override
public int insertNewCustomer(Customer newAcct, int status) {
		try(Connection na = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = na.prepareStatement("INSERT INTO Customer VALUES (?,?,?,?,?,?)");
			ps.setInt(1,newAcct.getCustomerID());
			ps.setString(2,newAcct.getcUserName());
			ps.setString(3,newAcct.getcPassword());
			ps.setString(4,newAcct.getFirstName());
			ps.setString(5,newAcct.getLastName());
			ps.setInt(6, status);
			ps.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public Customer findByCustomerId(int cId, int mode) {
		
		Customer pullInfo = new Customer();
	try(Connection na = DriverManager.getConnection(url,username,password)){
		PreparedStatement ps = na.prepareStatement("Select * From Customer WHERE Customerid = ?");
		 ps.setInt(1, cId);
		 
		 ResultSet pullC  = ps.executeQuery();
		 
		 while(pullC.next()) {
			 pullInfo.setCustomerID(pullC.getInt("CustomerID"));
			 pullInfo.setcUserName(pullC.getString("cUsername"));
			 pullInfo.setFirstName(pullC.getString("firstname"));
			 pullInfo.setLastName(pullC.getString("lastName"));
			 pullInfo.setcPassword(pullC.getString("cPassword"));
			 int  statis = pullC.getInt("ApproveStatus");
			 if(statis == 0) {
			 pullInfo.setApprovalStatus(false);
		      }
			 else if(statis == 1) {
			 pullInfo.setApprovalStatus(true);
			 }
		 }
		
		return pullInfo;
	}catch(SQLException e) {
		e.printStackTrace();
	}
		return null;
	}
	@Override
	public int updateAcct(Customer acct) {
		// TODO Auto-generated method stub
		return 0;
	}
	//@Override
	public int searchId(int id, int choice) {
	 try(Connection na = DriverManager.getConnection(url, username,password)){
		 int searchId1 = 0;
		 
		 if(choice == 1) {

		 PreparedStatement ps = na.prepareStatement("SELECT CustomerID FROM Customer WHERE CustomerId = ?");
		  ps.setInt(1, id);
		 
		  ResultSet fin =  ps.executeQuery();
		  
		  while(fin.next()) {
			searchId1 = fin.getInt("customerId");
			System.out.println("ID: " + searchId1);
			
		  }
		  return searchId1;
		 }
		 
		 else if (choice == 2) { 
			 PreparedStatement es = na.prepareStatement("SELECT eUserID FROM Employee WHERE eUserID = ?");
			  es.setInt(1, id);
			 
			  ResultSet fin =  es.executeQuery();
			  
			  while(fin.next()) {
				searchId1 = fin.getInt("eUserId");
				System.out.println("ID: " + searchId1);
			  }
			  return searchId1;
		 }
		 else if(choice == 3) {
			 PreparedStatement as = na.prepareStatement("SELECT adminId FROM BankAdmin WHERE adminId = ?");
			  as.setInt(1, id);
			 
			  ResultSet fin =  as.executeQuery();
			  
			  while(fin.next()) {
				searchId1 = fin.getInt("adminId");
				System.out.println("ID: " + searchId1);
			  }
			  return searchId1;
		 }
		 else{
			 return 0;
		 }
		 
	 }catch(SQLException g) {
		 g.printStackTrace();
	 }
		return 0;
	}
	@Override
	public Employee findByEmployee(int empl) {
		Employee user = new Employee();
		try(Connection na = DriverManager.getConnection(url,username,password)){
			
			PreparedStatement ps = na.prepareStatement("Select * From Employee WHERE eUserId = ?");
			 ps.setInt(1, empl);
			 
			 ResultSet grab = ps.executeQuery();
			 
			 while(grab.next()) {
				 user.seteUserId(grab.getInt("eUserId"));
				 user.seteUser(grab.getString("eUser"));
				 user.setePassword(grab.getString("ePassword"));
				
			 }
			return user;
			

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public SaintsBankAdmin findByAdmin(int empl) {

		SaintsBankAdmin  auser = new SaintsBankAdmin(); 
		try(Connection na = DriverManager.getConnection(url,username,password)){
				PreparedStatement ps = na.prepareStatement("Select * From BankAdmin WHERE adminId = ?");
				 ps.setInt(1, empl);
				 
				 ResultSet grab = ps.executeQuery();
				 
				 while(grab.next()) {
					 auser.setAdminId(grab.getInt("adminId"));
					 auser.setAdminUser(grab.getString("adminUser"));
					 auser.setAdminPass(grab.getString("adminPass"));
				 }
			 
				return auser;
				
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Integer> searchWApproval() {
		int value = 0;
		List<Integer> IdList = new ArrayList<>();
		try(Connection na = DriverManager.getConnection(url,username,password)){
			PreparedStatement sw = na.prepareStatement("SELECT CustomerId FROM Customer WHERE Approvestatus = ?");
			sw.setInt(1, value);
			
			ResultSet pro = sw.executeQuery();
	
			while(pro.next()) {
				
		
					IdList.add(pro.getInt("CustomerID"));
				
			}
			return IdList;
		}catch(SQLException w) {
			w.printStackTrace();
		}
		return null;
	}
	@Override
	public int updateAfterApproval() {
		try(Connection cu = DriverManager.getConnection(url, username, password)){
			//PreparedStatement Cuaa = cu.prepareStatement()
			
		}catch(SQLException c) {
			c.printStackTrace();
		}
		return 0;
	}
	@Override
	public int FinSetUpNew(int cUserId, int acctN, int acctB, String AcctT, int statusA) {
	try(Connection ud = DriverManager.getConnection(url,username, password)){
		PreparedStatement FSUP = ud.prepareStatement("INSERT INTO CAccount VALUES(?,?,?,?)");
		  FSUP.setInt(1, cUserId);
		  FSUP.setInt(2, acctN);
		  FSUP.setString(3, AcctT);
		  FSUP.setInt(4, acctB);
		  FSUP.executeUpdate();
		PreparedStatement stat = ud.prepareStatement("UPDATE Customer SET approvestatus = ? WHERE CustomerId = ?");
		  stat.setInt(1, statusA);
		stat.setInt(2, cUserId);
		stat.executeUpdate();
	}catch(SQLException u) {
		u.printStackTrace();
	}
		return 0;
	}
	@Override
	public Account findAcctById(int Cid) {
		Account tempS = new Account();
	 try(Connection fb = DriverManager.getConnection(url, username, password)){
		 PreparedStatement ac = fb.prepareStatement("SELECT * FROM cAccount WHERE customerid = ?");
		 ac.setInt(1, Cid);
		 
		 ResultSet findAcct = ac.executeQuery();
		 
		 while(findAcct.next()) {
		 
		 tempS.setAccountNumber(findAcct.getInt("accountNumber"));
		 tempS.setAccountBalance(findAcct.getFloat("accountBalance"));
		 tempS.setAccountType(findAcct.getString("accountType"));
		 
		 }
		 
		 return tempS;
	 }catch(SQLException fa) {
		 fa.printStackTrace();
	 }
		return null;
	}
	@Override
	public int UpdateBalance(int Cid, float acctP) {
		try(Connection uB = DriverManager.getConnection(url,username,password)){
			PreparedStatement bal = uB.prepareStatement("UPDATE cAccount SET accountBalance = ? where CustomerID = ?");
			bal.setFloat(1, acctP);
			bal.setInt(2, Cid);
			bal.executeQuery();
		}catch(SQLException b) {
			b.printStackTrace();
		}
		return 0;
	}
    
    
}
