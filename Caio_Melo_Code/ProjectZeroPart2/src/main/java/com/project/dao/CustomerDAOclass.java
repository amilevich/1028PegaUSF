package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.pt1.Customer;

public class CustomerDAOclass implements CustomerDAO {

	private static String url = "jdbc:oracle:thin:@db1028.cspirgmhfavi.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "Customers";
	private static String password = "p4ssw0rd";

	@Override
	public void insertCustomer(Customer x) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO customers VALUES(?,?,?,?,?,?,null)");

			ps.setInt(1, x.getBankID());
			ps.setString(2, x.getUsername());
			ps.setString(3, x.getPassword());
			ps.setDouble(4, x.getFunds());
			ps.setString(5, x.getStatus());
			ps.setString(6, x.getJStatus());

			ps.executeUpdate();
			// Do this after each update.

		} catch (SQLException e) {
			System.out.println("Connection Failed!");
			e.printStackTrace();
		}

	}

	public Customer selectCustomer(String x) {
		Customer cust = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM customers WHERE user_name=?");
			// Putting in native SQL query
			ps.setString(1, x);

			ResultSet rs = ps.executeQuery();
			// Converts from an SQL result, to usable results.
			// ResultSet is the object.

			while (rs.next()) {
				cust = new Customer(rs.getInt(1), rs.getString("user_name"), rs.getString("pass_word"),
						rs.getDouble("funds"), rs.getString("app_status"), rs.getString("j_app_status"),
						rs.getInt("jbankID"));
				return cust;
			}

		} catch (SQLException e) {
			System.out.println("Connection Failed!");
			e.printStackTrace();
		}
		return cust;
	}

	public Customer selectByID(int x) {
		Customer cust = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM customers WHERE bankID=?");
			// Putting in native SQL query
			ps.setInt(1, x);

			ResultSet rs = ps.executeQuery();
			// Converts from an SQL result, to usable results.
			// Returns result in type (OBJECT)
			while (rs.next()) {
				cust = new Customer(rs.getInt(1), rs.getString("user_name"), rs.getString("pass_word"),
						rs.getDouble("funds"), rs.getString("app_status"), rs.getString("j_app_status"),
						rs.getInt("jbankID"));
				return cust;
			}

		} catch (SQLException e) {
			System.out.println("Connection Failed!");
			e.printStackTrace();
		}
		return cust;
	}

	@Override
	public ArrayList<Customer> selectAllCustomers() {
		ArrayList<Customer> customerList = new ArrayList<Customer>();

		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM customers");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				customerList.add(new Customer(rs.getInt("bankID"), rs.getString("user_name"), rs.getString("pass_word"),
						rs.getDouble("funds"), rs.getString("app_status"), rs.getString("j_app_status"),
						rs.getInt("jbankID")));
			}
		} catch (SQLException e) {
			System.out.println("Connection Failed!");
			e.printStackTrace();
		}
		return customerList;
	}

	public void updateCustomer(Customer x) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE customers SET " + "funds=?" + ",app_status=?"
					+ ",j_app_status=?" + ",jBankID=?" + " WHERE bankID=?");

			ps.setDouble(1, x.getFunds());
			ps.setString(2, x.getStatus().toString());
			ps.setString(3, x.getJStatus().toString());
			ps.setInt(4, x.getjBankID());
			ps.setInt(5, x.getBankID());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteCustomer(Customer x) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM customers WHERE bankID=?");

			ps.setInt(1, x.getBankID());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
