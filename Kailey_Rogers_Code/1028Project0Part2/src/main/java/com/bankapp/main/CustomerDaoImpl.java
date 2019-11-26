package com.bankapp.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

	private static String url = "jdbc:oracle:thin:@db1028.crupjhvflrra.us-east-1.rds.amazonaws.com:1521:orcl";
	private static String username = "BankAdmin";
	private static String password = "p4ssw0rd";

	@Override
	public int insertCustomer(Customer c) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Customer(userUsername, userPassword, userFirstName, userLastName, jointAccID) VALUES(?,?,?,?,?)");
			ps.setString(1, c.getUserUsername());
			ps.setString(2, c.getUserPassword());
			ps.setString(3, c.getUserFirstName());
			ps.setString(4, c.getUserLastName());
			ps.setInt(5, c.getJointAccID());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Customer selectCustomerByUsername(String name) {
		Customer customer = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customer WHERE userUsername =?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				customer = new Customer(rs.getInt("userID"), rs.getString("userUsername"), rs.getString("userPassword"),
						rs.getString("userFirstName"), rs.getString("userLastName"), rs.getInt("jointAccID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public HashMap<String, Customer> selectAllCustomers() {
		HashMap<String, Customer> customers = new HashMap<String, Customer>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customer");
			PreparedStatement ps2 = conn.prepareStatement("SELECT * FROM Account");
			ResultSet rs = ps.executeQuery();
			ResultSet rs2 = ps2.executeQuery();
			while (rs.next()) {
				rs2.next();
				customers.put(rs.getString(2), (new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs2.getInt(1), rs2.getDouble(2), rs2.getString(3), rs2.getString(4))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customers;
	}

	@Override
	public int deleteCustomer(Customer c) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Customer WHERE userUsername=?");
			ps.setString(1, c.getUserUsername());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateCustomerFirstName(Customer c) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE Customer SET userFirstName=? WHERE userUsername=?");
			ps.setString(1, c.getUserFirstName());
			ps.setString(2, c.getUserUsername());
			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateCustomerLastName(Customer c) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE Customer SET userLastName=? WHERE userUsername=?");
			ps.setString(1, c.getUserLastName());
			ps.setString(2, c.getUserUsername());
			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateCustomerPassword(Customer c) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE Customer SET userPassword=? WHERE userUsername=?");
			ps.setString(1, c.getUserPassword());
			ps.setString(2, c.getUserUsername());
			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
