package Reimbursement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Timestamp;
import java.util.TreeMap;

public class DAO {

    static{
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	private static String url = "jdbc:oracle:thin:@muhdb.cvinpk5gjy3r.us-east-1.rds.amazonaws.com:1521:orcl";
	private static String uname = "project1";
	private static String pass = "SecurePassword1";
	private boolean commit;
	private Connection con;

	//c = commit changes to database? false is for testing
	public DAO(boolean c) throws SQLException {
		try {
			System.out.printf("Connecting...\n");
			con = DriverManager.getConnection(url, uname, pass);
			con.close();
			con = DriverManager.getConnection(url, uname, pass);

			System.out.printf("Connected!\n");
			commit = c;

			if (commit)
				con.setAutoCommit(true);
			else
				con.setAutoCommit(false);

			con.prepareStatement("SAVEPOINT A").execute();
		} catch (SQLException e) {
			System.out.printf("%s\n", e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public User getUser(String email) {
		try {
			ResultSet response;
			String pass, first, last;
			Boolean advisor;
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Users WHERE email = ?");
			
			ps.setString(1, email);
			response = ps.executeQuery();
			
			response.next();
			pass = response.getString(2);
			first = response.getString(3);
			last = response.getString(4);
			advisor = response.getBoolean(5);

			return new User(email, pass, first, last, advisor);
			
		} catch (SQLException e) {
			System.out.printf("%s\n", e.getMessage());
			return null;
		}
		catch (InstantiationException e) {
			System.out.printf("%s\n", e.getMessage());
			return null;
		}

	}
	
	//if user is advisor, get all tickets, otherwise, get tickets for users
	public TreeMap<Integer, Ticket> getTickets(User u) {
		try {
			ResultSet response;
			PreparedStatement ps;
			TreeMap<Integer, Ticket> tickets = new TreeMap<Integer, Ticket>();
			
			if(u.isAdvisor()) ps = con.prepareStatement("SELECT * FROM Tickets");
			else {
				ps = con.prepareStatement("SELECT * FROM TICKETS WHERE email = ?");
				ps.setString(1, u.getEmail());
			}
			
			response = ps.executeQuery();
			
			while(response.next()) {
				String email, desc;
				Double amount;
				Byte type;
				Integer status;
				Timestamp time;
				Ticket t;
				
				email = response.getString(2);
				amount = response.getDouble(3);
				type = response.getByte(4);
				desc = response.getString(5);
				status = response.getInt(6);
				time = response.getTimestamp(7);
				
				t = new Ticket(email, amount, desc, type, time);
				
				if(status == -1) t.deny();
				if(status == 1) t.approve();
				
				tickets.put(response.getInt(1), t);	
			}
			
			return tickets;
			
		} catch (SQLException e) {
			System.out.printf("%s\n", e.getMessage());
			return null;
		}
		catch (InstantiationException e) {
			System.out.printf("%s\n", e.getMessage());	
			return null;
		}
	}
	
	
	public boolean storeUser(User u) {
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO Users VALUES(?,?,?,?,?)");
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPass());
			ps.setString(3, u.getName()[0]);
			ps.setString(4, u.getName()[1]);
			ps.setBoolean(5, new Boolean(u.isAdvisor()));
			
			ps.setQueryTimeout(5);
			ps.executeUpdate();
			
		}catch(SQLTimeoutException e) {
			System.out.printf("%s\n", e.getMessage());	
			return false;
		}
		catch (SQLException e) {
			System.out.printf("%s\n", e.getMessage());	
			return false;
		}

		return true;
	}
	
	public boolean storeTicket(Ticket t) {
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO Tickets VALUES (?,?,?,?,?,?,?)");
			ps.setInt(1,  -1);
			ps.setString(2, t.getEmail());
			ps.setDouble(3, t.getAmount());
			ps.setByte(4, t.getType());
			ps.setString(5,  t.getDesc());
			ps.setInt(6, t.getStatus());
			ps.setTimestamp(7, t.getTime());
			
			ps.executeUpdate();
		
		} catch (SQLException e) {
			System.out.printf("%s\n", e.getMessage());	
			return false;
		}

		return true;
	}
	
	//approve - true: approve, false: deny
	public boolean modTicket(Integer id, boolean approve) {
		try {
			ResultSet response;
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Tickets WHERE id = ?");
			ps.setInt(1, id);
			
			response = ps.executeQuery();
			response.next();
			if(response.getInt("status") != 0) return false;
			
			ps = con.prepareStatement("UPDATE Tickets SET status = ? WHERE id = ?");
			
			if(approve) ps.setInt(1, 1);
			else ps.setInt(1, -1);
			
			ps.setInt(2, id);
			ps.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.printf("%s\n", e.getMessage());
			return false;
		}
		
		return true;
	}
	
	@Override
	public void finalize() throws SQLException{
		if(!commit) con.prepareStatement("ROLLBACK A").execute();
		con.close();
	}
}
