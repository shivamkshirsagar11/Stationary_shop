
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@WebServlet(urlPatterns = {"/customer"})
public class customer extends HttpServlet {
	private static final long serialVersionUID = 1L;
public void service(HttpServletRequest request,HttpServletResponse res) throws IOException {
	PrintWriter out = res.getWriter();
	HttpSession session = request.getSession();
	session.setMaxInactiveInterval(300);
	res.setContentType("text/html");
	try {
		
		out.print("<html><head><title>Customer Home</title><link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'></head>"); 
		
		 out.print("<nav class='navbar navbar-dark bg-dark'><div class='container-fluid'><a class='navbar-brand' href='#'>Stationary Shop</a><div class='navbar-brand navbar-right'><a href='login.jsp' class='btn btn-dark'>Logout</a></div></div></nav>");
		
		String start="<div class='container' style='max-width:50%;margin-top:4.2%;'><table border='2px solid green' class='table table-striped'>",start2; 
		Class.forName("com.mysql.cj.jdbc.Driver");
		out.print(start);
		String url = "jdbc:mysql://localhost:3306/stationary";
		Connection conn = DriverManager.getConnection(url,"root","2002");
		Statement stm = conn.createStatement();
		String query = "select * from users where `mobile` = '"+session.getAttribute("mob")+"'";
		ResultSet rs = stm.executeQuery(query);
		while(rs.next()){
			
			start2 = "<tr><th>Customer Unique Id</th><td>"+rs.getString("id")+"</td></tr><tr><th>Name</th><td>"+rs.getString("name")+"</td></tr><tr><th>Address</th><td>"+rs.getString("address")+"</td></tr><tr><th>City</th><td>"+rs.getString("city")+"</td></tr><tr><th>Date Of Birth</th><td>"+rs.getString("dob")+"</td></tr><tr><th>Pincode</th><td>"+rs.getString("pin")+"</td></tr><tr><th>Contact No.</th><td>"+rs.getString("mobile")+"</td></tr><tr><th>Customer Last login </th><td>"+rs.getString("last_login")+"</td></tr></table></div>";
			out.print(start2);
		}
		String home = "<div class='container' style='max-width:50%;'><h4><a class='btn btn-warning' href='changedetail.jsp' >Change Details</a></h4><button class='btn btn-primary' style='allign-item:center;' onclick='history.back()'>Go Back</button></div>";
		out.print(home);
	}
	catch(Exception e) {
		System.out.println("There was some error in/n"+e.getLocalizedMessage());
	}
}
}
