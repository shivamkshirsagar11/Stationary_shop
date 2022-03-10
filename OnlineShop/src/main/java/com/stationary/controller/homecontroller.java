package com.stationary.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.stationary.entities.Address;
import com.stationary.entities.User;
import com.stationary.jdbc.CommonInterfaceDao;
import com.stationary.jdbc.UserDao;

@Controller
public class homecontroller {
	
	@RequestMapping("/")
	public String home()
	{
		return "login";
	}
	
	@RequestMapping("/index")
	public String index()
	{
		return home();
	}
	
	@RequestMapping(path = "/saveuser",method = RequestMethod.POST)
	public String saveuser(@RequestParam(name = "name",required=false)String name,
						 @RequestParam(name = "email",required=false)String email,
						 @RequestParam(name = "mobile",required=false)String mobile,
						 @RequestParam(name = "hNo",required=false)String hno,
						 @RequestParam(name = "add1",required=false)String add1,
						 @RequestParam(name = "add2",required=false)String add2,
						 @RequestParam(name = "city",required=false)String city,
						 @RequestParam(name = "pincode",required=false)String zip,
						 @RequestParam(name = "psw",required=false)String psw)
	{
		Address a = new Address(hno,add1,add2,city,zip);
		User u = new User(name,psw,mobile,email,new Date().toString(),a);
		u.setAddress(a);
		ApplicationContext app = new ClassPathXmlApplicationContext("spring.config.xml");
		CommonInterfaceDao<User> SQL = (CommonInterfaceDao<User>) app.getBean("queryFetcherUser");
//		CommonInterfaceDao<User> user = new UserDao();
		SQL.insertObj(u);
		return "login";
	}
	@RequestMapping("/signup")
	public String signup()
	{
		return "signup";
	}
	
	@RequestMapping("/login")
	public String login()
	{
		return "login";
	}
}
