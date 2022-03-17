package com.stationary.jdbc;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.stationary.entities.User;
import com.stationary.rowmapper.models.RowMappingUser;
@Repository
public class UserDao{
	@Autowired
	private HibernateTemplate ht;
	
	@Autowired
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

	public User getUserByEmailAndPassword(String email,String psw) {
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
	
	public User getUserById(int id) {
		return ht.get(User.class, id);
	}

}
