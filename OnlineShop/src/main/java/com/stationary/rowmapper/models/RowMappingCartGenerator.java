package com.stationary.rowmapper.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.stationary.entities.CartGenerator;

public class RowMappingCartGenerator implements RowMapper<CartGenerator>{
	public CartGenerator mapRow(ResultSet rs, int rowNum) throws SQLException {
		try {
		CartGenerator cg = new CartGenerator();
		cg.setId(rs.getInt("id"));
		cg.setUserId(rs.getInt("userId"));
		cg.setCartGenerationDate(rs.getString("cartGenerationDate"));
		return cg;
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}
}
