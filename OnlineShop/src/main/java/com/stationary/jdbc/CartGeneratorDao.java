package com.stationary.jdbc;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.stationary.entities.CartGenerator;
import com.stationary.rowmapper.models.RowMappingCartGenerator;
import com.stationary.rowmapper.models.RowMappingUser;

@Repository
public class CartGeneratorDao {
	CartGenerator CGobj;
	@Autowired
	private HibernateTemplate ht;
	
	@Autowired
	private JdbcTemplate jt;

	public CartGeneratorDao() {
		super();
		// TODO Auto-generated constructor stub
	}

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
	
	public CartGenerator getCart(int userId) {
		try {
			String query = "select * from CartGenerator where userId=?";
			RowMapper<CartGenerator> row  = new RowMappingCartGenerator();
			CartGenerator cg = jt.queryForObject(query, row, userId);
			this.CGobj = cg;
			return cg;
			}
			catch(Exception e) {
				System.out.println(e.getLocalizedMessage());
				this.CGobj = null;
				return null;
			}
	}
	@Transactional
	public int addCart(CartGenerator cg) {
		return (int) ht.save(cg);
	}
	@Transactional
	public boolean deleteCart() {
		try {
			ht.delete(this.CGobj);
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			return false;
		}
	}
}
