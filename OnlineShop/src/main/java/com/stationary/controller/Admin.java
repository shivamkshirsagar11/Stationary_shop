package com.stationary.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.stationary.Items.*;
import com.stationary.jdbc.*;

@Controller
public class Admin {
	@Autowired
	BookDao bookdao;
	
	@Autowired
	PenDao pendao;
	
	@Autowired
	DeskDao deskdao;
	
	@Autowired
	CalcDao calcdao;
	
	@RequestMapping("/bookform")
	public String bookForm()
	{
		return "add-book";
	}
	
	@RequestMapping("/penform")
	public String penForm()
	{
		return "add-pen";
	}
	
	@RequestMapping("/calcform")
	public String calcForm()
	{
		return "add-calc";
	}
	
	@RequestMapping("/deskform")
	public String deskForm()
	{
		return "add-desk";
	}
	
	@RequestMapping(path = "/admin")
	public ModelAndView admin()
	{
		List<Book> books = this.bookdao.getall();
		List<Pen> pens = this.pendao.getall();
		List<Desk> desks = this.deskdao.getall();
		List<Calc> calc = this.calcdao.getall();
		ModelAndView model = new ModelAndView("admin-product");
		model.addObject("books", books);
		model.addObject("pen", pens);
		model.addObject("desk", desks);
		model.addObject("calc", calc);
		return model;
	}
	
	@RequestMapping(path = "/addbook", method = RequestMethod.POST)
	public ModelAndView addBook(
			@RequestParam("pic") MultipartFile file,
			@RequestParam("pid") String pid, 
			@RequestParam("pname") String pname, 
			@RequestParam("pdesc") String pdesc, 
			@RequestParam("compname") String comp, 
			@RequestParam("price") int price, 
			@RequestParam("stock") int stock, 
			@RequestParam("author") String author, 
			@RequestParam("pages") int pages
			) throws IOException
	{
		byte[] data = file.getBytes();
		Book book = new Book(pid, pname, pdesc, comp, price, stock, author, pages, data);
		bookdao.insertObj(book);
		return new ModelAndView("redirect:" + "admin");
	}
	
	
	@RequestMapping(path = "/addpen", method = RequestMethod.POST)
	public ModelAndView addPen(
			@RequestParam("pic") MultipartFile file,
			@RequestParam("pid") String pid, 
			@RequestParam("pname") String pname, 
			@RequestParam("pdesc") String pdesc, 
			@RequestParam("compname") String comp, 
			@RequestParam("price") int price, 
			@RequestParam("stock") int stock, 
			@RequestParam("color") String color
			) throws IOException
	{
		byte[] data = file.getBytes();
		Pen pen = new Pen(pid, pname, pdesc, comp, price, stock, color, data);
		pendao.insertObj(pen);
		return new ModelAndView("redirect:" + "admin");
	}
	
	@RequestMapping(path = "/adddesk", method = RequestMethod.POST)
	public ModelAndView addDesk(
			@RequestParam("pic") MultipartFile file,
			@RequestParam("pid") String pid, 
			@RequestParam("pname") String pname, 
			@RequestParam("pdesc") String pdesc, 
			@RequestParam("compname") String comp, 
			@RequestParam("price") int price, 
			@RequestParam("stock") int stock, 
			@RequestParam("material") String material
			) throws IOException
	{
		byte[] data = file.getBytes();
		Desk desk = new Desk(pid, pname, pdesc, comp, price, stock, material, data);
		deskdao.insertObj(desk);
		return new ModelAndView("redirect:" + "admin");
	}
	
	
	@RequestMapping(path = "/addcalc", method = RequestMethod.POST)
	public ModelAndView addCalc(
			@RequestParam("pic") MultipartFile file,
			@RequestParam("pid") String pid, 
			@RequestParam("pname") String pname, 
			@RequestParam("pdesc") String pdesc, 
			@RequestParam("compname") String comp, 
			@RequestParam("price") int price, 
			@RequestParam("stock") int stock, 
			@RequestParam("type") String type
			) throws IOException
	{
		byte[] data = file.getBytes();
		Calc calc = new Calc(pid, pname, pdesc, comp, price, stock, type, data);
		calcdao.insertObj(calc);
		return new ModelAndView("redirect:" + "admin");
	}
	
	@RequestMapping("/deletebook")
	public ModelAndView removeBook(@RequestParam("pid") String pid)
	{
		int id = Integer.parseInt(pid);
		Book b = bookdao.getOneObj(id);
		bookdao.deleteObj(b);
		return new ModelAndView("redirect:" + "admin");
	}
	
	@RequestMapping("/deletepen")
	public ModelAndView removePen(@RequestParam("pid") String pid)
	{
		int id = Integer.parseInt(pid);
		Pen p = pendao.getOneObj(id);
		pendao.deleteObj(p);
		return new ModelAndView("redirect:" + "admin");
	}
	
	@RequestMapping("/deletedesk")
	public ModelAndView removeDesk(@RequestParam("pid") String pid)
	{
		int id = Integer.parseInt(pid);
		Desk d = deskdao.getOneObj(id);
		deskdao.deleteObj(d);
		return new ModelAndView("redirect:" + "admin");
	}
	
	@RequestMapping("/deletecalc")
	public ModelAndView removeCalc(@RequestParam("pid") String pid)
	{
		int id = Integer.parseInt(pid);
		Calc c = calcdao.getOneObj(id);
		calcdao.deleteObj(c);
		return new ModelAndView("redirect:" + "admin");
	}
	
}