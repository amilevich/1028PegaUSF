package Project0BankAccountM.Project0BankAccountM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AccountDaoImpt implements AccountDao 
{
	private static String url
	= "jdbc:oracle:thin:@pegakyle1028.csdx8zajy2fa.us-east-1.rds.amazonaws.com:1521:orcl";
	private static String username = "Kyle1028";
	private static String password = "p4ssw0rd";

	// add an account to the database
	@Override
	public int insertAccount(Account _account) 
	{
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Accounts VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, _account.getAccountNumber());
			ps.setString(2, _account.getFirstName1());
			ps.setString(3, _account.getLastName1());
			ps.setInt(4, _account.getSSN1());
			ps.setString(5, _account.getFirstName2());
			ps.setString(6, _account.getLastName2());
			ps.setInt(7, _account.getSSN2());
			ps.setDouble(8, _account.getSaveBalance());
			ps.setDouble(9, _account.getCheckBalance());
			ps.setDouble(10, _account.getLoanBalance());
			ps.setShort(11, _account.getFlags());
			ps.executeUpdate();
		}
		catch(SQLIntegrityConstraintViolationException e)
		{
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	
	//get an account record based on the account number
	@Override
	public Account selectAccountByNumber(int _number) 
	{
		Account account = null;
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Accounts WHERE account_id=?");
			//putting in a native SQL query utilizing a prepared statement
			ps.setInt(1, _number);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				//collect data
				account = new Account(rs.getInt("account_id"), rs.getShort("account_flags"), rs.getString("account_firstname1"), 
									  rs.getString("account_lastname1"), rs.getString("account_firstname2"), rs.getString("account_lastname2"),  
									  rs.getInt("account_ssn1"), rs.getInt("account_ssn2"), rs.getDouble("account_save"), 
									  rs.getDouble("account_check"), rs.getDouble("account_loan"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return account;
	}

	// Get all the accounts owned by the inputted name
	@Override
	public List<Account> selectAccountByRealname(String _fname, String _lname) 
	{
		List<Account> accounts = new ArrayList<Account>();
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Accounts WHERE account_firstname1=?, account_lastname1");
			//putting in a native SQL query utilizing a prepared statement
			ps.setString(1, _fname);
			ps.setString(1, _lname);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				//collect data
				accounts.add(new Account(rs.getInt("account_id"), rs.getShort("account_flags"), rs.getString("account_firstname1"), 
									  rs.getString("account_lastname1"), rs.getString("account_firstname2"), rs.getString("account_lastname2"),  
									  rs.getInt("account_ssn1"), rs.getInt("account_ssn2"), rs.getDouble("account_save"), 
									  rs.getDouble("account_check"), rs.getDouble("account_loan")));
			}
			
			// search the joint account holders
			PreparedStatement ps2 = conn.prepareStatement("SELECT * FROM Accounts WHERE account_firstname2=?, account_lastname2");
			//putting in a native SQL query utilizing a prepared statement
			ps2.setString(1, _fname);
			ps2.setString(1, _lname);
			ResultSet rs2 = ps2.executeQuery();
			while(rs2.next()) 
			{
				//collect data
				accounts.add(new Account(rs.getInt("account_id"), rs.getShort("account_flags"), rs.getString("account_firstname1"), 
									  rs.getString("account_lastname1"), rs.getString("account_firstname2"), rs.getString("account_lastname2"),  
									  rs.getInt("account_ssn1"), rs.getInt("account_ssn2"), rs.getDouble("account_save"), 
									  rs.getDouble("account_check"), rs.getDouble("account_loan")));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public List<Account> selectAccountBySSN(int _ssn) 
	{
		List<Account> accounts = new ArrayList<Account>();
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Accounts WHERE account_ssn1=?");
			//putting in a native SQL query utilizing a prepared statement
			ps.setInt(1, _ssn);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				//collect data
				accounts.add(new Account(rs.getInt("account_id"), rs.getShort("account_flags"), rs.getString("account_firstname1"), 
									  rs.getString("account_lastname1"), rs.getString("account_firstname2"), rs.getString("account_lastname2"),  
									  rs.getInt("account_ssn1"), rs.getInt("account_ssn2"), rs.getDouble("account_save"), 
									  rs.getDouble("account_check"), rs.getDouble("account_loan")));
			}
			
			// search the joint account holders
			PreparedStatement ps2 = conn.prepareStatement("SELECT * FROM Accounts WHERE account_ssn2");
			//putting in a native SQL query utilizing a prepared statement
			ps2.setInt(1, _ssn);
			ResultSet rs2 = ps2.executeQuery();
			while(rs2.next()) 
			{
				//collect data
				accounts.add(new Account(rs.getInt("account_id"), rs.getShort("account_flags"), rs.getString("account_firstname1"), 
									  rs.getString("account_lastname1"), rs.getString("account_firstname2"), rs.getString("account_lastname2"),  
									  rs.getInt("account_ssn1"), rs.getInt("account_ssn2"), rs.getDouble("account_save"), 
									  rs.getDouble("account_check"), rs.getDouble("account_loan")));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return accounts;
	}

	// Get all the accounts
	@Override
	public List<Account> selectAllAccount() 
	{
		List<Account> accounts = new ArrayList<Account>();
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Accounts");
			//putting in a native SQL query utilizing a prepared statement
			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				//collect data
				accounts.add(new Account(rs.getInt("account_id"), rs.getShort("account_flags"), rs.getString("account_firstname1"), 
									  rs.getString("account_lastname1"), rs.getString("account_firstname2"), rs.getString("account_lastname2"),  
									  rs.getInt("account_ssn1"), rs.getInt("account_ssn2"), rs.getDouble("account_save"), 
									  rs.getDouble("account_check"), rs.getDouble("account_loan")));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public int updateAccount(Account _account) 
	{
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("UPDATE Accounts SET account_id=?, account_firstname1=?, account_lastname1=?, "+
														 "account_ssn1=?, account_firstname2=?, account_lastname2=?, account_ssn2, " +
														 "account_save=?, account_check=?, account_loan=?, account_flags=? WHERE account_id=?");
			ps.setInt(1, _account.getAccountNumber());
			ps.setString(2, _account.getFirstName1());
			ps.setString(3, _account.getLastName1());
			ps.setInt(4, _account.getSSN1());
			ps.setString(5, _account.getFirstName2());
			ps.setString(6, _account.getLastName2());
			ps.setInt(7, _account.getSSN2());
			ps.setDouble(8, _account.getSaveBalance());
			ps.setDouble(9, _account.getCheckBalance());
			ps.setDouble(10, _account.getLoanBalance());
			ps.setShort(11, _account.getFlags());
			ps.setInt(12, _account.getAccountNumber());
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteAccount(Account _account) 
	{
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Accounts WHERE account_id=?");
			ps.setInt(1, _account.getAccountNumber());
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	// Check if the inputed account name is unique.
	public boolean isAccountNumberUnique(int _input)
	{
//		String callerClassName = new Exception().getStackTrace()[1].getClassName();
//		System.out.println(callerClassName);
		return null == selectAccountByNumber(_input);
	}

	public int getUniqueNumber()
	{
		Random random = new Random();
		int num = -1;
		do
		{
			num = random.nextInt(Integer.MAX_VALUE);
		} while (!isAccountNumberUnique(num));
		return num;
	}
}
