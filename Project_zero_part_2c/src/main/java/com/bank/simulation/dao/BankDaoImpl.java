package com.bank.simulation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bank.simulation.Account;


/*
 * JDBC
 * Java Database Connectivity
 * 
 * Important Interfaces:
 * - Connection -> allows us to connect to our DB
 * - Statement -> raw SQL query
 * - PreparedStatement -> precompiles the SQL string without parameters, once
 * parameters are added, they are only treated as values, never keywords
 * - CallableStatement -> same idea as PreparedStatement but is used
 * for stored procedures
 * 
 * Both PreparedStatement and CallableStatement prevent SQL injections
 * 
 * To connect to our database, we need 4 things:
 * 1) URL (endpoint + port number + database name)
 * 2) Username
 * 3) Password
 * 4) Driver (jar that implements JDBC)
 */
public class BankDaoImpl implements BankDao {
	static{
	       try {
	           Class.forName("oracle.jdbc.driver.OracleDriver");
	       } catch (ClassNotFoundException e) {
	           e.printStackTrace();
	       }
	   }
    
    private static String url
    = "jdbc:oracle:thin:@db1028.c7ineqxddtn0.us-east-1.rds.amazonaws.com:1521:orcl";
    private static String username = "Admin2";
    private static String password = "p4ssw0rd";
    
    
//    @Override
//    public int insertAcc(Account account) {
//        try (Connection conn = DriverManager.getConnection(url, username, password)){
//        	int auth=account.getAuthority();
//        	String name=account.getName();
//        	String pwd=account.getPassword();
//        	String sql="insert into admintable values("+auth+",'"+name+"','"+pwd+"')";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            
//            System.out.println("Here");
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }
    @Override//This is using
    public int insertAcc(int auth, String name, String pwd) {
        try (Connection conn = DriverManager.getConnection(url, username, password)){
        	String sql="select max(p_id) from admintable";
        	PreparedStatement ps=conn.prepareStatement(sql);
        	ResultSet rs=ps.executeQuery();
        	rs.next();
        	int id=rs.getInt(1)+1;
        	sql="insert into admintable values("+Integer.toString(id)+","+auth+",'"+name+"','"+pwd+"',0,'')";
            ps = conn.prepareStatement(sql);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    @Override
    public int updatePet(String name,double balance) {
        try (Connection conn = DriverManager.getConnection(url, username, password)){
        	
        	String sql="update admintable set p_balance="+Double.toString(balance)+"where p_name='"+name+"'";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
	@Override
	public int Allow(String name) {
		// TODO Auto-generated method stub
        try (Connection conn = DriverManager.getConnection(url, username, password)){
        	
        	String sql="update admintable set p_state='Allow' where p_name='"+name+"'";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return 0;
	}
	@Override
	public int Deny(String name) {
		// TODO Auto-generated method stub
        try (Connection conn = DriverManager.getConnection(url, username, password)){
        	
        	String sql="update admintable set p_state='Deny' where p_name='"+name+"'";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return 0;
	}
	@Override
	public int Cancel(String name) {
		// TODO Auto-generated method stub
        try (Connection conn = DriverManager.getConnection(url, username, password)){
        	
        	String sql="delete from admintable where p_name='"+name+"'";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return 0;
		
	}
    
//    public static void main(String[] args) {
//		Account testacc = new Account(2,"dfgdg" ,"asas");
//		BankDaoImpl imp = new BankDaoImpl();
//		
//		imp.insertAcc(3,"tom","tom");
//	}
//    @Override
//    public Account selectPetByName(String name) {
//        Account account = null;
//        try(Connection conn = DriverManager.getConnection(url, username, password)){
//            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Admin1 WHERE name=?");
//            //putting in a native SQL query utilizing a prepared statement
//            ps.setString(1, name);
//            //we are setting the question mark to be the name that is passed as 
//            //a parameter to this method
//            //number 1 corresponds to the first question mark in the query
//            ResultSet rs = ps.executeQuery();
//            //we are executing the query and storing the result set in 
//            //a ResultSet type (object)
//            while(rs.next()) {
//                account = new Account(rs.getString("name"), rs.getString("type"));
//            }
//            //we are iterating through our result set and populating
//            //our pet object with the values that are coming from the
//            //table's columns
//            
//        }catch(SQLException e) {
//            e.printStackTrace();
//        }
//        return account;
//    }
//    @Override
//    public List<Account> selectAllPets() {
//        List<Account> pets = new ArrayList<Account>();
//        try(Connection conn = DriverManager.getConnection(url, username, password)){
//            
//        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Admin1");
//        //SQL query goes into our prepared statement
//        //we have no question marks, so no setting the values
//        ResultSet rs = ps.executeQuery();
//        System.out.println("in select all");
//        while(rs.next()) {
//            pets.add(new Account(rs.getString(1), rs.getString(2)));
//        }
//        System.out.println(pets);
//        //iterating through the result set, while we still have the next value
//        //we populate the new Pet object and add it to the ArrayList
//            
//        }catch(SQLException e) {
//            e.printStackTrace();
//        }
//        return pets;
//    }
//    @Override
//    public int updatePet(Account p) {
//        try(Connection conn = DriverManager.getConnection(url, username, password)){
//            
//            PreparedStatement ps = conn.prepareStatement("UPDATE Admin1 SET type=? WHERE name=?");
//            ps.setString(1, p.getType());
//            ps.setString(2, p.getName());
//            ps.executeUpdate();
//            
//        }catch(SQLException e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }
//    @Override
//    public int deletePet(Account p) {
//        try(Connection conn = DriverManager.getConnection(url, username, password)){
//            PreparedStatement ps = conn.prepareStatement("DELETE FROM Pets WHERE name=?");
//            ps.setString(1, p.getName());
//            ps.executeUpdate();
//        }catch(SQLException e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }

	@Override
	public Account selectPetByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> selectAllPets() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public int deletePet(Account p) {
		// TODO Auto-generated method stub
		return 0;
	}




}
	
