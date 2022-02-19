
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.Date;
@WebServlet(urlPatterns = {"/afterlogin"})
public class displayAfterLogin extends HttpServlet{
	private static final long serialVersionUID = 1L;
 public void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
	 PrintWriter out = response.getWriter();
	 HttpSession session = request.getSession();
	 session.setMaxInactiveInterval(300);
	 try {
		 
		 out.print("<html><head><title>Customer Home</title><link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'></head>"); 
		 String m = request.getParameter("psw"),dob = request.getParameter("dobl");
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 	String url = "jdbc:mysql://localhost:3306/stationary";
			Connection conn = DriverManager.getConnection(url,"root","2002");
			Statement stm = conn.createStatement();
		 response.setContentType("text/html");
		 String query = "select * from users where mobile ='"+m+"' and dob = '"+dob+"'";
		 ResultSet rs = stm.executeQuery(query);
		 if(!rs.next()) {
			 request.setAttribute("loginError", "Customer not found! try again!!!");
			 RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			 rd.include(request, response);
		 }
		 else {
			 
		  Date currentDate = new Date();
		  SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MMM/yyyy");
		  String dateOnly = dateFormat.format(currentDate);
		 
		 out.print("<nav class='navbar navbar-dark bg-dark'><div class='container-fluid'><a class='navbar-brand' href='#'>Stationary Shop</a><div class='navbar-brand navbar-right'>"+dateOnly+"</div></div></nav>");
		query = "select * from users where mobile ='"+m+"'";
		 rs = stm.executeQuery(query);
		 String uname="";int idc=-1;
		 if(rs.next()) {
			 idc = rs.getInt("id");
			 uname = rs.getString("name");
		 }
		 query = "select * from admin where id = '"+idc+"'";
		 rs = stm.executeQuery(query);
		 if(rs.next()) {
			response.sendRedirect("admin.jsp");
		 }
		 else {
		 String s = "<div class='container' style='max-width:50%;'><h2>Welcome "+uname+"</h2>\r\n"
		 		+ "<h3>Enjoy our website!</h3>\r\n"
		 		+ "<h4>Choose from below</h4>";
		 out.print(s);
		 String s2 = "<ul>\r\n"
		 		+ "  <li><a href=\"customer\" class='btn btn-primary'>Customer details</a></li>\r\n<br>"
		 		+ "  <li><a href='allorder' class='btn btn-primary'>All order details</a></li>\r\n<br>"
		 		+ "  <li><a href=\"itemlist\" class='btn btn-primary'>Buy From Our Store</a></li>\r\n<br>"
		 		+ "  <li><a href=\"complaint.jsp\" class='btn btn-warning'>Having any isseue let us know</a></li><br>"
		 		+ "  <li><a href='pastissue' class='btn btn-warning'>Your past complaints</a></li>\r\n"
		 		+ "</ul> ";
		 out.print(s2);
		 session.setAttribute("mob", m);session.setAttribute("name", uname);
		 Date d = new Date();
		 String q = "update users set last_login='"+d+"' where mobile='"+m+"'";
		 stm.executeUpdate(q);
		 out.print("<h4><a href=\"login.jsp\" class='btn btn-danger'>Logout</a></h4></div>");
		 }
		 }
	 }
	 catch(Exception e) {
		 System.out.println(e.getLocalizedMessage());
	 }
 }
}
