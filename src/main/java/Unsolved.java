
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
@WebServlet(urlPatterns = {"/unsolved"})
public class Unsolved extends HttpServlet{
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
		String q = "select * from complaint where token not in(select token from solved)";
		ResultSet rs = stm.executeQuery(q),rs2;
		String name="";
		String s2;
		out.print("<form class='container' action='commit' method='POST'>");
		while(rs.next()){
			String s1="<table border='2px solid brown' class='table table-striped'>";
			out.print(s1);
			rs2 = stm2.executeQuery("select * from users where mobile='"+rs.getString("mobile")+"'");
			if(rs2.next()) name = rs2.getString("name");
		s2 = "<tr><th>Name</th><td>"+name+"</td><td></tr>"+
				"<tr><th>Email</th><td>"+rs.getString("email")+"</td><td></tr>"+
				"<tr><th>Complaint Token</th><td>"+rs.getString("token")+"</td><td></tr>"+
				"<tr><th>Category</th><td>"+rs.getString("catagory")+"</td><td></tr>"+
				"<tr><th>Complaint</th><td>"+rs.getString("problem")+"</td><td></tr>"+
				"<tr><th>Complaint date</th><td>"+rs.getString("cdate")+"</td><td></tr>"+
				"<tr><th>Complaint Resolve-Feedback</th><td><textarea rows='7' cols='50' value='####' name='"+rs.getString("token")+"'></textarea></td><td></tr>";
		out.print(s2+"</table>");
		}
		String home = "<button class='btn btn-dark'>Commit changes</button></form>"
				+ "<div class='container' style='max-width:50%;'><h4><button class='btn btn-dark' onclick=\"history.back()\" >Go Back</button></h4></div>";
		out.print(home);
	}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

	}

}
