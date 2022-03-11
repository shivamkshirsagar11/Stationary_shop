package com.stationary.rowmapper.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.stationary.entities.Address;
import com.stationary.entities.User;


public class RowMappingUser implements RowMapper<User>{

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		try {
		User obj = new User();
		Address Aobj = new Address();
		
		Aobj.setAddress1(rs.getString("address1"));
		Aobj.setAddress2(rs.getString("address2"));
		Aobj.setCity(rs.getString("city"));
		Aobj.sethNo(rs.getString("hNo"));
		Aobj.setPincode(rs.getString("pincode"));
		
		obj.setEmail(rs.getString("email"));
		obj.setLastLogin(rs.getString("lastLogin"));
		obj.setMobile(rs.getString("mobile"));
		obj.setName(rs.getString("name"));
		obj.setPassword(rs.getString("password"));
		obj.setId(rs.getInt("id"));
		obj.setAddress(Aobj);
		return obj;
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}

}