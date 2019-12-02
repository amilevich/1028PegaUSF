package com.project.ReimDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.Reimburse.EmployeeUser;
import com.project.Reimburse.Reimburse;

public class ReimburseDaoImp implements ReimburseDao {
	
	
	private static String url
    = "jdbc:oracle:thin:@db1028-stlouis.ct9k1ljscnif.us-east-2.rds.amazonaws.com:1521:ORCL";
    private static String username = "saints1028";
    private static String password = "p4ssw0rd";

    // Create a Reimbursement ticket
	public int addNewTicket(Reimburse newTick) {
			try(Connection na = DriverManager.getConnection(url,username,password)){
			
			PreparedStatement ps = na.prepareStatement("INSERT INTO REIMBURSMENT(REIM_ID,REIM_AMOUNT,REIM_SUBMITTED,REIM_DESCRIPTION,REIM_AUTHOR,REIM_STATUS_ID, REIM_TYPE_ID) VALUES (?,?,?,?,?,?,?)");
			 ps.setInt(1, newTick.getReimbId());
			 ps.setInt(2, newTick.getReimAmt());
			 			 
			 ResultSet grab = ps.executeQuery();
			 
			return 0;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	// To check the verify the account 
	public EmployeeUser pullInfobyUsername(String user) {
		EmployeeUser yt = new EmployeeUser();
		try(Connection na= DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = na.prepareStatement("SELECT * FROM EmployeeUser VALUES WHERE UserName= ?");
			ps.setString(1, user);
			
			ResultSet fnd = ps.executeQuery();
			
		
				yt.setUserName(fnd.getString("UserName"));
				yt.setuPassword(fnd.getString("UserPassword"));
				yt.setUserId(fnd.getInt("UserId"));
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return yt;
	}
	//retrieves all Employee individual tickets
	public Reimburse getAllTickById(int userId) {
		EmployeeUser yt = new EmployeeUser();
		try(Connection na= DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = na.prepareStatement("SELECT * FROM EmployeeUser VALUES WHERE UserId= ?");
			ps.setInt(1, userId);
			
			ResultSet fnd = ps.executeQuery();
			
		
				yt.setUserName(fnd.getString("UserName"));
				yt.setuPassword(fnd.getString("UserPassword"));
				yt.setUserId(fnd.getInt("UserId"));
				
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return yt;
		

	}
	
//Pulling all the Accounts that pending
//		public List<Reimburse> pullAllPendingReimburse() {
//		  int pendingId = 1;	
//		    Reimburse pullinfo = new Reimburse();
//			List<Reimburse> pullPending = new ArrayList<>();
//			try(Connection na = DriverManager.getConnection(url,username,password)){
//				PreparedStatement sw = na.prepareStatement("SELECT * FROM REIMBURSMENT WHERE REIM_STATUS_ID = ?");
//				sw.setInt(1, pendingId);
//				ResultSet pro = sw.executeQuery();
//		
//				while(pro.next()) {
//					
//			
//					 // pullPending.add(pro.getInt("CustomerID"));
//					//pullPending.add(pro.)
//						
//				}
//					
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			return pullPending;
//		}
//		
	//pulls all the accounts
	public List<Reimburse> pullAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}


	// Update the info after the approval process
	@Override
	public int UpdateInfo(int userId, int fUserId, int RemiNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String pullByRoleName(int roleId) {
		String rolename = " ";
		try(Connection na= DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = na.prepareStatement("SELECT * FROM Employeerole VALUES WHERE User_Role_Id= ?");
			ps.setInt(1, roleId);
			
			ResultSet fnd = ps.executeQuery();
			
		
			rolename = fnd.getString("Employee_Role");
				
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rolename;
	}

	@Override
	public String pullStatusName(int statId) {
		String statusName = " ";
		try(Connection na= DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = na.prepareStatement("SELECT * FROM REIMBURSMENT_STATUS VALUES WHERE REIM_STATUS_ID= ?");
			ps.setInt(1, statId);
			
			ResultSet fnd = ps.executeQuery();
			
		
			statusName = fnd.getString("REIM_STATUS");
				
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return statusName;
	}

	@Override
	public String PullReimType(int reimId) {
		String reimType = " ";
		try(Connection na= DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = na.prepareStatement("SELECT * FROM  REIMBURSMENT_TYPE VALUES WHERE REIM_TYPE_ID = ?");
			ps.setInt(1, reimId);
			
			ResultSet fnd = ps.executeQuery();
			
		
			reimType = fnd.getString("REIM_TYPE");
				
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reimType;
		
	}

	

}
