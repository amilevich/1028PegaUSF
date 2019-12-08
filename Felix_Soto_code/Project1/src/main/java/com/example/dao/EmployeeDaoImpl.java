package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.example.ers.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	final static Logger loggy = Logger.getLogger(EmployeeDaoImpl.class);

	static {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {
			loggy.error(e);
		}

	}

	private static String url = "jdbc:oracle:thin:@db1028.c6ogbmwpzun0.us-east-1.rds.amazonaws.com:1521:orcl";
	private static String username = "Project1";
	private static String password = "passw0rd";

	@Override
	public int insertEmployee(Employee emplo) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("INSERT INTO employee VALUES(?,?,?,?,?,?,?)");
			ps.setInt(1, emplo.getUsedId());
			ps.setString(2, emplo.getUsername());
			ps.setString(3, emplo.getPassword());
			ps.setString(4, emplo.getFirstName());
			ps.setString(5, emplo.getLastName());
			ps.setString(6, emplo.getEmail());
			ps.setString(7, emplo.getType());
			System.out.println(emplo);
			ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return 0;
	}

	@Override
	public Employee selectEmployeeByUsername(String u_name) {
		Employee emp = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM employee WHERE username=?");
			ps.setString(1, u_name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7));
			}
		} catch (SQLException e) {
			loggy.error(e);
		}
		loggy.info("in dao + emp: " + emp);
		System.out.println("in dao + emp: " + emp);
		return emp;
	}

	@Override
	public List<Employee> selectAllEmployees() {
		List<Employee> emps = new ArrayList<Employee>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM employee");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				emps.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7)));
			}
		} catch (SQLException e) {
			loggy.error(e);
		}
		return emps;
	}

	@Override
	public void updateEmployee(Employee emp) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE employee SET username=?, password=?, first_name=?, last_name?, user_email, type=? WHERE user_id=?");
			ps.setString(2, emp.getUsername());
			ps.setString(3, emp.getPassword());
			ps.setString(4, emp.getFirstName());
			ps.setString(5, emp.getLastName());
			ps.setString(6, emp.getEmail());
			ps.setString(7, emp.getType());
			ps.setInt(1, emp.getUsedId());
			ps.executeUpdate();
		} catch (SQLException e) {
			loggy.error(e);
		}
	}

	@Override
	public void deleteEmployee(Employee emp) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM employee WHERE user_id=?");
			ps.setInt(1, emp.getUsedId());
			ps.executeUpdate();

		} catch (SQLException e) {
			loggy.error(e);
		}
	}
}