
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet(urlPatterns = {"/editcus"})
public class editdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/stationary";
			Connection conn = DriverManager.getConnection(url,"root","2002");
			Statement stm = conn.createStatement();
			response.setContentType("text/html");
			String name = (String)request.getParameter("name");
			String mobile = (String)session.getAttribute("mob");
			String email = (String)request.getParameter("email");
			String dob = (String)request.getParameter("dob");
			String add = (String)request.getParameter("address");
			String city = (String)request.getParameter("city");
			String pincode = (String)request.getParameter("pincode");
			out.print(email);
		
		
		String query = "update users set name = '"+name+"', dob = '"+dob+"',  address = '"+add+"', city = '"+city+"', pin = '"+pincode+"', email = '"+email+"' where mobile = '"+mobile+"'";
			stm.executeUpdate(query);
			response.sendRedirect("login.jsp");
		}
		
		catch(Exception e)
		{
			out.print(e.getLocalizedMessage());
		}
	}
}
