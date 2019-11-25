import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import com.backend.Account;
import com.backend.AccountManagement;
import com.dao.AccountDaompl;

public class BankTester {
	
	private static String url = "jdbc:oracle:thin:@dbtest1028.c24r46j1ibxl.us-east-1.rds.amazonaws.com:1521:orcl";
	private static String username = "BankUser";
	private static String password = "p4ssw0rd";

	
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
			e.printStackTrace();
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
				System.out.println(a.toString());}
				else {
					a = new Account(rs.getString(2),rs.getString(1).replaceAll(rs.getString(2), ""),rs.getString(1),rs.getString(5) ,rs.getString(6).replaceAll(rs.getString(5),"")  ,rs.getString(6), rs.getDouble(3));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			e.printStackTrace();
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
			e.printStackTrace();
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
			e.printStackTrace();
		}
		return 0;
	}

	@Test
	public void testdeleteAccount() {
		Account test = new Account("apple", "b", "appleb", 50.0);
		AccountDaompl newt = new AccountDaompl();
		newt.Insert(test);
		int n = selectAllAccounts().size();
		deleteAccount(test);
		int n2 = selectAllAccounts().size();
		assertEquals("delete", n ,n);
		newt.Insert(test);
	}
	
	
	@Test
	public void testselectAccountByName() {
		
		Account test = new Account("test2", "test2", "test2test2", 200.0);

		AccountDaompl newt = new AccountDaompl();
		newt.Insert(test);
		assertEquals("Hello", test.toString() ,newt.selectAccountByName(test.getiD()).toString());
	}
	
	 @Test
	 public void testUpdateAccount() {
		 Account test = new Account("a", "b", "ab", 50.0);
		 Account apple = new Account("a","b", "ab", 200.0);
		 AccountDaompl newt = new AccountDaompl();
		 newt.updateAccount(test, 200);
		 System.out.println(apple.toString());
		 System.out.println(newt.selectAccountByName(test.getiD().toString()));
		 assertEquals("Update Dao Test", apple.toString(), newt.selectAccountByName(test.getiD()).toString());
		 
	 }
	
	
}
