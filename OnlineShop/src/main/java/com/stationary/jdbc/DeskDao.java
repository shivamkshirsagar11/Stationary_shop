package com.stationary.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.stationary.Items.Desk;

public class DeskDao{
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

	
	public int insertObj(Desk p) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int deleteObj(Desk p) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int updateObj(Desk p) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Desk getOneObj(Desk p) {
		// TODO Auto-generated method stub
		return null;
	}

}
