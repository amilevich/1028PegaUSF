package yeah.me;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BankDaoImpl implements Bank1 {
	
	private static String url
	= "jdbc:oracle:thin:@deadbool.c8qedumffy9a.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "Bank";
	private static String password = "p4ssw0rd";
	
	@Override
	public int insertacc(account p) {
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Bank VALUES(?,?,?,?,?,?)");
			ps.setDouble(1, p.getBalance());
			ps.setString(2, p.getId());
			ps.setString(3, p.getUsername());
			ps.setString(4, p.getPassword());
			ps.setString(5, p.getCusna());
			ps.setInt(6, p.getStatus());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void main(String[] args) {
//		account testaccnt = new account(0.0,"a","b","c","d");	
//		BankDaoImpl asdf = new BankDaoImpl();
//		
//		asdf.insertacc(testaccnt);
		//Bank.test();
		
		}

	@Override
	public account selectaccByName(account p) {
		account chase = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Bank WHERE username=?");
			//putting in a native SQL query utilizing a prepared statement
			ps.setString(1, p.getUsername());
			//we are setting the question mark to be the name that is passed as 
			//a parameter to this method
			//number 1 corresponds to the first question mark in the query
			ResultSet rs = ps.executeQuery();
			//we are executing the query and storing the result set in 
			//a ResultSet type (object)
			while(rs.next()) {
				chase = new account(0, rs.getString("Id"), rs.getString("Username"),rs.getString("password"), rs.getString("cusname"),rs.getInt("status"));
			}
			//we are iterating through our result set and populating
			//our pet object with the values that are coming from the
			//table's columns
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return chase;
	}

	@Override
	public List<account> selectAllaccount(account p) {
		List<account> chase = new ArrayList<account>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM Bank");
		//SQL query goes into our prepared statement
		//we have no question marks, so no setting the values
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			chase.add(new account(0, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}
		//iterating through the result set, while we still have the next value
		//we populate the new Pet object and add it to the ArrayList
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return chase;
	}
	
	public List<account> selectAllaccount() {
		List<account> chase = new ArrayList<account>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM Bank");
		//SQL query goes into our prepared statement
		//we have no question marks, so no setting the values
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			chase.add(new account( rs.getDouble(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
		}
		//iterating through the result set, while we still have the next value
		//we populate the new Pet object and add it to the ArrayList
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return chase;
	}


	@Override
	public int updateacc(account p) {
		System.out.println(p.getStatus());
		System.out.println(p.getId());
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE Bank SET  status=?, balance= ? WHERE Id=?");
			ps.setInt(1, p.getStatus());
			ps.setDouble(2, p.getBalance());
			ps.setString(3, p.getId());
			
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteacc(account p) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Bank WHERE name=?");
			ps.setString(1, p.getId());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	

	
}
