package com.app.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BankImpl implements BankDao{

	private static String url = "";
	private static String username = "";
	private static String password = "";

	public HashMap<String, Customer> getCHashMap(){ //Get customer 
		HashMap<String, Customer>hashMapC = selectAllCusts(); 
		ArrayList<SqlKeys> keys_list = fetchSqlKeys();
		for(SqlKeys tkey: keys_list) {
			hashMapC.get(tkey.serial_ID).accounts.add(tkey.serialNum); 
		}
		return hashMapC;
	}

	public HashMap<String, Account> getAHashMap(){
		HashMap<String, Account>hashMapA = selectAllAccts(); 
		ArrayList<SqlKeys> keys_list = fetchSqlKeys();
		for(SqlKeys tkey: keys_list) {
			hashMapA.get(tkey.serialNum).customers.add(tkey.serial_ID);
		}
		return hashMapA;
	}

	@Override
	public ArrayList<SqlKeys> fetchSqlKeys(){ //ArrayList of Customer Foreign Keys Cust (Serial_ID) = primary key, Account (serialNum) = foreign key
		ArrayList<SqlKeys> keys_list = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM KeySets");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				SqlKeys tkey = new SqlKeys(rs.getInt("serial_ID"), rs.getInt("serialNum"));
				keys_list.add(tkey);
				conn.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return keys_list;
	}

	@Override
	public HashMap<String, Customer> selectAllCusts(){
		HashMap<String, Customer> HashMapC = new HashMap<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customer");
			ResultSet rs = ps.executeQuery();
			conn.close();
			while(rs.next()) {
				Customer cust = new Customer(rs.getInt("serial_ID"), rs.getString("userName"), rs.getString("userPin"), rs.getString("Name"));
				HashMapC.put(cust.userName, cust);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return HashMapC;
	}

	@Override
	public HashMap<String, Account> selectAllAccts(){
		HashMap<String, Account> HashMapA = new HashMap<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Accounts");
			ResultSet rs = ps.executeQuery();
			conn.close();
			while(rs.next()) {
				Account acct = new Account(rs.getInt("serialNum"), rs.getString("accNum"), rs.getFloat("balance"));
				HashMapA.put(acct.accNum, acct);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return HashMapA;
	}

	@Override
	public void truncateCustomers() { //Clear Customers table
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("TRUNCATE TABLE Customer");
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Truncate fail.");
		}
	}

	@Override
	public void truncateAccounts() {//Clear Accounts table
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("TRUNCATE TABLE Account");
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Truncate fail.");
		}
	}
	
	@Override
	public void truncateSqlKeys() {//Clear keys
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("TRUNCATE TABLE KeySets"); 
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Truncate fail.");
		}
	}

	@Override
	public int insertAllCusts(HashMap<String, Customer>hashMapC) {
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			Iterator<Map.Entry<String, Customer>> hmIterator = hashMapC.entrySet().iterator(); 
			while (hmIterator.hasNext()) { 
				Map.Entry<String, Customer> mapElement = (Map.Entry<String, Customer>)hmIterator.next(); 
				Customer cust = (Customer)mapElement.getValue();
				PreparedStatement ps = conn.prepareStatement("INSERT INTO Customer VALUES(?,?,?,?)");
				ps.setInt(1, cust.getSerial_ID());
				ps.setString(2, cust.getUserName());
				ps.setString(3, cust.userPin);
				ps.setString(4, cust.getName());
				ps.executeUpdate();
				conn.close();
				for (String accNum: cust.accounts) {
					PreparedStatement ps2 = conn.prepareStatement("INSERT INTO KeySets VALUES(?,?)");// Grab and pass key 
					ps2.setString(1, accNum);
					ps2.setInt(2, cust.serial_ID);
					ps2.executeUpdate();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int insertAllAccts(HashMap<String, Account>hashMapA) {
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			Iterator<Map.Entry<String, Account>>hmIterator = hashMapA.entrySet().iterator(); 
			conn.close();
			while (hmIterator.hasNext()) { 
				Map.Entry <String,Account> mapElement = (Map.Entry<String,Account>)hmIterator.next(); 
				Account acct = (Account)mapElement.getValue();
				PreparedStatement ps = conn.prepareStatement("INSERT INTO Accounts VALUES(?,?,?)");
				ps.setInt(1, acct.getSerialNum());
				ps.setFloat(2, acct.getBalance());
				ps.setLong(3, acct.getAccountNumber());
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
