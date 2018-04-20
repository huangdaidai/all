package com.dd.autoCreate.service;

import java.sql.ResultSet;
import java.util.List;

import com.dd.autoCreate.model.DataSource;
import com.dd.autoCreate.model.Field;
import com.dd.autoCreate.model.Table;

public interface UserDBService {
	List<Table> getTables(DataSource dataSource);
	List<Field> getFields(String tableName);
	ResultSet getResultSet(DataSource dataSource);
	
}
