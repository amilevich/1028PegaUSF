package com.customers.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accounts.Accounts;

public class AccountsDaoImpl implements AccountsDao{
	private static String url ="jdbc:oracle:thin:@db1028.ckr66dqj6oqb.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "project0";
	private static String password = "passw0rd";
	
	
	@Override
	public int insertAccounts(Accounts a) {
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("INSERT INTO AccountTable VALUES(?,?,?,?,?,?,?,?)");
			ps.setInt(1, a.getAccID());
			ps.setInt(2, a.getIsJoint());
			ps.setString(3, a.getStatus());
			ps.setDouble(4, a.getBalance());
			ps.setString(5, a.getAccCustFname());
			ps.setString(6, a.getAccCustLname());
			ps.setDouble(7, a.getPreviousTransaction());
			System.out.println(a.getCustID());
			ps.setInt(8, a.getCustID());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}
	
	
	@Override
	public Accounts selectAccountsByAccountID(int accID) {
		
		Accounts acc = null;

		try(Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM AccountTable WHERE accID=?");
			ps.setInt(1, accID);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				acc = new Accounts(rs.getInt("accID"), rs.getInt("isJoint"), rs.getString("status"), rs.getDouble("balance"), rs.getString("accCustFname"), rs.getString("accCustLname"), rs.getDouble("previousTransaction"), rs.getInt("CustID"));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} 
		return acc;
	}
	@Override
	public List<Accounts> selectAllAccounts() {
	List<Accounts> acc = new ArrayList<Accounts>();
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM AccountTable");
		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				acc.add(new Accounts(rs.getInt(1), rs.getInt(2),rs.getNString(3),rs.getDouble(4),rs.getNString(5), rs.getNString(6),rs.getDouble(7),rs.getInt(8)));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return acc;
	}
	@Override
	public int updateAccounts(Accounts a) {
try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE AccountTable SET IsJoint=?,Status=?,Balance=?,AccCustFname=?,AccCustLname=?,PreviousTransaction=?,CustID=? WHERE accID=?");
			ps.setInt(1, a.getAccID());
			ps.setInt(2, a.getIsJoint());
			ps.setString(3, a.getStatus());
			ps.setDouble(4, a.getBalance());
			ps.setNString(5, a.getAccCustFname());
			ps.setNString(6, a.getAccCustLname());
			ps.setDouble(7, a.getPreviousTransaction());
			ps.setInt(8, a.getCustID());
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int deleteAccounts(Accounts a) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM AccountTable WHERE custID=?");
			ps.setInt(1, a.getCustID());
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	
	}


}//end class
