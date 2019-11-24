package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project.pt1.Admin;
import com.project.pt1.Employee;

public class AdminDAOimp implements AdminDAO {

	private static String url = "jdbc:oracle:thin:@db1028.cspirgmhfavi.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "customers";
	private static String password = "p4ssw0rd";

	@Override
	public ArrayList<Admin> selectAllAdmin() {
		ArrayList<Admin> adminList = new ArrayList<Admin>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM admins");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				adminList.add(new Admin(rs.getString("user_name"), rs.getString("pass_word")));
			}
		} catch (SQLException e) {
			System.out.println("Connection Failed!");
			e.printStackTrace();
		}
		return adminList;
	}

	@Override
	public ArrayList<Employee> selectAllEmployees() {
		ArrayList<Employee> eList = new ArrayList<Employee>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM employees");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				eList.add(new Employee(rs.getString("user_name"), rs.getString("pass_word"), rs.getString("f_name"),
						rs.getDouble("salary")));
			}
		} catch (SQLException e) {
			System.out.println("Connection Failed!");
			e.printStackTrace();
		}
		return eList;
	}

	@Override
	public void deleteEmployee(Employee x) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM employees WHERE user_name=?");

			ps.setString(1, x.getUsername());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateEmployee(Employee x) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE employees SET " + "salary=? WHERE user_name=?");

			ps.setDouble(1, x.getSalary());
			ps.setString(2, x.getUsername());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
