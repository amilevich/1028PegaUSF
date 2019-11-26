package part2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientDaoImp implements ClientDao{
	
	private static String url = "jdbc:oracle:thin:@revtraindb.ckjisqlnth7g.us-east-1.rds.amazonaws.com:1521:orcl";
	private static String username = "Banker";
	private static String password = "p4ssw0rd";

	@Override
	public void insertClnt(Client c) {
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Bank_Clients VALUES(?,?,?,?,?,?)");
			ps.setString(1, c.getUsername());
			ps.setString(2, c.getPassword()); 
			ps.setString(3, c.getFirstName());
			ps.setString(4, c.getLastName());
			ps.setDate(5, c.getDateOfBirth());
			ps.setString(6, c.getAddress());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Client selectClntByUserName(String userName) {
		Client c = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Bank_Clients WHERE user_name=?");
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();	//executing the query and storing the ResultSet in the ResultSet object
			while(rs.next()) {
				c = new Client(rs.getString("user_name"), rs.getString("password"), rs.getString("first_name"), rs.getString("last_name"), rs.getDate("date_of_birth"), rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public ArrayList<Client> selectAllClnts() {
		ArrayList<Client> clients = new ArrayList<Client>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Bank_Clients");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				clients.add(new Client(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}

	@Override
	public void updateClnt(Client c) {
		
	}

	@Override
	public void deleteClnt(Client c) {
		
	}

}
