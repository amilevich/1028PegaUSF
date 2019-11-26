package com.bankapp.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
	
	private static String url = "jdbc:oracle:thin:@db1028.crupjhvflrra.us-east-1.rds.amazonaws.com:1521:orcl";
	private static String username = "BankAdmin";
	private static String password = "p4ssw0rd";

	@Override
	public int insertAccount(Account a) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Account(balance, type, status) VALUES(?,?,?)");
			ps.setDouble(1, a.getBalance());
			ps.setString(2, a.getType());
			ps.setString(3, a.getStatus());
			ps.executeUpdate();
		}catch (SQLException e) {
			
		}
		return 0;
	}

	@Override
	public Account selectAccountByID(int accountSelect) {
		Account account = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Account WHERE AccID =?");
			ps.setInt(1, accountSelect);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				account = new Account(rs.getInt("AccID"), rs.getDouble("balance"), rs.getString("type"), rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public List<Account> selectAllAccounts() {
		List<Account> accounts = new ArrayList<Account>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Account");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				accounts.add(new Account(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return accounts;
	}

	@Override
	public double addBalance(Customer a) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE Account SET balance=? WHERE accID=?");
			ps.setDouble(1, a.getBalance());
			ps.setInt(2, a.getAccID());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public double subtractBalance(Customer a) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE Account SET balance=? WHERE accID=?");
			ps.setDouble(1, a.getBalance());
			ps.setInt(2, a.getAccID());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int approveAccount(Customer a) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE Account SET status=? WHERE accID=?");
			System.out.println(a.getStatus());
			ps.setString(1, a.getStatus());
			ps.setInt(2, a.getAccID());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int cancelAccount(Customer a) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE Account SET status=? WHERE accID=?");
			ps.setString(1, a.getStatus());
			ps.setInt(2, a.getAccID());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteAccount(Customer a) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Account WHERE accID=?");
			ps.setInt(1, a.getAccID());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
