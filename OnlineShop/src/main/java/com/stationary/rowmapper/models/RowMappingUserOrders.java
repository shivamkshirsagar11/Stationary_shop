package com.stationary.rowmapper.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.stationary.entities.UserCart;
import com.stationary.entities.UserOrders;
import com.stationary.jdbc.UserCartDao;

public class RowMappingUserOrders implements RowMapper<UserOrders> {
	public UserOrders mapRow(ResultSet rs, int rowNum) throws SQLException {
		try {
		UserOrders uo = new UserOrders();
		uo.setId(rs.getInt("id"));
		uo.setOrderId(rs.getString("orderId"),false);
		uo.setOrderingDate(rs.getString("orderingDate"));
		uo.setTotal(rs.getInt("total"));
		uo.setUserId(rs.getInt("userId"));
		uo.setCartId(rs.getInt("cartId"));
		return uo;
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}
}
