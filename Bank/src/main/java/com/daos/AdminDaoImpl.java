package com.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.accounts.Accounts;
import com.admin.Admin;
import com.customers.Customers;


public class AdminDaoImpl implements AdminDao{
	private static String url ="jdbc:oracle:thin:@db1028.ckr66dqj6oqb.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "project0";
	private static String password = "passw0rd";
	
	public int deleteAccounts(Accounts a) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM accounttable WHERE custID=?");
			ps.setInt(1, a.getCustID());
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	
	}

	@Override
	public int insertCustomers(Customers c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Admin selectCustomersByCustID(int custID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customers> selectAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateCustomers(Customers c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCustomers(Customers c) {
		// TODO Auto-generated method stub
		return 0;
	}

}// end clas
