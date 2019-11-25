package yeah.me;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;
public class ClientDaoImpl {
	
		
		private static String url
		= "jdbc:oracle:thin:@deadbool.c8qedumffy9a.us-east-2.rds.amazonaws.com:1521:orcl";
		private static String username = "Bank";
		private static String password = "p4ssw0rd";
		
		public int insertCli(customer p) {
			try (Connection conn = DriverManager.getConnection(url, username, password)){
				PreparedStatement ps = conn.prepareStatement("INSERT INTO Clients VALUES(?,?,?)");
				ps.setString(1, p.getCusna());
				ps.setString(2, p.getUsername());
				ps.setString(3, p.getPassword());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}
		
		
		
		public int insertClients(customer p) {
			try (Connection conn = DriverManager.getConnection(url, username, password)){
				PreparedStatement ps = conn.prepareStatement("INSERT INTO Clients VALUES(?,?,?,?,)");
				ps.setString(1, p.getUsern1());
				ps.setString(2, p.getPass1());
				ps.setString(3, p.getUsern2());
				ps.setString(4, p.getPass2());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}
		public static void main(String[] args) {
//			account testaccnt = new account(0.0,"a","b","c","d");	
//			BankDaoImpl asdf = new BankDaoImpl();
//			
//			asdf.insertacc(testaccnt);
			Bank.test();
			
			}

		public customer selectCliByName(customer p) {
			customer noob = null;
			try(Connection conn = DriverManager.getConnection(url, username, password)){
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM Clients WHERE usern=?");
				//putting in a native SQL query utilizing a prepared statement
				ps.setString(1, p.getUsername());
				//we are setting the question mark to be the name that is passed as 
				//a parameter to this method
				//number 1 corresponds to the first question mark in the query
				ResultSet rs = ps.executeQuery();
				//we are executing the query and storing the result set in 
				//a ResultSet type (object)
				while(rs.next()) {
					noob = new customer(rs.getString("cusna"), rs.getString("Username"), rs.getString("Password"));
					
				}
				//we are iterating through our result set and populating
				//our pet object with the values that are coming from the
				//table's columns
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return noob;
		}

		public ArrayList<customer> selectAllCustomer() {
			ArrayList<customer> noob = new ArrayList<customer>();
			try(Connection conn = DriverManager.getConnection(url, username, password)){
				
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Clients");
			//SQL query goes into our prepared statement
			//we have no question marks, so no setting the values
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				noob.add( new customer(rs.getString(1), rs.getString(2), rs.getString(3)));
			}
			//iterating through the result set, while we still have the next value
			//we populate the new Pet object and add it to the ArrayList
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return noob;
		}

		public int updateCli(customer p) {
			try(Connection conn = DriverManager.getConnection(url, username, password)){
				
				PreparedStatement ps = conn.prepareStatement("UPDATE Clients SET type=? WHERE usern=?");
				ps.setString(1, p.getUsername());
				ps.setString(2, p.getPassword());
				ps.executeUpdate();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}

		public int deleteCli(customer p) {
			try(Connection conn = DriverManager.getConnection(url, username, password)){
				PreparedStatement ps = conn.prepareStatement("DELETE FROM Clients WHERE cusname=?");
				ps.setString(1, p.getUsername());
				ps.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}

		
	}



