package com.example.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.example.ers.Expense;
import com.example.ers.ReimbursementStatus;

public class ExpenseDaoImpl implements ExpenseDao {
	final static Logger loggy = Logger.getLogger(ExpenseDaoImpl.class);

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
	public int insertExpense(Expense exp) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO ers_reimbursement"
					+ "(ticket_id, employee_id,firstname,lastname,type,amount,date_submitted,date_resolved,status,description) "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, exp.getTicketId());
			ps.setInt(2, exp.getEmployeeId());
			ps.setString(3, exp.getFirstname());
			ps.setString(4, exp.getLastname());
			ps.setInt(5, exp.getType().getValue());
			ps.setDouble(6, exp.getAmount());
			ps.setDate(7, exp.getSubmitted());
			ps.setDate(8, exp.getResolved());
			ps.setInt(9, exp.getStatus().getValue());
			ps.setString(10, exp.getDescription());
			ps.executeUpdate();
		} catch (SQLException e) {
			loggy.error(e);
		}
		loggy.info("in dao + expense: " + exp);

		return 0;
	}

	@Override
	public List<Expense> selectExpensesByEmployeeId(int emp_id) {
		List<Expense> exps = new ArrayList<Expense>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ers_reimbursement");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt(2) == emp_id) {
					exps.add(new Expense(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5),
							rs.getDouble(6), rs.getDate(7), rs.getDate(8), rs.getInt(9), rs.getString(10)));
				}
			}
		} catch (SQLException e) {
			loggy.error(e);
		}
		return exps;
	}

	@Override
	public List<Expense> selectAllExpenses() {
		List<Expense> exps = new ArrayList<Expense>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ers_reimbursement");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				exps.add(new Expense(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getDouble(6), rs.getDate(7), rs.getDate(8), rs.getInt(9), rs.getString(10)));
			}
		} catch (SQLException e) {
			loggy.error(e);
		}
		return exps;
	}

	@Override
	public void updateExpense(Expense exp) {
			}

	@Override
	public void approveExpense(int ticket_id) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn
					.prepareStatement("UPDATE ers_reimbursement SET " + "date_resolved=?, status=? WHERE ticket_id=?");
			ps.setDate(1, new Date(System.currentTimeMillis()));
			ps.setInt(2, ReimbursementStatus.APPROVED.getValue());
			ps.setInt(3, ticket_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			loggy.error(e);
		}
		loggy.info("This has been updated: " + ticket_id);

	}

	@Override
	public void denyExpense(int ticket_id) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn
					.prepareStatement("UPDATE ers_reimbursement SET " + "date_resolved=?, status=? WHERE ticket_id=?");
			ps.setDate(1, new Date(System.currentTimeMillis()));
			ps.setInt(2, ReimbursementStatus.DENIED.getValue());
			ps.setInt(3, ticket_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			loggy.error(e);
		}
	}

	@Override
	public void deleteExpense(Expense exp) {
	}	
}