
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/consumer"})
public class consumer extends HttpServlet {
	private static final long serialVersionUID = 3877407704355559404L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		PrintWriter out = response.getWriter();		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/stationary";
			Connection conn = DriverManager.getConnection(url,"root","2002");
			Statement stm = conn.createStatement();
			response.setContentType("text/html");
			String name = (String)request.getParameter("name");
			String mobile = (String)request.getParameter("mobile");
			String email = (String)request.getParameter("email");
			String dob = (String)request.getParameter("dob");
			String add1 = (String)request.getParameter("address");
			String city = (String)request.getParameter("city");
			String pincode = (String)request.getParameter("pincode");
			String dt = null;
			
			String query = "select * from users where mobile = '" + mobile + "';";
			ResultSet rs = stm.executeQuery(query);
			boolean found = false;
			if(rs.next())
			{
				found = true;
			}
			
			if(found == false)
			{
				query = "insert into users(name, mobile, dob, address, city, pin, last_login,email) values('"+name+"','"+mobile+"', '"+dob+"', '"+add1+"', '"+city+"', '"+pincode+"', '"+dt+"', '"+email+"')";
			
				out.print(name);
				stm.executeUpdate(query);
				response.sendRedirect("login.jsp");
			}
			
			else {
				request.setAttribute("cuserror","Customer with this moblile already exist!!!" );
				RequestDispatcher rd = request.getRequestDispatcher("newcustomer.jsp");
				rd.include(request, response);
			}
		}
		
		catch(Exception e)
		{
			out.print(e.getLocalizedMessage());
		}
	}
}
