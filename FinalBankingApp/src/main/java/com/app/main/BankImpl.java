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

	public HashMap<String, Customer> getCHashMap(){ //Get customer 
		HashMap<String, Customer>hashMapC = selectAllCusts(); 
		ArrayList<SqlKeys> keys_list = fetchSqlKeys();
		for(SqlKeys tkey: keys_list) {
			hashMapC.get(tkey.id).accounts.add(tkey.accNum); 
		}
		return hashMapC;
	}

	public HashMap<String, Account> getAHashMap(){
		HashMap<String, Account>hashMapA = selectAllAccts(); 
		ArrayList<SqlKeys> keys_list = fetchSqlKeys();
		for(SqlKeys tkey: keys_list) {
			hashMapA.get(tkey.accNum).customers.add(tkey.id);
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
				SqlKeys tkey = new SqlKeys(rs.getString("id"), rs.getString("accNum"));
				keys_list.add(tkey);
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
			while(rs.next()) {
				Customer cust = new Customer(rs.getString("userName"), rs.getString("userPin"), rs.getString("Name"));
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
			while(rs.next()) {
				Account acct = new Account(rs.getString("AccountNumber"), rs.getFloat("balance"));
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
				PreparedStatement ps = conn.prepareStatement("INSERT INTO Customer VALUES(?,?,?)");
				ps.setString(1, cust.userName);
				ps.setString(2, cust.userPin);
				ps.setString(3, cust.Name);
				ps.executeUpdate();
				for (String accNum: cust.accounts) {
					PreparedStatement ps2 = conn.prepareStatement("INSERT INTO KeySets VALUES(?,?)");// Grab and pass key 
					ps2.setString(1, cust.userName);
					ps2.setString(2, accNum);
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
			while (hmIterator.hasNext()) { 
				Map.Entry <String,Account> mapElement = (Map.Entry<String,Account>)hmIterator.next(); 
				Account acct = (Account)mapElement.getValue();
				PreparedStatement ps = conn.prepareStatement("INSERT INTO Accounts VALUES(?,?)");
				ps.setString(1, acct.accNum);
				ps.setFloat(2, acct.getBalance());
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
