package com.stationary.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.stationary.Items.Book;
import com.stationary.Items.Calc;
import com.stationary.Items.Desk;
import com.stationary.Items.Pen;
import com.stationary.entities.Address;
import com.stationary.entities.CartGenerator;
import com.stationary.entities.User;
import com.stationary.entities.UserCart;
import com.stationary.entities.UserOrders;
import com.stationary.jdbc.BookDao;
import com.stationary.jdbc.CalcDao;
import com.stationary.jdbc.CartGeneratorDao;
import com.stationary.jdbc.DeskDao;
import com.stationary.jdbc.PenDao;
import com.stationary.jdbc.UserCartDao;
import com.stationary.jdbc.UserDao;
import com.stationary.jdbc.UserOrderDao;
import com.stationary.jdbc.advanced.ItemMiddleware;


@Controller
public class CentralControlPanel {
	private int loggedUserId;
	private int usercartId;
	public int getLoggedUserId() {
		return loggedUserId;
	}

	public void setLoggedUserId(int loggedUserId) {
		this.loggedUserId = loggedUserId;
	}
	
	@Autowired
	ItemMiddleware im;
	
	@Autowired
	UserDao SQL;
	
	@Autowired
	BookDao bookdao;
	
	@Autowired
	PenDao pendao;
	
	@Autowired
	DeskDao deskdao;
	
	@Autowired
	CalcDao calcdao;
	
	@Autowired
	CartGeneratorDao cartJDBCObj;
	
	@Autowired
	UserCartDao userCartJDBCObj;
	
	@Autowired
	UserOrderDao userorderJDBCobj;
	
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
	@RequestMapping(path = "/afterlogin",method = RequestMethod.POST)
	public String afterLogin(@RequestParam(name = "email")String email,
			 @RequestParam(name = "psw")String psw,Model m
			 ) {
		User user = SQL.getUserByEmailAndPassword(email, psw);
		
		if (user == null) {
			System.out.println("no user found!!");
			m.addAttribute("error", "No user found!!");
			return "login";
		}
		this.setLoggedUserId(user.getId());
		List<Book> book = this.bookdao.getall();
		List<Pen> pen = this.pendao.getall();
		List<Desk> desk = this.deskdao.getall();
		List<Calc> calc = this.calcdao.getall();
		
		m.addAttribute("user", user);
		m.addAttribute("book", book);
		m.addAttribute("desk", desk);
		m.addAttribute("calc", calc);
		m.addAttribute("pen", pen);
		
		return "index";
	}
	@RequestMapping(path = "/profile",method=RequestMethod.POST)
	public String profile(Model m,@RequestParam(name="userid")int id) {
		User u = SQL.getUserById(id);
		User user = SQL.getUserById(loggedUserId);
		Address add = user.getAddress();
		m.addAttribute("user", u);
		m.addAttribute("add", add);
		return "profile";
	}
	
	@RequestMapping("/cart")
	public String cart(Model m) {
		CartGenerator cg = new CartGenerator();
		cg = cartJDBCObj.getCart(this.getLoggedUserId());
		//System.out.println(this.getLoggedUserId());
		if(cg != null) {
			m.addAttribute("cg", cg);
			this.usercartId = cg.getId();
			List<UserCart> uc = userCartJDBCObj.getAllCartItems(cg.getId());
			
			m.addAttribute("ucl", uc);
		}
		else {
			
			m.addAttribute("nullcarterror", "Nothing in cart right now!!");
		}
		return "cart";
	}
	
	@RequestMapping(path = "/addtocart",method=RequestMethod.POST)
	@ResponseBody
	public String addtocart(@RequestParam(name = "name") String name,
			@RequestParam(name="price")int price,
			@RequestParam(name="id")String id,
			@RequestParam(name="pimg")String pimg,
			@RequestParam(name="qty")int qty) {
		try {
			CartGenerator cg = new CartGenerator();
			cg = cartJDBCObj.getCart(this.getLoggedUserId());
			if(cg != null) {
				this.usercartId = cg.getId();
				UserCart ucp = userCartJDBCObj.getItemsByCartidAndProductid(cg.getId(), id);
				if(ucp == null) {
					System.out.println(ucp);
					ucp = new UserCart();
					ucp.setCartId(cartJDBCObj.getCart(this.getLoggedUserId()).getId());
					ucp.setDateAndTime(new Date().toString());
					ucp.setItemCount(qty);
					ucp.setItemId(id);
					ucp.setItemName(name);
					ucp.setItemPrice(price);
					//System.out.println(pimg);
					ucp.setImageUrl(pimg);
					ucp.setUserId(this.loggedUserId);
					userCartJDBCObj.addItems(ucp);
				}else return "already in cart";
			}
			else {
				cg = new CartGenerator();
				cg.setCartGenerationDate(new Date().toString());
				cg.setUserId(this.loggedUserId);
				cartJDBCObj.addCart(cg);
				UserCart uc = new UserCart();
				uc.setCartId(cartJDBCObj.getCart(this.getLoggedUserId()).getId());
				uc.setDateAndTime(new Date().toString());
				uc.setItemCount(qty);
				uc.setItemId(id);
				uc.setItemName(name);
				uc.setItemPrice(price);
				uc.setImageUrl(pimg);
				uc.setUserId(this.loggedUserId);
				userCartJDBCObj.addItems(uc);
			}
			return "done";
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			return "not done";
		}
	}
	
	
	@RequestMapping(path = "/removefromcart",method=RequestMethod.POST)
	@ResponseBody
	public String removefromcart(@RequestParam(name = "id") String id
			) {
		try {
			userCartJDBCObj.deleteAnItem(usercartId, id);			
			return "done";
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			return "not done";
		}
	}
	
	@RequestMapping(path = "/addone",method=RequestMethod.POST)
	@ResponseBody
	public String addone(@RequestParam(name = "id") String id,
			@RequestParam(name = "qty") int qty
			) {
		try {
			userCartJDBCObj.incrementItem(usercartId, id,qty);		
			return "done";
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			return "not done";
		}
	}
	
	@RequestMapping(path = "/removeone",method=RequestMethod.POST)
	@ResponseBody
	public String removeone(@RequestParam(name = "id") String id,
			@RequestParam(name = "qty") int qty
			) {
		try {
			userCartJDBCObj.decrementItem(usercartId, id,qty);		
			return "done";
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			return "not done";
		}
	}
	
	@RequestMapping(path = "/billing",method=RequestMethod.GET)
	public String generateBill(Model m) {
		try {
			User user = SQL.getUserById(loggedUserId);
			Address ship = user.getAddress();
		List<UserCart> ordersInThisSession = userCartJDBCObj.getAllCartItems(this.usercartId);
		cartJDBCObj.deleteCart();
		for (UserCart i : ordersInThisSession) {
			im.findItemAndReduceStock(i.getItemId(), i.getItemCount());
		}
		UserOrders uo = new UserOrders();
		uo.setOrderId(Integer.toString(this.usercartId),true);
		uo.setOrderingDate(new Date().toString());
		uo.setOrdersPerBatch(ordersInThisSession);
		uo.calculateTotal();
		uo.setUserId(this.loggedUserId);
		uo.setCartId(this.usercartId);
		userorderJDBCobj.saveThisOrder(uo);
		m.addAttribute("bill", uo);
		m.addAttribute("shipping_address", ship);
		return "bill-page";
		}catch(Exception e) {
			User user = SQL.getUserById(loggedUserId);
			Address ship = user.getAddress();
			List<UserCart> ordersInThisSession = userCartJDBCObj.getAllCartItems(this.usercartId);
			for (UserCart i : ordersInThisSession) {
				im.findItemAndReduceStock(i.getItemId(), i.getItemCount());
			}
			UserOrders uo = new UserOrders();
			uo.setOrderId(Integer.toString(this.usercartId),true);
			uo.setOrderingDate(new Date().toString());
			uo.setOrdersPerBatch(ordersInThisSession);
			uo.calculateTotal();
			uo.setUserId(this.loggedUserId);
			uo.setCartId(this.usercartId);
			m.addAttribute("bill", uo);
			m.addAttribute("shipping_address", ship);
			return "bill-page";
		}
	}
	
	@RequestMapping(path = "/all-order",method=RequestMethod.GET)
	public String allOrder(Model m) {
		User user = SQL.getUserById(loggedUserId);
		List<UserOrders> uol = userorderJDBCobj.getAllOrders(loggedUserId);
		for(UserOrders uo: uol) {
			uo.setOrdersPerBatch(userCartJDBCObj.getAllCartItems(uo.getCartId()));
		}
		m.addAttribute("user",user);
		m.addAttribute("orderList",uol);
		return "past-orders";
	}
}
