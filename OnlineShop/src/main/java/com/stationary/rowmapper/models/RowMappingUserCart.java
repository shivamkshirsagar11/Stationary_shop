package com.stationary.rowmapper.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.stationary.entities.UserCart;

public class RowMappingUserCart implements RowMapper<UserCart>{
	public UserCart mapRow(ResultSet rs, int rowNum) throws SQLException {
		try {
		UserCart uc = new UserCart();
		uc.setId(rs.getInt("id"));
		uc.setCartId(rs.getInt("cartId"));
		uc.setDateAndTime(rs.getString("DateAndTime"));
		uc.setItemCount(rs.getInt("ItemCount"));
		uc.setItemId(rs.getString("itemId"));
		uc.setItemName(rs.getString("itemName"));
		uc.setItemPrice(rs.getInt("itemPrice"));
		uc.setUserId(rs.getInt("userId"));
		uc.setImageUrl(rs.getString("imageUrl"));
		return uc;
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}
}
