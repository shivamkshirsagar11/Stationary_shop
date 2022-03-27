package com.stationary.jdbc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.stationary.entities.UserCart;
import com.stationary.entities.UserOrders;
import com.stationary.rowmapper.models.RowMappingUserCart;
import com.stationary.rowmapper.models.RowMappingUserOrders;

@Repository
public class UserOrderDao {
	@Autowired
	private HibernateTemplate ht;
	
	@Autowired
	private JdbcTemplate jt;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	@Transactional
	public String saveThisOrder(UserOrders uo) {
		try {
			ht.save(uo);
			return "order saved";
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			return "some error happened";
		}
	}
	
	public List<UserOrders> getAllOrders(int userId){
		try {
			String query = "select * from UserOrders where userId = ?";
			List<UserOrders> uol = jt.query(query, new RowMappingUserOrders(),userId);
			return uol;
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}
	
	public int getAllOrdersCount(int userId){
		try {
			String query = "select * from UserOrders where userId = ?";
			List<UserOrders> uol = jt.query(query, new RowMappingUserOrders(),userId);
			return uol.size();
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			return 0;
		}
	}
}
