package com.stationary.jdbc;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.stationary.Items.Calc;

public class CalcDao implements CommonInterfaceDao<Calc>{
	private HibernateTemplate ht;
	
	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	@Override
	public int insertObj(Calc p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteObj(Calc p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateObj(Calc p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Calc getOneObj(Calc p) {
		// TODO Auto-generated method stub
		return null;
	}

}
