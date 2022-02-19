
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@WebServlet(urlPatterns = {"/processcomplaint"})
public class processComplaint extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest request,HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(300);
		res.setContentType("text/html");
		try {Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/stationary";
			Connection conn = DriverManager.getConnection(url,"root","2002");
			Statement stm = conn.createStatement();
			
			String q1 = "select * from sidgetter";
			ResultSet rs2 = stm.executeQuery(q1);
			String token = "Complaint_Token_REFID_";
			if(rs2.next())token += rs2.getString("sid");
			q1 ="UPDATE ctoken set token = token+1 where token = token";
			stm.executeUpdate(q1);
			
			String mobile = (String) session.getAttribute("mob");
			String ord = request.getParameter("ordid");
			String opt = request.getParameter("option");
			String complaint = request.getParameter("comp");
			String d = new Date().toString();
			String query = "select * from orderhistory where sid ='"+ord+"' and id in(select id from users where mobile='"+mobile+"')";
			ResultSet rs = stm.executeQuery(query);
			if(!rs.next()) {
				request.setAttribute("error", "Invalid ORDER id");
				RequestDispatcher rd = request.getRequestDispatcher("complaint.jsp");
				rd.include(request, res);
			}
			else {
				query = "select * from users where mobile = '"+mobile+"'";
				rs = stm.executeQuery(query);
				String email="";
				if(rs.next()) email = rs.getString("email");
				query = "insert into complaint (email,mobile, problem, token, cdate, ordid,catagory) values ('"+ email + "', '" + mobile+ "', '" +complaint+ "', '" + token + "', '" +d+ "', '" + ord+ "', '" +opt+ "')";
				stm.executeUpdate(query);
				request.setAttribute("success", "Your Complaint registered Complaint token: "+token);
				RequestDispatcher rd = request.getRequestDispatcher("complaint.jsp");
				rd.include(request, res);
			}
			
		}
		catch(Exception e) {
			System.out.println("There was some error in/n"+e.getLocalizedMessage());
		}
	}
}
