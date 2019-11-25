package BankingApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoImpl implements UsersDao {

	private static String url = "";

	private static String username = "";
	private static String password = "";

	public int insertUser(Users u) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO userstable (username, passwrd) VALUES(?,?)");
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Users selectUserByName(String name) {
		Users users = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM userstable WHERE name=?");
			// putting in a native SQL query utilizing a prepared statement
			ps.setString(1, name);
			// we are setting the ? to be the name that is passed as a parameter to this
			// method
			// number 1 corresponds to the first question mark in the query.
			ResultSet rs = ps.executeQuery();
			// we are executing the query and storing the result set in a ResultSet
			// type(object)
			while (rs.next()) {
				users = new Users(rs.getString(1), rs.getString(2), rs.getString(3));
			}
			/*
			 * we are iterating through our result set and populating our pet object with
			 * the values.
			 */
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public List<Users> selectAllUsers() {
		List<Users> users = new ArrayList<Users>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM userstable");
			// SQL query goes into our prepared statement
			// we have no question mark, so no setting the values
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				users.add(new Users(rs.getString(1), rs.getString(2), rs.getString(3)));
			}
			// iterating through the result set, while we still have the next value
			// we populate the new User object and add it to the ArrayList
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public int updateUsers(Users u) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE userstable SET type=? WHERE name=?");
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int deleteUsers(Users u) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM userstable WHERE name=?");
			ps.setString(1, u.getUsername());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
