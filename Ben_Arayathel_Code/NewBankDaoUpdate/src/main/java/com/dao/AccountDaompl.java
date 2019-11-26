package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.backend.Account;

public class AccountDaompl implements AccountDao{
	

	public void Insert(Account a) {
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("INSERT INTO accounttable VALUES(?,?,?,?,?,?,0)");
			PreparedStatement pu = conn.prepareStatement("INSERT INTO usersTable VALUES(?,?)");
			ps.setString(1, a.getiD());
			ps.setString(2, a.getName());
			ps.setDouble(3, a.getBalance());
			if(a.getSecondID()==(null)) {
				ps.setInt(4, 0);
				ps.setString(5, "none");
				ps.setString(6, "none");
				
				pu.setString(1, a.getiD());
				pu.setString(2, a.getiD());
			}else {
				PreparedStatement pk = conn.prepareStatement("INSERT INTO usersTable VALUES(?,?)");
				ps.setInt(4, 1);
				ps.setString(5, a.getSecondName());
				ps.setString(6, a.getSecondID());
				
				pu.setString(1,a.getSecondID());
				pu.setString(2, a.getiD());
				pk.setString(1, a.getiD());
				pk.setString(2, a.getiD());
				pk.executeQuery();
			}
			
			ps.executeUpdate();
			pu.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Uh oh, looks like there was a oopsie in the back end. Whoever made it must have learned it literallly last week.");
		}
	}

	public Account selectAccountByName(String id) {
		Account a = null;
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM accounttable WHERE ID = (SELECT sid FROM userstable WHERE pid = ?)");
			
//			Account test = new Account(name, password, iD, name2, password2, iD2, Balance);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				if(rs.getInt(4) == 0) {
				a = new Account(rs.getString(2),rs.getString(1).replaceAll(rs.getString(2),""),rs.getString(1),rs.getDouble(3));
				}
				else {
					a = new Account(rs.getString(2),rs.getString(1).replaceAll(rs.getString(2), ""),rs.getString(1),rs.getString(5) ,rs.getString(6).replaceAll(rs.getString(5),"")  ,rs.getString(6), rs.getDouble(3));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Uh oh, looks like there was a oopsie in the back end. Whoever made it must have learned it literallly last week.");
		}
		return a;
	}

	public List<Account> selectAllAccounts() {
		List<Account> as = new ArrayList<Account>();
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM AccountTable");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt(4) == 0) {
					as.add(new Account(rs.getString(2),rs.getString(1).replaceAll(rs.getString(2), ""),rs.getString(1),rs.getDouble(3)));
				}else {
					as.add(new Account(rs.getString(2),rs.getString(1).replaceAll(rs.getString(2), ""),rs.getString(1),rs.getString(5) ,rs.getString(6).replaceAll(rs.getString(5),"")  ,rs.getString(6), rs.getDouble(3)));
				}
			}
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			System.out.println("Uh oh, looks like there was a oopsie in the back end. Whoever made it must have learned it literallly last week.");
		}
		return as;
	}

	public int updateAccount(Account a, double amount) {
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("UPDATE AccountTable SET balance=? where id=?");
			ps.setDouble(1, amount);
			ps.setString(2, a.getiD());
			ps.executeQuery();
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			System.out.println("Uh oh, looks like there was a oopsie in the back end. Whoever made it must have learned it literallly last week.");
		}
		return 0;
	}

	public int deleteAccount(Account a) {
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM AccountTable WHERE id =?");
			PreparedStatement pu = conn.prepareStatement("DELETE FROM userstable WHERE sid =?");
			ps.setString(1, a.getiD());
			pu.setString(1, a.getiD());
			ps.executeQuery();
			pu.executeQuery();
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			System.out.println("Uh oh, looks like there was a oopsie in the back end. Whoever made it must have learned it literallly last week.");
		}
		return 0;
	}

		

}
