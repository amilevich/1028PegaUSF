package com.simulation.test;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.project1.model.Reimbursement;
import com.project1.model.Users;



public class TestDaos {
		static{
		       try {
		           Class.forName("oracle.jdbc.driver.OracleDriver");
		       } catch (ClassNotFoundException e) {
		           e.printStackTrace();
		       }
		   }
	// ENDPOINT revaturepega1028.c6hcjsxpeox2.us-east-1.rds.amazonaws.com
	private static String url = "jdbc:oracle:thin:@revaturepega1028.c6hcjsxpeox2.us-east-1.rds.amazonaws.com:1521:ORCL";
	private static String username = "Project1";
	private static String password = "p4ssw0rd";

	//insert Users parameters 
		public boolean insertUsers(Users p) {
			try (Connection conn = DriverManager.getConnection(url, username, password)) {
				//int insertUpdate = 0;
				PreparedStatement ps = conn.prepareStatement("INSERT INTO ERS_USERS VALUES(?,?,?,?,?,?,?)");
				ps.setInt(1,p.getUsersId());
				ps.setString(2, p.getName());
				ps.setString(3, p.getPassword());
				ps.setString(4, p.getFirstName());
				ps.setString(5, p.getLastName());
				ps.setString(6, p.getEmail());
				ps.setInt(7, p.getRole());
				//System.out.println(p);
				ps.executeUpdate();
				return true;
				// insertUpdate = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return true;
		}


		// inserts Reimbursement parameters 
		
		public void insertReimbursement(Reimbursement p) {
			try (Connection conn = DriverManager.getConnection(url, username, password)) {
				//int insertUpdate = 0;
				PreparedStatement ps = conn.prepareStatement("INSERT INTO ERS_REIMBURSEMENT VALUES(?,?,?,?,?,?,?)");
				ps.setInt(1,p.getId());
				ps.setDouble(2, p.getAmount());
				ps.setTimestamp(3, p.getDateSubmitted());
				ps.setTimestamp(4, p.getDateResolved());
				ps.setString(5, p.getDescription());
				ps.setBlob(6, p.getReceipt());
				ps.setInt(7, p.getEmployeeId());
				ps.setInt(8, p.getManagerId());
				ps.setInt(9, p.getStatusId());
				ps.setInt(10, p.getTypeId());
				//System.out.println(p);
				ps.executeUpdate();
				// insertUpdate = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	// Returns a Users object of the passed username.

	public boolean selectUsers(String name) {
		Users users = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_USERS WHERE ERS_USERNAME=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int userid = rs.getInt("ERS_USERS_ID");
				String usernamee = rs.getString("ERS_USERNAME");
				String passwordd = rs.getString("ERS_PASSWORD");
				String firstName = rs.getString("USER_FIRST_NAME");
				String lastName = rs.getString("USER_LAST_NAME");
				String email = rs.getString("USER_EMAIL");
				
				int roleId = rs.getInt("USER_ROLE_ID");
				
//					UserRoles role = null;
//					if(roleId != 0){
//						UserRolesImpl roleDAO = new UserRolesImpl();
//						role = roleDAO.createRoleObj(roleId);
//					}	
				
				users = new Users(userid,usernamee,passwordd,firstName,lastName,email,roleId);
			
			}
			return true;
			//users = new Users(userid,usernamee,passwordd,firstName,lastName,email,roleId);
				//users = new Users(rs.getString(1),rs.getString(2));
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}
		
	}

	// Select Users by password


	public Users selectUsersByPassword(String USER_PASSWORD) {
		Users users = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_USERS WHERE ERS_PASSWORD=?");
			ps.setString(1, USER_PASSWORD);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int userid = rs.getInt("ERS_USERS_ID");
				String usernamee = rs.getString("ERS_USERNAME");
				String passwordd = rs.getString("ERS_PASSWORD");
				String firstName = rs.getString("USER_FIRST_NAME");
				String lastName = rs.getString("USER_LAST_NAME");
				String email = rs.getString("USER_EMAIL");
				
				int roleId = rs.getInt("USER_ROLE_ID");
//					UserRoles role = null;
//					if(roleId != 0){
//						UserRolesImpl roleDAO = new UserRolesImpl();
//						role = roleDAO.createRoleObj(roleId);
//					}	
//					if (users == null) {
//						users= new Users(0,",",",",",",",",",",0);
//					}
				users = new Users(userid,usernamee,passwordd,firstName,lastName,email,roleId);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Users object: " + users);
		return users;
	}


	// Select Users by ID


		public Users selectUsersByID(int USER_ID) {
			Users users = null;
			try (Connection conn = DriverManager.getConnection(url, username, password)) {
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_USERS WHERE ERS_USERS_ID=?");
				ps.setInt(1, USER_ID);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					int userid = rs.getInt("ERS_USERS_ID");
					String usernamee = rs.getString("ERS_USERNAME");
					String passwordd = rs.getString("ERS_PASSWORD");
					String firstName = rs.getString("USER_FIRST_NAME");
					String lastName = rs.getString("USER_LAST_NAME");
					String email = rs.getString("USER_EMAIL");
					
					int roleId = rs.getInt("USER_ROLE_ID");
//						UserRoles role = null;
//						if(roleId != 0){
//							UserRolesImpl roleDAO = new UserRolesImpl();
//							role = roleDAO.createRoleObj(roleId);
//						}	
//						if (users == null) {
//							users= new Users(0,",",",",",",",",",",0);
//						}
					users = new Users(userid,usernamee,passwordd,firstName,lastName,email,roleId);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Users object: " + users);
			return users;
		}
		
		//select all users
		

		public List<Users> selectAllUsers() {
			List<Users> userArray = new ArrayList<Users>();
			try (Connection conn = DriverManager.getConnection(url, username, password)) {
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_USERS WHERE ERS_USERS_ID=?");
				//ps.setInt(1, USER_ID);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					int userid = rs.getInt("ERS_USERS_ID");
					String usernamee = rs.getString("ERS_USERNAME");
					String passwordd = rs.getString("ERS_PASSWORD");
					String firstName = rs.getString("USER_FIRST_NAME");
					String lastName = rs.getString("USER_LAST_NAME");
					String email = rs.getString("USER_EMAIL");
					int roleId = rs.getInt("USER_ROLE_ID");
//						UserRoles role = null;
//						if(roleId != 0){
//							UserRolesImpl roleDAO = new UserRolesImpl();
//							role = roleDAO.createRoleObj(roleId);
//						}	
//						if (users == null) {
//							users= new Users(0,",",",",",",",",",",0);
//						}
					userArray.add(new Users(userid,usernamee,passwordd,firstName,lastName,email,roleId));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//System.out.println("Users object: " + userArray);
			return userArray;
		}
		public boolean updateReimbursements(int l,String user,String e,String d,String c ,String k,int a) {
			return true;
		}
//		@Override
//		public int updatePet(Pet p) {
//			try (Connection conn = DriverManager.getConnection(url, username, password)) {
	//
//				PreparedStatement ps = conn.prepareStatement("INSERT INTO Pets VALUES(?,?)");
//				ps.setString(1,p.getName());
//				ps.setString(2, p.getType());
//				System.out.println(p);
//				ps.executeUpdate();
//				
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			return 0;
//		}

		
		
		// selecting Pending Reimbursements requests (pending status id is 1)
		

		public List<Reimbursement> selectReimbPending(){
				List<Reimbursement> obj = new ArrayList<Reimbursement>();
				try (Connection conn = DriverManager.getConnection(url, username, password)) {
					//pending reimbursement status
					PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_STATUS_ID=1");
					//ps.setInt(1, USER_ID);
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						int id = rs.getInt("REIMB_ID");
						double amount = rs.getDouble("REIMB_AMOUNT");
						Timestamp dateSubmitted = rs.getTimestamp("REIMB_SUBMITTED");
						Timestamp dateResolved = rs.getTimestamp("REIMB_RESOLVED");
						String description = rs.getString("REIMB_DESCRIPTION");
						Blob receipt = rs.getBlob("REIMB_RECEIPT");
						int employeeId = rs.getInt("REIMB_AUTHOR");
						int managerId = rs.getInt("REIMB_RESOLVER");
						int statusId = rs.getInt("REIMB_STATUS_ID");
						int typeId = rs.getInt("REIMB_TYPE_ID");
//							UserRoles role = null;
//							if(roleId != 0){
//								UserRolesImpl roleDAO = new UserRolesImpl();
//								role = roleDAO.createRoleObj(roleId);
//							}	
//							if (users == null) {
//								users= new Users(0,",",",",",",",",",",0);
//							}
						obj.add(new Reimbursement(id,amount,dateSubmitted,dateResolved,description,receipt,employeeId,managerId,statusId,typeId));
						
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				//System.out.println("Users object: " + userArray);
				return obj;
			}
				public boolean updateUsers(String user) {
					return true;
				}
				public boolean approveReimb(String user) {
					return true;
				}public boolean denyReimb(String user) {
					return true;
				}
		public List<Reimbursement> selectReimbAll(){
				List<Reimbursement> obj = new ArrayList<Reimbursement>();
				
				try (Connection conn = DriverManager.getConnection(url, username, password)) {
					//pending reimbursement status
					PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT");
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						int id = rs.getInt("id");
						double amount = rs.getDouble("REIMB_AMOUNT");
						Timestamp dateSubmitted = rs.getTimestamp("REIMB_SUBMITTED");
						Timestamp dateResolved = rs.getTimestamp("REIMB_RESOLVED");
						String description = rs.getString("REIMB_DESCRIPTION");
						Blob receipt = rs.getBlob("REIMB_RECEIPT");
						int employeeId = rs.getInt("REIMB_AUTHOR");
						int managerId = rs.getInt("REIMB_RESOLVER");
						int statusId = rs.getInt("REIMB_STATUS_ID");
						int typeId = rs.getInt("REIMB_TYPE_ID");
//							UserRoles role = null;
//							if(roleId != 0){
//								UserRolesImpl roleDAO = new UserRolesImpl();
//								role = roleDAO.createRoleObj(roleId);
//							}	
//							if (users == null) {
//								users= new Users(0,",",",",",",",",",",0);
//							}
						obj.add(new Reimbursement(id,amount,dateSubmitted,dateResolved,description,receipt,employeeId,managerId,statusId,typeId));
						
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				//System.out.println("Users object: " + userArray);
				return obj;
			}
		
		//updates reimbursement by their ID
		
		public boolean updateReimb(Reimbursement obj) {
			try (Connection conn = DriverManager.getConnection(url, username, password)) {
				//int insertUpdate = 0;
				PreparedStatement ps = conn.prepareStatement
				("UPDATE ERS_REIMBURSEMENT SET REIMB_RESOLVED=?,REIMB_STATUS_ID=? WHERE REIMB_ID=?");
				ps.setDate(1,new Date(System.currentTimeMillis()));
				ps.setInt(2,obj.getStatusId());
				ps.setInt(3,obj.getId());
				ps.executeUpdate();
				return true;
				// insertUpdate = ps.executeUpdate();
				//LogFunc.logger.info(obj.getId() + " " + obj.getStatusId());
			} catch (SQLException e) {
				e.printStackTrace();
				return true;
			}
		}
		
		public boolean approveReimb(int id) {
			try (Connection conn = DriverManager.getConnection(url, username, password)) {
				PreparedStatement ps = conn.prepareStatement("UPDATE ERS_REIMBURSEMENT SET " + "REIMB_RESOLVED=?, REIMB_STATUS=? WHERE REIMB_ID=?");
				ps.setDate(1, new Date(System.currentTimeMillis()));
				ps.setInt(2, 2);
				ps.setInt(3, id);
				ps.executeUpdate();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
		

		public boolean denyReimb(int id) {
			try (Connection conn = DriverManager.getConnection(url, username, password)) {
				PreparedStatement ps = conn.prepareStatement("UPDATE ERS_REIMBURSEMENT SET " + "REIMB_RESOLVED=?, REIMB_STATUS=? WHERE REIMB_ID=?");
				ps.setDate(1, new Date(System.currentTimeMillis()));
				ps.setInt(2, 3);
				ps.setInt(3, id);
				ps.executeUpdate();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}

	}


