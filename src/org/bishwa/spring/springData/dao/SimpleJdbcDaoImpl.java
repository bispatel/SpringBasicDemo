package org.bishwa.spring.springData.dao;



import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.stereotype.Component;

@Component
public class SimpleJdbcDaoImpl extends SimpleJdbcDaoSupport {
 

	public int getCircleCount() {
		String sql = "select count(*) from circle";
		return this.getSimpleJdbcTemplate().queryForInt(sql);
	}

	 
}
