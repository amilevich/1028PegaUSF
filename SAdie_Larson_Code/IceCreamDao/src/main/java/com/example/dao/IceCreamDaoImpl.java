package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.IceCream;

public class IceCreamDaoImpl implements IceCreamDao {
	private static String url = "jdbc:oracle:thin:@db1028.cdvifhysxq7a.us-east-1.rds.amazonaws.com:1521:orcl";
	private static String username = "IceCream";
	private static String password = "passw0rd";

	@Override
	public int insertIceCream(IceCream ice) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO IceCream VALUES(?,?)");
			ps.setString(1, ice.getFlavor());
			ps.setInt(2, ice.getSprinkles());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public IceCream selectByFlavor(String flavor) {
		IceCream ice = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM IceCream WHERE flavor=?");
			ps.setString(1, flavor);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ice = new IceCream(rs.getString("flavor"), rs.getInt("sprinkles"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ice;
	}

	@Override
	public List<IceCream> selectAllIceCream() {
		List<IceCream> ices = new ArrayList<IceCream>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM IceCream");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ices.add(new IceCream(rs.getString(1), rs.getInt(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ices;
	}

	@Override
	public int updateIceCream(IceCream ice) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE IceCream SET sprinkles=? WHERE flavor=?");
			ps.setInt(1, ice.getSprinkles());
			ps.setString(2, ice.getFlavor());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteIceCream(IceCream ice) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM IceCream WHERE flavor=?");
			ps.setString(1, ice.getFlavor());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
