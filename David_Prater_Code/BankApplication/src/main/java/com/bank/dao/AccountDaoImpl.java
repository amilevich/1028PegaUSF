package com.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.model.Account;

public class AccountDaoImpl  {

	private static String url = "jdbc:oracle:thin:@db1028.crsokuwxumhe.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "BankApplication";
	private static String password = "p4ssw0rd";

	public static int insertAccount(Account a) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO BankApplication VALUES(?,?,?,?,?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, a.getAccountNumber());
			ps.setDouble(3, a.getAccountBalance());
			ps.setString(4, a.getFirstName());
			ps.setString(5, a.getLastName());
			ps.setString(6, a.getAddress());
			ps.setString(7, a.getUsername());
			ps.setString(8, a.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static Account selectAccountByNumber(String a) {
		Account account = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM BankApplication WHERE AccountNumber=?");
			// putting in a native SQL query utilizing a prepared statement
			ps.setString(1, a);
			// we are setting the question mark to be the name that is passed as
			// a parameter to this method
			// number 1 corresponds to the first question mark in the query
			ResultSet rs = ps.executeQuery();
			// we are executing the query and storing the result set in
			// a ResultSet type (object)
			while (rs.next()) {
				account = new Account(rs.getString("accountNumber"), rs.getDouble("acountBalance"),
						rs.getString("firstName"), rs.getString("lastName"), rs.getString("address"),
						rs.getString("username"), rs.getString("password"));
			}
			// we are iterating through our result set and populating
			// our account object with the values that are coming from the
			// table's columns

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}
	
	public static Account selectAccountByID(String a) {
		Account account = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM BankApplication WHERE username=?");
			// putting in a native SQL query utilizing a prepared statement
			ps.setString(1, a);
			// we are setting the question mark to be the name that is passed as
			// a parameter to this method
			// number 1 corresponds to the first question mark in the query
			ResultSet rs = ps.executeQuery();
			// we are executing the query and storing the result set in
			// a ResultSet type (object)
			while (rs.next()) {
				account = new Account(rs.getInt("accountID"), rs.getString("accountNumber"), rs.getDouble("acountBalance"),
						rs.getString("firstName"), rs.getString("lastName"), rs.getString("address"),
						rs.getString("username"), rs.getString("password"));
			}
			// we are iterating through our result set and populating
			// our account object with the values that are coming from the
			// table's columns

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	public static List<Account> selectAllAccounts() {
		List<Account> accounts = new ArrayList<Account>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM BankApplication");
			// SQL query goes into our prepared statement
			// we have no question marks, so no setting the values
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				accounts.add(new Account(rs.getInt(1), rs.getString(2), rs.getDouble(3),
						rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getString(7), rs.getString(8)));
			}
			// iterating through the result set, while we still have the next value
			// we populate the new Account object and add it to the ArrayList

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	public static int updateAccount(Account a) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement(
					"UPDATE BankApplication SET acountBalance=? WHERE AccountNumber=?");
			ps.setDouble(1, a.getAccountBalance());
			ps.setString(2, a.getAccountNumber());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static int deleteAccount(Account a) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM BankApplication WHERE AccountNumber=?");
			ps.setString(1, a.getAccountNumber());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
