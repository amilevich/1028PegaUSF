package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Pet;

/*
 * JDBC
 * 
 * SQL injection - you are allowed to put SQL queries then USERS can hack your data. AVOID
 * - Connection --> allows us to connect to our DB
 * - Statement -> raw SQL query 
 * - PreparedStatement -> precompiles the SQL string without parameters, once parameters are added, they are only treated as values, never keywords
 * - Callabale Statemet -> same idea as Prepeared Statement but is used for stored procedures
 * 
 *  Both PreparedStatement and CallableStatement prevent SQL injection
 *  
 *  To connect to our database, we need 4 things:
 *  
 *  1) URL (endpoint + port number + database name)
 *  2) Username
 *  3) Passowrd
 *  4) Driver (Jar that implements JDBC)
 */
public class PetDaoImpl implements PetDao {
	
	private static String urL
	= "jdbc:oracle:thin:@my1028pegausf.c8fjsw7dnsyi.us-west-1.rds.amazonaws.com:1521:orcl";
	
	private static String username = "Pets";
	private static String password = "p4ssw0rd";

	
	public int insertPet(Pet p) {
		try (Connection conn = DriverManager.getConnection(urL,username,password)){
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Pets VALUES(?,?)");
			ps.setString(1, p.getName());
			ps.setString(2, p.getType());
			// we are using ps.executeUpdate() because we are updating the table
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Pet selectPetByName(String name) {
		Pet pet = null;
		try(Connection conn = DriverManager.getConnection(urL, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Pets WHERE name = ?");
			//putting in a native SQL query utilizing a prepared statement
			ps.setString(1, name);
			//we are setting the question mark to be the name that is passed as our parameter to this method
			//number 1 corresponds to the first question mark in the query
			//we are using ps.executeQuery because we are using different actions. We are getting from table.
			ResultSet rs = ps.executeQuery();
			//we are executing the query and storing the result set in a ResultSet type (Object)
			while(rs.next()) {
				pet = new Pet(rs.getString("name"), rs.getString("type"));
			}
			System.out.println("Select by Pet name complete");
			return pet;
			//we are iterating through our result set and populating our pet object with the values that are coming from the table's columns
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Pet> SelectAllPets() {
		List<Pet> pets = new ArrayList<Pet>();
		try(Connection conn = DriverManager.getConnection(urL, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Pets");
			//SQL query goes into our prepared statement
			//we have no question marks, so no setting the values
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				pets.add(new Pet(rs.getString(1), rs.getString(2)));
			}
			//iterating through the result set, while we still have the next value, we poplulate the new pet OBject and add it to the ArrayList
			
			System.out.println("Select all complete");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return pets;
	}

	public int updatePet(Pet p) {
		try (Connection conn = DriverManager.getConnection(urL, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE Pets SET type=? WHERE name=?");
			ps.setString(1, p.getType());
			ps.setString(2, p.getName());
			ps.executeUpdate();
			System.out.println("Update complete");

		} catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int deletePet(Pet p) {
		try(Connection conn = DriverManager.getConnection(urL, username, password)){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Pets WHERE name=?");
			ps.setString(1, p.getName());
			ps.executeUpdate();
			System.out.println("Delete complete");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
