package com.stationary.jdbc.advanced;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.mvc.method.annotation.ContinuationHandlerMethodArgumentResolver;

import com.stationary.jdbc.BookDao;
import com.stationary.jdbc.CalcDao;
import com.stationary.jdbc.DeskDao;
import com.stationary.jdbc.PenDao;
@Repository
public class ItemMiddleware {
	@Autowired
	BookDao bookdao;
	
	public BookDao getBookdao() {
		return bookdao;
	}

	public void setBookdao(BookDao bookdao) {
		this.bookdao = bookdao;
	}

	public PenDao getPendao() {
		return pendao;
	}

	public void setPendao(PenDao pendao) {
		this.pendao = pendao;
	}

	public DeskDao getDeskdao() {
		return deskdao;
	}

	public void setDeskdao(DeskDao deskdao) {
		this.deskdao = deskdao;
	}

	public CalcDao getCalcdao() {
		return calcdao;
	}

	public void setCalcdao(CalcDao calcdao) {
		this.calcdao = calcdao;
	}

	@Autowired
	PenDao pendao;
	
	@Autowired
	DeskDao deskdao;
	
	@Autowired
	CalcDao calcdao;

	public ItemMiddleware() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void findItemAndAddStock(String id,int changeInStock) {
		System.out.println("Not in implimentation stage!!!!");
	}
	
	public void findItemAndReduceStock(String id,int changeInStock) {
		int goIn = bookdao.minusStock(id, changeInStock);
		if(goIn == 0) goIn = pendao.minusStock(id, changeInStock);
		if(goIn == 0) goIn = deskdao.minusStock(id, changeInStock);
		if(goIn == 0) goIn = calcdao.minusStock(id, changeInStock);
	}
}
