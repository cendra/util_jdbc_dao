package org.util_jdbc_dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface MapperResult {
	
	public Object mapRow(ResultSet rs) throws SQLException;

}
