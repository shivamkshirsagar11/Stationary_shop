package com.stationary.jdbc;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.stationary.entities.User;

public class UserDao implements CommonInterfaceDao<User> {
	@Autowired
private HibernateTemplate ht;
	
	public HibernateTemplate getHt() {
		return ht;
	}
	
	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	@Override
	@Transactional
	public int insertObj(User p) {
		ht.save(p);
		return 1;
	}

	@Override
	public int deleteObj(User p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateObj(User p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User getOneObj(User p) {
		// TODO Auto-generated method stub
		return null;
	}

}
