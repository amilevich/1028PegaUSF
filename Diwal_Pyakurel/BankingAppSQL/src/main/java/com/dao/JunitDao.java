package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accounts.Accounts;
import com.profiles.Customers;
import com.profiles.Profiles;

public class JunitDao {

	private static String url = "jdbc:oracle:thin:@db1028.cnv5m4h5vxru.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String userName = "BankDB";
	private static String password = "password123";

	public String getAllRegistration() {

		ArrayList<Customers> allRegistration = new ArrayList<Customers>();
		Customers customer = new Customers();
		String status = "";
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM regestration");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				allRegistration.add(customer);

			}

			conn.close();
			status = "sucess";

		} catch (SQLException e) {

			e.printStackTrace();
			status="failure";
		}

		return status;
	}

	public String insertRegistration(Customers customer) {
		// TODO Auto-generated method stub
		String status = "";
		int temp = 0;
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);

			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO regestration Values(?,?,?,?,?)");
			ps.setString(1, "Demo");
			ps.setString(2, "Demo");
			ps.setInt(3, 0);
			ps.setString(4, "Demo Demo");
			ps.setInt(5, 0);
			ps.executeUpdate();
			conn.close();

			status = "sucess";

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;

	}
	
	

	public String insertUsers(Profiles profiles) {

		String status = "";
		// TODO Auto-generated method stub
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);

			PreparedStatement ps = conn.prepareStatement("INSERT INTO users Values(?,? ,?, ?)");
			ps.setInt(1, 0);
			ps.setString(2, "Demo");
			ps.setString(3, "Demo");
			ps.setInt(4, 0);
			

			ps.executeUpdate();
			conn.close();
			status = "sucess";

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;

	}

	public String getUsers() {
		String status = "";
		ArrayList<Profiles> allProfiles = new ArrayList<Profiles>();
		Profiles profiles = new Profiles();

		try {
			Connection conn = DriverManager.getConnection(url, userName, password);

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				allProfiles.add(profiles);

			}
			
			status="sucess";

			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
			status="failure";
		}

		return status;
	}

	public String getSocial(String userNam, String pass) {
		// TODO Auto-generated method stub
		String status = "";
		

		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users where user_name = ? and password = ?");
			ps.setString(1, "Diwal");
			ps.setString(2, "Pyakurel");

			ResultSet rs = ps.executeQuery();

			

			status = "sucess";
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status="failure";
		}

		return status;
	}

	public String insertAccounts(Accounts account) {
		String status = "";
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);

			PreparedStatement ps = conn.prepareStatement("INSERT INTO accounts VALUES(?,?,?,?)");
			ps.setInt(1, 0);
			ps.setInt(2, 0);
			ps.setFloat(3, 0);
			ps.setInt(4, 0);
			ps.executeUpdate();

			status = "sucess";
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return status;
	}

	public String getAllAccounts() {
		ArrayList<Accounts> allAccounts = new ArrayList<Accounts>();
		String status = "";

		try {
			Connection conn = DriverManager.getConnection(url, userName, password);

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM accounts");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				allAccounts.add(new Accounts(rs.getInt(2), rs.getFloat(3), null, rs.getInt(4)));

			}

			status = "sucess";

			conn.close();

		} catch (SQLException e) {

			status = "failure";
			e.printStackTrace();
		}

		return status;
	}

	public String addDeposit(int accountNo, float x) {
		String status = "";
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);

			PreparedStatement ps = conn
					.prepareStatement("UPDATE accounts SET balance=balance+? where account_number = ?");
			ps.setFloat(1, 0);
			ps.setInt(2, 0);
			ps.executeUpdate();
			conn.close();
			status = "sucess";
			System.out.println("$" + x + " has been deposited on " + accountNo);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			status = "failure";

		}
		return status;

	}

	public String view(int accountNo, int social) {

		String status = "";

		try {
			Connection conn = DriverManager.getConnection(url, userName, password);

			PreparedStatement ps = conn.prepareStatement(
					"SELECT account_number, balance, social , users.user_name from accounts LEFT JOIN users on accounts.social=users.user_social where account_number = ? and social =?");
			ps.setInt(1, 0);
			ps.setInt(2, 0);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("========================================================");
				System.out.println("Account Number " + rs.getInt(1));
				System.out.println("Balance " + rs.getFloat(2));
				System.out.println("User Social " + rs.getInt(3));
				System.out.println("User Id " + rs.getString(4));
				System.out.println("========================================================");
			}

			conn.close();
			status = "sucess";

		} catch (SQLException e) {

			e.printStackTrace();
			status = "failure";
		}

		return status;

	}

	public String deleteAccount(int accountNo) {
		// TODO Auto-generated method stub
		String status = "";

		try {
			Connection conn = DriverManager.getConnection(url, userName, password);

			PreparedStatement ps = conn.prepareStatement("DELETE FROM accounts where account_number=?");
			ps.setInt(1, 0);

			ps.executeUpdate();
			System.out.println("Account has been deleted");
			conn.close();
			status = "sucess";

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status = "failure";

		}
		return status;

	}

}