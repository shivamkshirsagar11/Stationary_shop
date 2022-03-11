package com.stationary.jdbc;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.stationary.entities.User;
import com.stationary.rowmapper.models.RowMappingUser;

public class UserDao{
private HibernateTemplate ht;
	private JdbcTemplate jt;
	
	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	public HibernateTemplate getHt() {
		return ht;
	}
	
	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	
	@Transactional
	public int insertObj(User p) {
		ht.save(p);
		return 1;
	}

	
	public int deleteObj(User p) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int updateObj(User p) {
		// TODO Auto-generated method stub
		return 0;
	}

	public User getUser(String email,String psw) {
		try {
		String query = "select * from user where email=? and password = ?";
		RowMapper<User> row  = new RowMappingUser();
		User s = jt.queryForObject(query, row, email, psw);
		return s;
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}

}
