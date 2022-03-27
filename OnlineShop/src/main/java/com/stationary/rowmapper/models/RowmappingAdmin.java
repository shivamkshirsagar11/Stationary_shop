package com.stationary.rowmapper.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.stationary.entities.AdminMain;


public class RowmappingAdmin implements RowMapper<AdminMain> {
	public AdminMain mapRow(ResultSet rs, int rowNum) throws SQLException {
		try {
			AdminMain obj = new AdminMain();
			obj.setId(rs.getInt("id"));
			obj.setAdminUserId(rs.getInt("admin"));
		return obj;
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}
}
