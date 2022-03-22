package com.stationary.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.stationary.entities.UserCart;
import com.stationary.rowmapper.models.RowMappingUserCart;

import java.util.List;

import javax.transaction.Transactional;

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
	@Transactional
	public int addItems(UserCart uc) {
		ht.save(uc);
		return 1;
	}
	
	public UserCart getItemsByCartidAndProductid(int cartId,String productId) {
		try {
		String query = "select * from UserCart where cartId = ? and itemId = ?";
		RowMapper<UserCart> row = new RowMappingUserCart();
		UserCart ucp = jt.queryForObject(query, row,cartId,productId);
		return ucp;
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}
	
	@Transactional
	public void deleteAnItem(int cartId, String productId) {
		try {
			ht.delete(getItemsByCartidAndProductid(cartId, productId));
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	public List<UserCart> getAllCartItems(int cartId) {
		String query = "select * from UserCart where cartId = ?";
		List<UserCart> ucl = jt.query(query, new RowMappingUserCart(),cartId);
		this.ucl = ucl;
		return ucl;
	}
	
	@Transactional
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
	
	@Transactional
	public void incrementItem(int cartId, String productId, int qty) {
		try {
			jt.update("update UserCart set itemCount = ? where cartId = ? and itemId = ?",qty,cartId,productId);
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	@Transactional
	public void decrementItem(int cartId, String productId, int qty) {
		try {
			jt.update("update UserCart set itemCount = ? where cartId = ? and itemId = ?",qty,cartId,productId);
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}
