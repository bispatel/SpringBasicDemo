package org.bishwa.spring.springData.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bishwa.spring.springData.model.Circle;

public class JDBCDaoImpl {
	Connection conn = null;
	Circle circle = null;

	public Circle getCircle(int circleId) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager
					.getConnection("jdbc:oracle:thin:@//localhost:1521/xe",
							"bishwa", "bishwa");
			PreparedStatement ps = conn
					.prepareStatement("Select * from Circle where id=?");
			ps.setInt(1,circleId);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				circle = new Circle(circleId, rs.getString("name"));
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return circle;
	}
}
