package Banking;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;

public class DBAO {
	private static String url = "jdbc:oracle:thin:@muhdb.cvinpk5gjy3r.us-east-1.rds.amazonaws.com:1521:orcl";
	private static String uname = "project0";
	private static String pass = "CForLife";
	
	//take objects from maps given as arguments and save info into database
	public static boolean save(TreeMap<String, User> users, TreeMap<Integer, Account> accounts) {
		try{
			Connection con = DriverManager.getConnection(url, uname, pass);
			
			con.setAutoCommit(false);
			
			con.createStatement().execute("TRUNCATE TABLE links CASCADE");
			con.createStatement().execute("TRUNCATE TABLE accounts CASCADE");
			con.createStatement().execute("TRUNCATE TABLE users CASCADE");
			
			//insert accounts
			for(Account a = accounts.isEmpty() ? null : accounts.get(accounts.firstKey()); a != null; a = (accounts.higherKey(a.getID()) != null ? accounts.get(accounts.higherKey(a.getID())) : null)) {
				PreparedStatement ps = con.prepareStatement("INSERT INTO accounts VALUES (?,?,?)");
				
				ps.setInt(1, a.getID());
				ps.setDouble(2, a.getBalance());
				ps.setBoolean(3, new Boolean(a.isApproved()));
				
				ps.executeUpdate();
			}
			
			//insert users, and for each user add links to their accounts
			for(User u = users.isEmpty() ? null : users.get(users.firstKey()); u != null; u = (users.higherKey(u.getUsername()) != null ? users.get(users.higherKey(u.getUsername())) : null)) {
				PreparedStatement ps = con.prepareStatement("INSERT INTO users VALUES (?,?,?,?)");
				
				ps.setString(1, u.getUsername());
				ps.setString(2, u.getPass());
				ps.setByte(3, u.getType());
				ps.setString(4, u.getInfo());
				
				ps.executeUpdate();
				
				for(int id : u.getAccounts()) {
					ps = con.prepareStatement("INSERT INTO links VALUES (?,?)");
					
					ps.setString(1, u.getUsername());
					ps.setInt(2, id);
					
					ps.executeUpdate();
				}
			}	
			
			con.commit();
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	//retrieve bank info from database and place into maps given as arguments
	public static int get(TreeMap<Integer, Account> accounts, TreeMap<String, User> users) throws InstantiationException {
		int nextID = 0;
		
		try{
			Connection con = DriverManager.getConnection(url, uname, pass);
			
			//retrieve users from database and add them to users map
			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM users");
			while(rs.next()) {
				User u = new User(rs.getByte(3), rs.getString(1), rs.getString(2));
				
				u.setInfo(rs.getString(4));
				
				users.put(u.getUsername(), u);
			}
			
			//retrieve accounts from database and add them to accounts map. also keep track of largest account id number
			rs = con.createStatement().executeQuery("SELECT * FROM accounts");
			while(rs.next()) {
				Account a = new Account(rs.getInt(1));
				if(a.getID() >= nextID) nextID = a.getID() + 1;
				
				if(rs.getBoolean(3)) {
					a.approve();
					a.deposit(rs.getDouble(2));
				}
				
				accounts.put(a.getID(), a);
			}
			
			//retrieve user-account links from database and update users and accounts accordingly
			rs = con.createStatement().executeQuery("SELECT * FROM links");
			while(rs.next()) {
				String name = rs.getString(1);
				int id = rs.getInt(2);
				
				accounts.get(id).addUser(name);
				users.get(name).addAccount(id);
			}
				
		}catch(SQLException e) {
			e.printStackTrace();
			return -1;
		}
		
		return nextID;
	}
}
