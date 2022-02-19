
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet(urlPatterns = {"/solved"})
public class Solved extends HttpServlet{
	private static final long serialVersionUID = -830271168337258325L;
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(300);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			out.print("<html><head><title>Solved complaints</title><link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'></head>"); 
			
			out.print("<nav class='navbar navbar-dark bg-dark'><div class='container-fluid'><a class='navbar-brand' href='#'>Stationary Shop</a><a class='navbar-brand navbar-right' href='login.jsp'>Log out</a></div></nav><br><br>");
		
			
		String url = "jdbc:mysql://localhost:3306/stationary";
		Connection conn = DriverManager.getConnection(url,"root","2002");
		Statement stm = conn.createStatement();
		Statement stm2 = conn.createStatement();
		String q = "select * from complaint";
		ResultSet rs = stm.executeQuery(q),rs2,rs3;
		String name="";
		String s2;
		out.print("<div class='container'>");
		while(rs.next()){
			String s1="<table border='2px solid brown' class='table table-striped'>";
			out.print(s1);
			rs2 = stm2.executeQuery("select * from users where mobile='"+rs.getString("mobile")+"'");
			if(rs2.next()) {
				name = rs2.getString("name");
			rs3 = stm2.executeQuery("select * from solved where token='"+rs.getString("token")+"'");
			if(rs3.next()){
		s2 = "<tr><th>Name</th><td>"+name+"</td><td></tr>"+
				"<tr><th>Email</th><td>"+rs.getString("email")+"</td><td></tr>"+
				"<tr><th>Complaint Token</th><td>"+rs3.getString("token")+"</td><td></tr>"+
				"<tr><th>Category</th><td>"+rs.getString("catagory")+"</td><td></tr>"+
				"<tr><th>Complaint</th><td>"+rs.getString("problem")+"</td><td></tr>"+
				"<tr><th>Complaint date</th><td>"+rs.getString("cdate")+"</td><td></tr>"+
				"<tr><th>Solving date</th><td>"+rs3.getString("sdate")+"</td><td></tr>"+
				"<tr><th>Website's Feedback</th><td>"+rs3.getString("solmsg")+"</td><td></tr>";
		out.print(s2+"</table>");
			}
			}
		}
		String home = "<div class='container' style='max-width:50%;'><h4><button class='btn btn-dark' onclick=\"history.back()\" >Go Back</button></h4></div></div>";
		out.print(home);
	}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

	}

}
