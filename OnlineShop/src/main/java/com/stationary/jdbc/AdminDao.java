package com.stationary.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.stationary.entities.AdminMain;
import com.stationary.rowmapper.models.RowmappingAdmin;

@Repository
public class AdminDao {
	@Autowired
	private HibernateTemplate ht;
	@Autowired
	private JdbcTemplate jt;
	
	public AdminMain getAdminById(int id) {
		return ht.get(AdminMain.class, id);
	}
	
	public boolean getAdminByAdminId(int adminId) {
		try {
			String query = "select * from AdminMain where admin=?";
			RowMapper<AdminMain> row  = new RowmappingAdmin();
			AdminMain s = jt.queryForObject(query, row, adminId);
			if(s != null) return true;
			else return false;
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			return false;
		}
	}
}
