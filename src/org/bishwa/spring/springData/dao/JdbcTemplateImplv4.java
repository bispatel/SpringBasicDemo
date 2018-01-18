package org.bishwa.spring.springData.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.bishwa.spring.springData.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class JdbcTemplateImplv4 {
	Connection conn = null;
	Circle circle = null;

	private DataSource dbcpDataSource;
	private JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public DataSource getDbcpDataSource() {
		return dbcpDataSource;
	}

	@Autowired
	public void setDbcpDataSource(DataSource dbcpDataSource) {
		this.template = new JdbcTemplate(dbcpDataSource);
	}

	public int getCircleCount() {
		String sql = "select count(*) from circle";
		return template.queryForInt(sql);
	}

	public String getCircleName(int circleId) {
		String sql = "select name from circle  where id = ?";
		String result = template.queryForObject(sql, new Object[] { circleId }, String.class);
		return result;
	}

	public Circle getCircleForId(int circleId) {
		String sql = "Select id,name from circle where id = ?";
		return template.queryForObject(sql, new Object[] { circleId }, new CircleMapper());
	}
	
	public List<Circle> getAllCircle() {
		String sql = "Select id,name from circle";
		return template.query(sql, new CircleMapper());
	}
	
	public void insertCircle(Circle circle) {
		String sql = "INSERT INTO CIRCLE(ID,NAME) VALUES(?,?)";
		template.update(sql, new Object[] {circle.getId(),circle.getName()});
	}

	public void createtriangleTable() {
	   String sql =  "CREATE TABLE TRIANGLE (ID INTEGER,NAME VARCHAR2(50))";	
	   template.execute(sql);
	}
	
	
	private static final class CircleMapper implements RowMapper<Circle> {
		@Override
		public Circle mapRow(ResultSet rs, int rowNum) throws SQLException {
			Circle circle = new Circle();
			circle.setId(rs.getInt("id"));
			circle.setName(rs.getString("name"));
			return circle;
		}

	}
}
