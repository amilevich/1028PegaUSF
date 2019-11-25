package Project0BankAccountM.Project0BankAccountM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpt implements UserDao 
{
	private static String url
	= "jdbc:oracle:thin:@pegakyle1028.csdx8zajy2fa.us-east-1.rds.amazonaws.com:1521:ORCL";
	private static String username = "Kyle1028";
	private static String password = "p4ssw0rd";

	// Inesert a newly created user into the database
	@Override
	public int insertUser(User _user) 
	{
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Users2 VALUES(?,?,?,?,?,?)");
			ps.setString(2, _user.getUserName());
			ps.setByte(1, (byte)_user.getUserType());
			ps.setString(3, _user.getPassword());
			ps.setString(4, _user.getFirstName());
			ps.setString(5, _user.getLastName());
			ps.setInt(6, _user.getAccountNumber());
			ps.executeUpdate();
		}
		catch(SQLIntegrityConstraintViolationException e)
		{
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	// returns a list of uses connected to the supplied account number
	@Override
	public List<User> selectUserByAccountNumber(int _number) 
	{
		List<User> users = new ArrayList<User>(); 
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users2 WHERE user_accountNumber=?");
			//putting in a native SQL query utilizing a prepared statement
			ps.setInt(1, _number);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				users.add(new User(rs.getString("user_username"), rs.getString("user_password"), rs.getByte("user_type"), rs.getString("user_firstname"), rs.getString("user_lastname"), rs.getInt("user_accountNumber")));
			}

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return users;
	}

	// pull a user record from the database based on unique username.
	// Returns: the user record if found in the data base
	//			returns null if used name is not found
	//
	// _username: the inputed unique username to be searched for
	@Override
	public User selectUserByUsername(String _username) 
	{
		User user = null;
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users2 WHERE user_username=?");
			//putting in a native SQL query utilizing a prepared statement
			ps.setString(1, _username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				//collect data
				user = new User(rs.getString("user_username"), rs.getString("user_password"), rs.getByte("user_type"), rs.getString("user_firstname"), rs.getString("user_lastname"), rs.getInt("user_accountNumber"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> selectUserByRealname(String _fname, String _lname) 
	{
		List<User> users = new ArrayList<User>(); 
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users2 WHERE user_firstname=?, user_lastname=?");
			//putting in a native SQL query utilizing a prepared statement
			ps.setString(1, _fname);
			ps.setString(2, _lname);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				users.add(new User(rs.getString("user_username"), rs.getString("user_password"), rs.getByte("user_type"), rs.getString("user_firstname"), rs.getString("user_lastname"), rs.getInt("user_accountNumber")));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return users;
	}

	// Returns a list of all the users in the database
	@Override
	public List<User> selectAllUsers() 
	{
		List<User> users = new ArrayList<User>(); 
		
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users2");
			ResultSet rs = ps.executeQuery();
			//Build the list
			while(rs.next()) 
			{
				users.add(new User(rs.getString(2), rs.getString(3), rs.getInt(1), rs.getString(4), rs.getString(5), rs.getInt(6)));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		// return the list
		return users;
	}

	// Get all the customer records from the database
	@Override
	public List<User> selectAllCustomerUsers() 
	{
		List<User> users = new ArrayList<User>(); 
		
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users2 WHERE user_type=?");
			ps.setInt(1, User.getCustomerCode());
			ResultSet rs = ps.executeQuery();

			//Build the list
			while(rs.next()) 
			{
				users.add(new User(rs.getString(2), rs.getString(3), rs.getInt(1), rs.getString(4), rs.getString(5), rs.getInt(6)));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		// return the list
		return users;
	}

	// Get all the employee records from the database
	@Override
	public List<User> selectAllEmployeeUsers() 
	{
		List<User> users = new ArrayList<User>(); 
		
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users2 WHERE user_type=?");
			ps.setInt(1, User.getEmployeeCode());
			ResultSet rs = ps.executeQuery();

			// Build the list
			while(rs.next()) 
			{
				users.add(new User(rs.getString(2), rs.getString(3), rs.getInt(1), rs.getString(4), rs.getString(5), rs.getInt(6)));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		// return the list
		return users;
	}

	// Get all the admin records from the database
	@Override
	public List<User> selectAllAdminUsers() 
	{
		List<User> users = new ArrayList<User>(); 
		
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users2 WHERE user_type=?");
			ps.setInt(1, User.getAdminCode());
			ResultSet rs = ps.executeQuery();
			//Build the list
			while(rs.next()) 
			{
				users.add(new User(rs.getString(2), rs.getString(3), rs.getInt(1), rs.getString(4), rs.getString(5), rs.getInt(6)));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		// return the list
		return users;
	}

	// update a user's record on file
	@Override
	public int updateUser(User _user) 
	{
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("UPDATE Users2 SET user_password=?, user_firstname=?, user_lastname=?, user_accountNumber=? WHERE user_username=?");
			ps.setString(1, _user.getPassword());
			ps.setString(2, _user.getFirstName());
			ps.setString(3, _user.getLastName());
			ps.setInt(4, _user.getAccountNumber());
			ps.setString(5, _user.getUserName());
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	// Delete a user account
	@Override
	public boolean deleteUser(User _user) 
	{
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			//Make sure the number of admin accounts never drops to zero
			if(_user.isAdmin())
			{
				if(1 == selectAllAdminUsers().size())
				{
					System.out.println("ERROR: you can NOT delete the only admin account");
					return false;
				}
			}
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Users2 WHERE user_username=?");
			ps.setString(1, _user.getUserName());
			ps.executeUpdate();
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	// returns a bool based on if the username is unique or not
	public boolean isUsernameUnique(String _username)
	{
		User user = null;
		user = selectUserByUsername(_username);
		return null == user;
	}


}
