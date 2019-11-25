package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.profiles.Profiles;

public class DaoProfilesTmpl implements DaoProlilesInterface {

	private static String url = "jdbc:oracle:thin:@db1028.cnv5m4h5vxru.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String userName = "BankDB";
	private static String password = "password123";

	@Override
	public void insertUsers(Profiles profiles) {
		// TODO Auto-generated method stub
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);

			PreparedStatement ps = conn.prepareStatement("INSERT INTO users Values(?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, profiles.getUserName());
			ps.setString(3, profiles.getPassword());
			ps.setInt(4, profiles.getSocial());
			ps.executeUpdate();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<Profiles> getUsers() {
		ArrayList<Profiles> allProfiles = new ArrayList<Profiles>();

		try {
			Connection conn = DriverManager.getConnection(url, userName, password);

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				allProfiles.add(new Profiles(rs.getString(2), rs.getString(3), rs.getInt(4), null ));

			}
			
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return allProfiles;
	}

	@Override
	public void deleteUsers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getSocial(String userNam, String pass) {
		// TODO Auto-generated method stub
		
		int social=0;
		
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users where user_name = ? and password = ?");
			ps.setString(1, userNam);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			
			 social= rs.getInt(4);
			 
			 
			 conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return social;
	}


	





}
