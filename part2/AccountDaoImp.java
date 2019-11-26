package part2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccountDaoImp implements AccountDao{
	
	private static String url = "jdbc:oracle:thin:@revtraindb.ckjisqlnth7g.us-east-1.rds.amazonaws.com:1521:orcl";
	private static String username = "Banker";
	private static String password = "p4ssw0rd";

	@Override
	public void insertAcct(Client c) {
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Bank_Accounts VALUES(?,?,?)");
			ps.setString(1, null);		//uses acct_seq in sql to set account number on trigger
			ps.setDouble(2, 0.0); 
			ps.setString(3, "Pending");
			ps.executeUpdate();
			PreparedStatement ps2 = conn.prepareStatement("INSERT INTO Client_Accounts VALUES(?,?)");
			ps2.setString(1, c.getUsername());
			ps2.setString(2, null);		//uses client_acct_seq to set identical account number
			ps2.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public ArrayList<Account> selectClientAccts(String un) {
		ArrayList<Account> accts = new ArrayList<Account>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT Bank_Accounts.acct_num, balance, status FROM Bank_Accounts INNER JOIN Client_Accounts \r\n" + 
					"ON Client_Accounts.acct_num = Bank_Accounts.acct_num WHERE user_name=?");
			ps.setString(1, un);
			ResultSet rs = ps.executeQuery();	//executing the query and storing the ResultSet in the ResultSet object
			while(rs.next()) {
				accts.add(new Account(rs.getInt(1), rs.getDouble(2), Status.valueOf(rs.getString(3))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accts;
	}

	@Override
	public ArrayList<Account> selectAllAccts() {
		ArrayList<Account> accts = new ArrayList<Account>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Bank_Accounts");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				accts.add(new Account(rs.getInt(1), rs.getDouble(2), Status.valueOf(rs.getString(3))));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accts;
	}

	@Override
	public void updateAcct(Account a) {
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("UPDATE Bank_Accounts SET balance=?, status=? WHERE acct_num=?"); 
			ps.setDouble(1, a.getBalance());
			ps.setString(2, a.getStatus().toString());
			ps.setInt(3, a.getAcctNum());
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void deleteAcct(Account a) {
		
	}

	public ArrayList<Account> selectAllAcctsPending() {
		ArrayList<Account> accts = new ArrayList<Account>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Bank_Accounts WHERE status=?");
			ps.setString(1, "Pending");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				accts.add(new Account(rs.getInt(1), rs.getDouble(2), Status.valueOf(rs.getString(3))));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accts;
	}

	@Override
	public Account selectAcctByNum(int num) {
		return null;
	}

	
}
