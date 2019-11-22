package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.cars.MyCars;


public class CarsDaoImpl implements CarsDao{
	
	private static String url ="jdbc:oracle:thin:@db1028.ckr66dqj6oqb.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "cars";
	private static String password = "passw0rd";

	@Override
	public int insertCat(MyCars c) {
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Cars VALUES(?,?,?,?)");
			ps.setString(1, c.getMake());
			ps.setString(2, c.getModel());
			ps.setFloat(3, c.getSerial());
			ps.setInt(4, c.getYear());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public MyCars selectCarsByMake(String make) {
		MyCars car = null;
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Cars WHERE cars_make=?");
			//putting in a native SQL query utilizing a prepared statement
			ps.setString(1, make);
			//we are setting the question mark to be the name that is passed as 
			//a parameter to this method
			//number 1 corresponds to the first question mark in the query
			ResultSet rs = ps.executeQuery();
			//we are executing the query and storing the result set in 
			//a ResultSet type (object)
			
			while(rs.next()) {
				car = new MyCars(rs.getString("cars_make"), rs.getString("cars_model"), rs.getInt("cars_year"), rs.getFloat("serial"));
				
			}
			//we are iterating through our result set and populating
			//our pet object with the values that are coming from the
			//table's columns
		}catch(SQLException e) {
			e.printStackTrace();
		} 
		return car;

		
	}

	@Override
	public List<MyCars> selectAllcars() {

		List<MyCars> cars = new ArrayList<MyCars>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Cars");
			//SQL query goes into our prepared statement
			//we have no question marks, so no setting the values
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				cars.add(new MyCars(rs.getNString(1),rs.getNString(2), rs.getInt(3),rs.getFloat(4)));
			}
			//iterating through the result set, while we still have the next value
			//we populate the new Pet object and add it to the ArrayList
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return cars;
	}

	@Override
	public int updateMyCars(MyCars c) {

		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE Cars SET type=? WHERE cars_make=?");
			ps.setString(1, c.getMake());
			ps.setString(2, c.getModel());
			ps.setFloat(3, c.getSerial());
			ps.setInt(4, c.getYear());
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteCat(MyCars c) {

		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Cars WHERE cars_make=?");
			ps.setString(1, c.getMake());
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	
}
