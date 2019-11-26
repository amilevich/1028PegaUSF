package part2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImp implements EmployeeDao{
	
	private static String url = "jdbc:oracle:thin:@revtraindb.ckjisqlnth7g.us-east-1.rds.amazonaws.com:1521:orcl";
	private static String username = "Banker";
	private static String password = "p4ssw0rd";

	@Override
	public void insertEmp(Employee e) {
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Bank_Employees VALUES(?,?,?,?,?,?,?)");
			ps.setString(1, e.getEmpUserName());
			ps.setString(2, e.getEmpPassword()); 
			ps.setString(3, e.getFirstName());
			ps.setString(4, e.getLastName());
			ps.setDate(5, e.getDateOfBirth());
			ps.setString(6, e.getAddress());
			ps.setInt(7, e.getAdmin());
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}	
	}

	@Override
	public Employee selectEmpByName(String userName) {
		Employee emp = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Bank_Employees WHERE user_name=?");
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();	//executing the query and storing the ResultSet in the ResultSet object
			while(rs.next()) {
				emp = new Employee(rs.getString("user_name"), rs.getString("password"), rs.getString("first_name"), rs.getString("last_name"), rs.getDate("date_of_birth"), rs.getString("address"), rs.getInt("admin_priv"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public ArrayList<Employee> selectAllEmps() {
		return null;
	}

	@Override
	public void updateEmp(Employee e) {
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("UPDATE Bank_Employees SET user_name=?, first_name=?, last_name=?, date_of_birth=?, address=? WHERE name=?"); 
			ps.setString(1, e.getEmpPassword());
			ps.setString(2, e.getFirstName());
			ps.setString(3, e.getLastName());
			ps.setDate(4, e.getDateOfBirth());
			ps.setString(5, e.getAddress());
//			if(admin) {
//				ps.setInt(1, 1);
//			}else ps.setInt(1, 0);
			ps.setString(6, e.getEmpUserName()); 
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void deleteEmp(Employee e) {
		
	}
}
