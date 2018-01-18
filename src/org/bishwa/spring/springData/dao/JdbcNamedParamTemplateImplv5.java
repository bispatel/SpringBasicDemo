package org.bishwa.spring.springData.dao;

import java.sql.Connection;
import javax.sql.DataSource;
import org.bishwa.spring.springData.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class JdbcNamedParamTemplateImplv5 {
	Connection conn = null;
	Circle circle = null;

	private DataSource dbcpDataSource;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate; 

	public DataSource getDbcpDataSource() {
		return dbcpDataSource;
	}

	@Autowired
	public void setDbcpDataSource(DataSource dbcpDataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dbcpDataSource);
	}
	
	public void insertCircleUsingNamedParamTemplete(Circle circle) {
		String sql = "INSERT INTO CIRCLE(ID,NAME) VALUES(:id,:name)";
		SqlParameterSource namedParams = new MapSqlParameterSource("id",circle.getId())
				                             .addValue("name", circle.getName());
		namedParameterJdbcTemplate.update(sql, namedParams);
	}
	 

}
