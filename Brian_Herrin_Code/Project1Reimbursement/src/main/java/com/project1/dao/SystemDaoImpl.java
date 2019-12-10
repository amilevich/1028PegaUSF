package com.project1.dao;

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

import com.project1.logger.LogFunc;
//import com.project1.logger.LogFunc;
//import com.project1.model.Employee;
//import com.project1.model.Manager;
import com.project1.model.Reimbursement;
import com.project1.model.Users;

public class SystemDaoImpl implements ReimbursementDao, UsersDao {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private static String url = "jdbc:oracle:thin:@revaturepega1028.c6hcjsxpeox2.us-east-1.rds.amazonaws.com:1521:ORCL";
	// private static String url =
	// "jdbc:oracle:thin:@revaturepega1028.c6hcjsxpeox2.us-east-1.rds.amazonaws.com:1521:orcl";
	private static String username = "Project1";
	private static String password = "p4ssw0rd";

	@Override
	public int insertReimbursement(Reimbursement r) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO ERS_REIMBURSEMENT (REIMB_ID, REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_DESCRIPTION, REIMB_RECEIPT, REIMB_AUTHOR, REIMB_STATUS_ID, REIMB_TYPE_ID) VALUES(?,?,?,?,?,?,?,?)");
			// the reimbursement id is assumed to be prepared server-side
			ps.setInt(1, 0);
			ps.setDouble(2, r.getAmount());
			ps.setDate(3, new Date(System.currentTimeMillis()));
			// Resolved Date is assumed to be prepared server-side
			ps.setString(4, r.getDescription());
			ps.setBlob(5, r.getReceipt());
			ps.setInt(6, r.getEmployeeId());
			ps.setInt(7, r.getStatusId());
			ps.setInt(8, r.getTypeId());
			//System.out.println("insertReimbursement " + r);
			LogFunc.log.info("Insert " + r.toString());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/*
	 * // inserts Reimbursement parameters
	 * 
	 * @Override public void insertReimbursement(Reimbursement p) { try (Connection
	 * conn = DriverManager.getConnection(url, username, password)) { //int
	 * insertUpdate = 0; PreparedStatement ps =
	 * conn.prepareStatement("INSERT INTO ERS_REIMBURSEMENT VALUES(?,?,?,?,?,?,?)");
	 * ps.setInt(1,p.getId()); ps.setDouble(2, p.getAmount()); ps.setTimestamp(3,
	 * p.getDateSubmitted()); ps.setTimestamp(4, p.getDateResolved());
	 * ps.setString(5, p.getDescription()); ps.setBlob(6, p.getReceipt());
	 * ps.setInt(7, p.getEmployeeId()); ps.setInt(8, p.getManagerId()); ps.setInt(9,
	 * p.getStatusId()); ps.setInt(10, p.getTypeId()); //System.out.println(p);
	 * ps.executeUpdate(); // insertUpdate = ps.executeUpdate(); } catch
	 * (SQLException e) { e.printStackTrace(); } }
	 */
	@Override
	public List<Reimbursement> selectReimbursementsByUsersId(int id) {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR=?");
			// putting in a native SQL query utilizing a prepared statement
			ps.setInt(1, id);
			// we are setting the question mark to be the name that is passed as
			// a parameter to this method
			// number 1 corresponds to the first question mark in the query
			ResultSet rs = ps.executeQuery();
			// we are executing the query and storing the result set in
			// a ResultSet type (object)
			while (rs.next()) {
				// System.out.println(rs.getRow() + ": " + rs.next());
				int newId = rs.getInt("REIMB_ID");
				double newAmount = rs.getDouble("REIMB_AMOUNT");
				Timestamp newSubmission = rs.getTimestamp("REIMB_SUBMITTED");
				Timestamp newResolved = rs.getTimestamp("REIMB_RESOLVED");
				String newDescription = rs.getString("REIMB_DESCRIPTION");
				Blob newReciept = rs.getBlob("REIMB_RECEIPT");
				int newAuthor = rs.getInt("REIMB_AUTHOR");
				int newResolver = rs.getInt("REIMB_RESOLVER");
				int newStatusId = rs.getInt("REIMB_STATUS_ID");
				int newTypeId = rs.getInt("REIMB_TYPE_ID");
				reimbursements.add(new Reimbursement(newId, newAmount, newSubmission, newResolved, newDescription,
						newReciept, newAuthor, newResolver, newStatusId, newTypeId));
			}
			// we are iterating through our result set and populating
			// our Employee object with the values that are coming from the
			// table's columns

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public void updateReimbursement(Reimbursement obj) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			//int insertUpdate = 0;
			PreparedStatement ps = conn.prepareStatement
			("UPDATE ERS_REIMBURSEMENT SET REIMB_RESOLVED=?,REIMB_STATUS_ID=? WHERE REIMB_ID=?");
			ps.setDate(1,new Date(System.currentTimeMillis()));
			ps.setInt(2,obj.getStatusId());
			ps.setInt(3,obj.getId());
			ps.executeUpdate();
			// insertUpdate = ps.executeUpdate();
			LogFunc.log.info("Update " + obj.toString());
			//LogFunc.logger.info("Update: " + obj.getId() + " " + obj.getStatusId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Reimbursement> selectReimbursementPending() {
		List<Reimbursement> obj = new ArrayList<Reimbursement>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_STATUS_ID=1");
			// ps.setInt(1, USER_ID);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
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
//						UserRoles role = null;
//						if(roleId != 0){
//							UserRolesImpl roleDAO = new UserRolesImpl();
//							role = roleDAO.createRoleObj(roleId);
//						}	
//						if (users == null) {
//							users= new Users(0,",",",",",",",",",",0);
//						}
				obj.add(new Reimbursement(id, amount, dateSubmitted, dateResolved, description, receipt, employeeId,
						managerId, statusId, typeId));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// System.out.println("Users object: " + userArray);
		return obj;
	}

	@Override
	public void updateReimbursement(int resolved, int status, int id) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			//int insertUpdate = 0;
			PreparedStatement ps = conn.prepareStatement
			("UPDATE ERS_REIMBURSEMENT SET REIMB_RESOLVED=?, REIMB_RESOLVER=?, REIMB_STATUS_ID=? WHERE REIMB_ID=?");
			ps.setDate(1,new Date(System.currentTimeMillis()));
			ps.setInt(2,resolved);
			ps.setInt(3,status);
			ps.setInt(4,id);
			ps.executeUpdate();
			// insertUpdate = ps.executeUpdate();
			LogFunc.log.info("Updated " + id + " Resolver: " + resolved + " Resolve Code:" + status);
			//LogFunc.logger.info("Updated " + id + " Resolver: " + resolved + " Resolve Code:" + status);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * @Override public Employee selectEmployeeByName(String name) { Employee
	 * employee = null; try(Connection conn = DriverManager.getConnection(url,
	 * username, password)){ // working here Try to make a nested SQL statement to
	 * restrict USERS to just employees, so we don't have managers changing their
	 * roles to employees // PreparedStatement ps = conn.
	 * prepareStatement("SELECT * FROM ERS_USERS WHERE ERS_USERNAME=? AND ERS_ROLE."
	 * ); PreparedStatement ps =
	 * conn.prepareStatement("SELECT * FROM ERS_USERS WHERE ERS_USERNAME=?");
	 * 
	 * //putting in a native SQL query utilizing a prepared statement
	 * ps.setString(1, name); //we are setting the question mark to be the name that
	 * is passed as //a parameter to this method //number 1 corresponds to the first
	 * question mark in the query ResultSet rs = ps.executeQuery(); //we are
	 * executing the query and storing the result set in //a ResultSet type (object)
	 * while(rs.next()) { employee = new Employee(rs.getInt("ERS_USERS_ID"),
	 * rs.getString("ERS_USERNAME"), rs.getString("ERS_PASSWORD"),
	 * rs.getString("USER_FIRST_NAME"), rs.getString("USER_LAST_NAME"),
	 * rs.getString("USER_EMAIL"), rs.getInt("USER_ROLE_ID")); } //we are iterating
	 * through our result set and populating //our Employee object with the values
	 * that are coming from the //table's columns
	 * 
	 * } catch(SQLException e) { e.printStackTrace(); } return employee; }
	 */

	@Override
	public void updateReimbursementResolved(Reimbursement r) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateReimbursementReceipt(Reimbursement r) {
		// TODO Auto-generated method stub

	}

	@Override
	public Users selectUsers(String name) {
		Users users = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_USERS WHERE ERS_USERNAME=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int userid = rs.getInt("ERS_USERS_ID");
				String usernamee = rs.getString("ERS_USERNAME");
				String passwordd = rs.getString("ERS_PASSWORD");
				String firstName = rs.getString("USER_FIRST_NAME");
				String lastName = rs.getString("USER_LAST_NAME");
				String email = rs.getString("USER_EMAIL");

				int roleId = rs.getInt("USER_ROLE_ID");
//				UserRoles role = null;
//				if(roleId != 0){
//					UserRolesImpl roleDAO = new UserRolesImpl();
//					role = roleDAO.createRoleObj(roleId);
//				}	
				if (users == null) {
					users = new Users(0, ",", ",", ",", ",", ",", 0);
				}
				users = new Users(userid, usernamee, passwordd, firstName, lastName, email, roleId);

			}
			// users = new
			// Users(userid,usernamee,passwordd,firstName,lastName,email,roleId);
			// users = new Users(rs.getString(1),rs.getString(2));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// System.out.println("Users object: " + users);
		return users;
	}

	@Override
	public Users selectUsersByPassword(String USER_PASSWORD) {
		Users users = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_USERS WHERE ERS_PASSWORD=?");
			ps.setString(1, USER_PASSWORD);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int userid = rs.getInt("ERS_USERS_ID");
				String usernamee = rs.getString("ERS_USERNAME");
				String passwordd = rs.getString("ERS_PASSWORD");
				String firstName = rs.getString("USER_FIRST_NAME");
				String lastName = rs.getString("USER_LAST_NAME");
				String email = rs.getString("USER_EMAIL");

				int roleId = rs.getInt("USER_ROLE_ID");
//				UserRoles role = null;
//				if(roleId != 0){
//					UserRolesImpl roleDAO = new UserRolesImpl();
//					role = roleDAO.createRoleObj(roleId);
//				}	
//				if (users == null) {
//					users= new Users(0,",",",",",",",",",",0);
//				}
				users = new Users(userid, usernamee, passwordd, firstName, lastName, email, roleId);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Users object: " + users);
		return users;
	}

	@Override
	public Users selectUsersByID(int USER_ID) {
		Users users = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_USERS WHERE ERS_USERS_ID=?");
			ps.setInt(1, USER_ID);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int userid = rs.getInt("ERS_USERS_ID");
				String usernamee = rs.getString("ERS_USERNAME");
				String passwordd = rs.getString("ERS_PASSWORD");
				String firstName = rs.getString("USER_FIRST_NAME");
				String lastName = rs.getString("USER_LAST_NAME");
				String email = rs.getString("USER_EMAIL");

				int roleId = rs.getInt("USER_ROLE_ID");
//				UserRoles role = null;
//				if(roleId != 0){
//					UserRolesImpl roleDAO = new UserRolesImpl();
//					role = roleDAO.createRoleObj(roleId);
//				}	
//				if (users == null) {
//					users= new Users(0,",",",",",",",",",",0);
//				}
				users = new Users(userid, usernamee, passwordd, firstName, lastName, email, roleId);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Users object: " + users);
		return users;
	}

	@Override
	public List<Users> selectAllUsers() {
		List<Users> userArray = new ArrayList<Users>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_USERS WHERE ERS_USERS_ID=?");
			// ps.setInt(1, USER_ID);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int userid = rs.getInt("ERS_USERS_ID");
				String usernamee = rs.getString("ERS_USERNAME");
				String passwordd = rs.getString("ERS_PASSWORD");
				String firstName = rs.getString("USER_FIRST_NAME");
				String lastName = rs.getString("USER_LAST_NAME");
				String email = rs.getString("USER_EMAIL");
				int roleId = rs.getInt("USER_ROLE_ID");
//				UserRoles role = null;
//				if(roleId != 0){
//					UserRolesImpl roleDAO = new UserRolesImpl();
//					role = roleDAO.createRoleObj(roleId);
//				}	
//				if (users == null) {
//					users= new Users(0,",",",",",",",",",",0);
//				}
				userArray.add(new Users(userid, usernamee, passwordd, firstName, lastName, email, roleId));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// System.out.println("Users object: " + userArray);
		return userArray;
	}

	@Override
	public void insertUsers(Users p) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			// int insertUpdate = 0;
			PreparedStatement ps = conn.prepareStatement("INSERT INTO ERS_USERS VALUES(?,?,?,?,?,?,?)");
			ps.setInt(1, p.getUsersId());
			ps.setString(2, p.getName());
			ps.setString(3, p.getPassword());
			ps.setString(4, p.getFirstName());
			ps.setString(5, p.getLastName());
			ps.setString(6, p.getEmail());
			ps.setInt(7, p.getRole());
			// System.out.println(p);
			ps.executeUpdate();
			LogFunc.log.info("Insert " + p.toString());
			// insertUpdate = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateUsers(Users user) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			// int insertUpdate = 0;
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE ERS_USERS SET ERS_PASSWORD=?,USER_FIRST_NAME=?,USER_LAST_NAME=?,USER_EMAIL=? WHERE ERS_USERS_ID=?");
			ps.setInt(5, user.getUsersId());
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getFirstName());
			ps.setString(3, user.getLastName());
			ps.setString(4, user.getEmail());
			ps.executeUpdate();
			LogFunc.log.info("Update " + user.toString());
			// insertUpdate = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Users updateUsersById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users updateUsersByName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> selectAllReimbursements() {
		List<Reimbursement> obj = new ArrayList<Reimbursement>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			// pending reimbursement status
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
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
				obj.add(new Reimbursement(id, amount, dateSubmitted, dateResolved, description, receipt, employeeId, managerId, statusId, typeId));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// System.out.println("Users object: " + userArray);

		return obj;
	}

	@Override
	public void approveReimbursement(int id) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE ERS_REIMBURSEMENT SET " + "REIMB_RESOLVED=?, REIMB_STATUS=? WHERE REIMB_ID=?");
			ps.setDate(1, new Date(System.currentTimeMillis()));
			ps.setInt(2, 2);
			ps.setInt(3, id);
			ps.executeUpdate();
			LogFunc.log.info("Approved " + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void denyReimbursement(int id) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE ers_reimbursement SET " + "date_resolved=?, status=? WHERE ticket_id=?");
			ps.setDate(1, new Date(System.currentTimeMillis()));
			ps.setInt(2, 3);
			ps.setInt(3, id);
			ps.executeUpdate();
			LogFunc.log.info("Denied " + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}
/*
 * Defining the Table: Oracle and MySql
 * 
 * create table MyPictures ( id INT PRIMARY KEY, name VARCHAR(0), photo BLOB );
 */
/*
 * import java.sql.Blob; import java.sql.Connection; import
 * java.sql.PreparedStatement; import java.sql.ResultSet;
 * 
 * import javax.swing.JPanel;
 * 
 * public class BlobSelect extends JPanel { public static void main(String
 * args[]) throws Exception { Connection conn = null; byte[] data = getBLOB(01,
 * conn); }
 * 
 * public static byte[] getBLOB(int id, Connection conn) throws Exception {
 * ResultSet rs = null; PreparedStatement pstmt = null; String query =
 * "SELECT photo FROM MyPictures WHERE id = ?"; try { pstmt =
 * conn.prepareStatement(query); pstmt.setInt(1, id); rs = pstmt.executeQuery();
 * rs.next(); Blob blob = rs.getBlob("photo"); // materialize BLOB onto client
 * return blob.getBytes(1, (int) blob.length()); } finally { rs.close();
 * pstmt.close(); conn.close(); } }
 * 
 * }
 */