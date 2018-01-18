package org.bishwa.spring.springData.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.bishwa.spring.springData.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JdbcDaoImplSpringv2 {
	Connection conn = null;
	Circle circle = null;

	@Autowired
	private DataSource dataSource;
	public Circle getCircle(int circleId) {
		try {
			conn = dataSource.getConnection();
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
