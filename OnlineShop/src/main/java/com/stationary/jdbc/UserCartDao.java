package com.stationary.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.stationary.entities.UserCart;
import com.stationary.rowmapper.models.RowMappingUserCart;

import java.util.List;

@Repository
public class UserCartDao {
	
	private List<UserCart> ucl;
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

	public UserCartDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<UserCart> getAllCartItems(int cartId) {
		String query = "select * from UserCart where cartId = ?";
		List<UserCart> ucl = jt.query(query, new RowMappingUserCart(),cartId);
		this.ucl = ucl;
		return ucl;
	}
	
	public boolean deleteAll() {
		try {
			for(UserCart i : this.ucl) {
				ht.delete(i);
			}
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			return false;
		}
	}
}
