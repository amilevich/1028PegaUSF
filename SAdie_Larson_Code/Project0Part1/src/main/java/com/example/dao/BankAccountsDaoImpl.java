package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.example.partone.Account;

public class BankAccountsDaoImpl implements BankAccountsDao {
	private static String url = "jdbc:oracle:thin:@db1028.cdvifhysxq7a.us-east-1.rds.amazonaws.com:1521:orcl";
	private static String username = "larson_sadie";
	private static String password = "passw4rd";
	// need to change these above values

	@Override
	public void insertBankAccounts(Account acc) {
		System.out.println(acc);
		int j = 1;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO AccountU VALUES(?,?,?,?,?,?,?,?,?)");
			ps.setInt(j, acc.getHashKey()); // need to add in trigger
			ps.setInt(j + 1, acc.getHashKey());
			ps.setInt(j + 2, acc.getApplicationStatus());
			int temp = 1;
			for (Entry<String, String> i : (acc.userPass).entrySet()) {
				if (acc.userPass.size() <= 1) {
					ps.setString(j + 3, i.getKey());
					ps.setString(j + 4, i.getValue()); // make it the user pass table userPass
					ps.setString(j + 5, "NULL");
					ps.setString(j + 6, "NULL"); // make it the user pass table userPass

				} else { // more than one account
					if (temp == 1) {// first user
						ps.setString(j + 3, i.getKey());
						ps.setString(j + 4, i.getValue()); // make it the user pass table userPass
					} else {// second user
						ps.setString(j + 5, i.getKey());
						ps.setString(j + 6, i.getValue()); // make it the user pass table userPass
					}
				}
				temp++;
			}
			ps.setInt(j + 7, acc.getUserType());
			ps.setInt(j + 8, acc.getJoint());
			ps.executeUpdate();
			// ****************Joint************************//
			if (acc.userPass.size() > 1) {// joint account {
				ps = conn.prepareStatement("INSERT INTO AccountM VALUES(?,?,?)");
				ps.setFloat(1, acc.accounts.get("shared checking"));
				ps.setFloat(2, acc.accounts.get("shared savings"));
				ps.setInt(3, acc.getHashKey());
				ps.executeUpdate();
			}
			// ****************account with money************************//
			else if (acc.getUserType() == 1) {// client
				ps = conn.prepareStatement("INSERT INTO AccountM VALUES(?,?,?)");
				ps.setFloat(1, acc.accounts.get("checking"));
				ps.setFloat(2, acc.accounts.get("savings"));
				ps.setInt(3, acc.getHashKey());
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Account selectById(int a_accountKey) {
		Account acc = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM AccountU WHERE a_accountKey=?");
			ps.setInt(1, a_accountKey);
			ResultSet rs = ps.executeQuery();

			PreparedStatement ps2 = conn.prepareStatement("SELECT * FROM AccountM WHERE a_pKey_fk=?");
			ps2.setInt(1, a_accountKey);
			ResultSet rs2 = ps2.executeQuery();
			while (rs.next() && rs2.next()) {
				acc = new Account(rs.getInt("a_accountKey"), rs.getInt("a_accountStatus"), rs.getString("a_userName1"),
						rs.getString("a_passWord1"), rs.getString("a_userName2"), rs.getString("a_passWord2"),
						rs.getInt("a_userType"), rs.getInt("a_joint"), rs2.getFloat("a_checking"),
						rs2.getFloat("a_savings"));
				System.out.println("Printing this:" + acc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acc;
	}

	@Override
	public HashMap<Integer, Account> selectBankAccounts() {
		HashMap<Integer, Account> bankAccounts = new HashMap<Integer, Account>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM AccountU");
			ResultSet rs = ps.executeQuery();
			PreparedStatement ps2 = conn.prepareStatement("SELECT * FROM AccountM");
			ResultSet rs2 = ps2.executeQuery();
			while (rs.next()) {
				if (rs.getInt("a_userType") == 1) {
					rs2.next(); // clients
					Account acc = new Account(rs.getInt("a_accountKey"), rs.getInt("a_accountStatus"),
							rs.getString("a_userName1"), rs.getString("a_passWord1"), rs.getString("a_userName2"),
							rs.getString("a_passWord2"), rs.getInt("a_userType"), rs.getInt("a_joint"),
							rs2.getFloat("a_checking"), rs2.getFloat("a_savings"));
					bankAccounts.put(rs.getInt("a_accountKey"), acc); // bankAccounts.add(new Account(add in from
				} // insert);
				else {// employee/sysad
					Account acc = new Account(rs.getInt("a_accountKey"), rs.getInt("a_accountStatus"),
							rs.getString("a_userName1"), rs.getString("a_passWord1"), rs.getString("a_userName2"),
							rs.getString("a_passWord2"), rs.getInt("a_userType"), rs.getInt("a_joint"));
					bankAccounts.put(rs.getInt("a_accountKey"), acc); // bankAccounts.add(new Account(add in from
				}
			}
		} catch (

		SQLException e) {
			e.printStackTrace();
		}
		return bankAccounts;

	}

	@Override
	public void updateBankAccounts(Account acc) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps;
			System.out.println(acc);
			if (acc.getUserType() == 1) {// client
				ps = conn.prepareStatement(
						"UPDATE AccountU SET a_passWord1=?, a_passWord2=?, a_accountStatus=? WHERE a_accountKey=?");
				ps.setInt(3, acc.getApplicationStatus());
				ps.setInt(4, acc.getHashKey());
				int temp = 0;
				for (Entry<String, String> i : (acc.userPass).entrySet()) {
					if (temp == 0) {
						ps.setString(1, i.getValue());
						temp++;
					}
					if (acc.userPass.size() < 2) {
						ps.setString(2, "NULL");
					} else {
						ps.setString(2, i.getValue());
					}
				}
				ps.executeUpdate();
			} else {// system/emp
				System.out.println("hello");
				ps = conn.prepareStatement("UPDATE AccountU SET a_passWord1=? WHERE a_accountKey=?");
				ps.setInt(2, acc.getHashKey());
				int temp = 0;
				for (Entry<String, String> i : (acc.userPass).entrySet()) {
					if (temp == 0) {
						ps.setString(1, i.getValue());
						temp++;
					}
				}
				ps.executeUpdate();
			}

			// ****************account with money************************//
			if (acc.getUserType() == 1 && acc.userPass.size() == 1) {// client
				ps = conn.prepareStatement("UPDATE AccountM SET a_checking=?,a_savings=? WHERE a_pKey_fk=?");
				ps.setFloat(1, acc.accounts.get("checking"));
				ps.setFloat(2, acc.accounts.get("savings"));
				ps.setInt(3, acc.getHashKey());
				ps.executeUpdate();
			} else if (acc.getUserType() == 1) {
				ps = conn.prepareStatement("UPDATE AccountM SET a_checking=?,a_savings=? WHERE a_pKey_fk=?");
				ps.setFloat(1, acc.accounts.get("shared checking"));
				ps.setFloat(2, acc.accounts.get("shared savings"));
				ps.setInt(3, acc.getHashKey());
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override // good
	public void deleteBankAccounts(int key) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM AccountU WHERE a_accountKey=?");
			ps.setInt(1, key);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
