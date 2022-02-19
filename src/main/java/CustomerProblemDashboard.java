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

@WebServlet(urlPatterns = {"/pastissue"})

public class CustomerProblemDashboard extends HttpServlet{
	private static final long serialVersionUID = 1550573672087816757L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/stationary";
			Connection conn = DriverManager.getConnection(url, "root", "2002");
			Statement stm = conn.createStatement();
			Statement stm2 = conn.createStatement();
			response.setContentType("text/html");
			out.print("<html><head><title>Past Problems</title><link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'></head>");
			
			String mobile =(String) session.getAttribute("mob");
			out.print("<nav class='navbar navbar-dark bg-dark'><div class='container-fluid'><a class='navbar-brand' href='#'>Stationary Shop</a><a class='navbar-brand navbar-right' href='login.jsp'>Log out</a></div></nav>");
			
			
			
			String query = "select * from complaint where mobile = '" + mobile +"'",status="";
			ResultSet rs = stm.executeQuery(query),rs2;
			out.print("<div class='container' style='max-width:70%'><h4>Your all Complains</h4>");
			while(rs.next())
			{
				
				out.print("<table class='table table-striped' border='5px dotted brown'>");
				out.print("<tr><th>Token ID</th><td>"+rs.getString("token")+"</td></tr><tr><th>Complain Date</th><td>"+ rs.getString("cdate") + "</td></tr><tr><th>Catagory</th><td>"+ rs.getString("catagory")+"</td></tr><tr><th>Issue</th><td>"+rs.getString("problem")+"</td></tr>");
				query = "select * from solved where token = '" + rs.getString("token") +"'";
				rs2 = stm2.executeQuery(query);
				if(rs2.next()) {
					status = rs2.getString("solmsg");
					out.print("</td></tr><tr><th>Complain closing date</th><td>"+ rs2.getString("sdate") + "<tr><th>Status of Complain</th><td style='color:green'>"+ status+"</td></tr>" );
				}
				else {
					status ="In Review...Not resolved";
					out.print("<tr><th>Status of Complain</th><td style='color:red'>"+ status+"</td></tr>" );
				}
				
				out.print("</table>");
			}
			
			out.print("<button class='btn btn-dark' onclick='history.back()'>Go Back</button></div>");
			
		}
		
		catch(Exception e)
		{
			out.print(e.getLocalizedMessage());
		}
	
	}
}